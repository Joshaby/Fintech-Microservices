package com.joshaby.fintech.avaliadorcreditoserver.service;

import com.joshaby.fintech.avaliadorcreditoserver.client.CartaoResourceClient;
import com.joshaby.fintech.avaliadorcreditoserver.client.ClienteResourceClient;
import com.joshaby.fintech.avaliadorcreditoserver.entity.ClienteCartao;
import com.joshaby.fintech.avaliadorcreditoserver.entity.DadosCliente;
import com.joshaby.fintech.avaliadorcreditoserver.entity.SituacaoCliente;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AvaliadorCreditoService {

    private final ClienteResourceClient clienteResourceClient;

    private final CartaoResourceClient cartaoResourceClient;

    public SituacaoCliente obterSituacaoCliente(String cpf) {
        ResponseEntity<DadosCliente> dadosCliente = clienteResourceClient.findDados(cpf);
        ResponseEntity<List<ClienteCartao>> cartoes = cartaoResourceClient.findByCpf(cpf);
        return SituacaoCliente
                .builder()
                .dadosCliente(dadosCliente.getBody())
                .cartoes(cartoes.getBody())
                .build();
    }
}
