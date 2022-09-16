package com.joshaby.fintech.avaliadorcreditoserver.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
public class CartaoCliente {

    private String nome;

    private String bandeira;

    private BigDecimal limiteLiberado;
}
