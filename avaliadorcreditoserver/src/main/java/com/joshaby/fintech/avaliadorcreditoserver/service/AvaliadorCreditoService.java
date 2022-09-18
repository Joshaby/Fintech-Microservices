package com.joshaby.fintech.avaliadorcreditoserver.service;

import com.joshaby.fintech.avaliadorcreditoserver.client.CartaoResourceClient;
import com.joshaby.fintech.avaliadorcreditoserver.client.ClienteResourceClient;
import com.joshaby.fintech.avaliadorcreditoserver.client.exception.DadosClienteNotFoundException;
import com.joshaby.fintech.avaliadorcreditoserver.client.exception.ErroComunicacaoMicroserviceException;
import com.joshaby.fintech.avaliadorcreditoserver.representation.*;
import feign.FeignException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
@RequiredArgsConstructor
public class AvaliadorCreditoService {

    private final ClienteResourceClient clienteResourceClient;

    private final CartaoResourceClient cartaoResourceClient;

    public SituacaoCliente obterSituacaoCliente(String cpf)
            throws DadosClienteNotFoundException, ErroComunicacaoMicroserviceException {

        try {
            ResponseEntity<DadosCliente> dadosCliente = clienteResourceClient.findDados(cpf);
            ResponseEntity<List<ClienteCartao>> cartoes = cartaoResourceClient.findByCpf(cpf);
            return SituacaoCliente
                    .builder()
                    .dadosCliente(dadosCliente.getBody())
                    .cartoes(cartoes.getBody())
                    .build();
        } catch (FeignException.FeignClientException e) {
            if (e.status() == HttpStatus.NOT_FOUND.value()) {
                throw new DadosClienteNotFoundException();
            }
            throw new ErroComunicacaoMicroserviceException(e.getMessage(), e.status());
        }
    }

    public RetornoAvalicaoCliente realizarAvaliacao(String cpf, Long renda)
            throws DadosClienteNotFoundException, ErroComunicacaoMicroserviceException {

        try {
            ResponseEntity<DadosCliente> dadosClienteResponse = clienteResourceClient.findDados(cpf);
            ResponseEntity<List<Cartao>> cartoesResponse = cartaoResourceClient.findByRendaLessThanEqual(renda);
            List<Cartao> cartoes = cartoesResponse.getBody();
            DadosCliente dadosCliente = dadosClienteResponse.getBody();

            List<CartaoAprovado> cartoesAprovados = cartoes.stream().map(cartao -> {
                BigDecimal limiteBasico = cartao.getLimiteBasico();
                BigDecimal idadeBigDecimal = BigDecimal.valueOf(dadosCliente.getIdade());
                BigDecimal fator = idadeBigDecimal.divide(BigDecimal.valueOf(10));
                BigDecimal limiteAprovado = fator.multiply(limiteBasico);

                CartaoAprovado cartaoAprovado = new CartaoAprovado();
                cartaoAprovado.setCartao(cartao.getNome());
                cartaoAprovado.setBandeira(cartao.getBandeira());
                cartaoAprovado.setLimiteAprovado(limiteAprovado);
                return cartaoAprovado;
            }).toList();
            return new RetornoAvalicaoCliente(cartoesAprovados);
        } catch (FeignException.FeignClientException e) {
            if (e.status() == HttpStatus.NOT_FOUND.value()) {
                throw new DadosClienteNotFoundException();
            }
            throw new ErroComunicacaoMicroserviceException(e.getMessage(), e.status());
        }
    }
}
