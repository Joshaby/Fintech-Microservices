package com.joshaby.fintech.avaliadorcreditoserver.service;

import com.joshaby.fintech.avaliadorcreditoserver.client.ClienteResourceClient;
import com.joshaby.fintech.avaliadorcreditoserver.entity.DadosCliente;
import com.joshaby.fintech.avaliadorcreditoserver.entity.SituacaoCliente;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AvaliadorCreditoService {

    private final ClienteResourceClient clienteResourceClient;

    public SituacaoCliente obterSituacaoCliente(String cpf) {
        ResponseEntity<DadosCliente> dadosCliente = clienteResourceClient.findDados(cpf);
        return SituacaoCliente
                .builder()
                .dadosCliente(dadosCliente.getBody())
                .build();
    }
}
