package com.joshaby.fintech.avaliadorcreditoserver.representation;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
public class ClienteCartao {

    private String nome;

    private String bandeira;

    private BigDecimal limiteLiberado;
}
