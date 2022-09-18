package com.joshaby.fintech.avaliadorcreditoserver.representation;

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
