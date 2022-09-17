package com.joshaby.fintech.avaliadorcreditoserver.entity;

import lombok.*;

import java.util.List;

@Getter
@Setter
@Builder
@AllArgsConstructor
public class SituacaoCliente {

    private DadosCliente dadosCliente;

    private List<ClienteCartao> cartoes;
}
