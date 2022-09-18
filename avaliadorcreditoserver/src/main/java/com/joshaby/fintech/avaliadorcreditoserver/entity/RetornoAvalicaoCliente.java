package com.joshaby.fintech.avaliadorcreditoserver.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class RetornoAvalicaoCliente {

    private List<CartaoAprovado> cartoes;
}
