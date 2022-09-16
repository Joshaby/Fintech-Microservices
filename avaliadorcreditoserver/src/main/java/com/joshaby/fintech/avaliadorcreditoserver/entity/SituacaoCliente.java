package com.joshaby.fintech.avaliadorcreditoserver.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class SituacaoCliente {

    private DadosCliente dadosCliente;

    private List<CartaoCliente> cartoes;
}
