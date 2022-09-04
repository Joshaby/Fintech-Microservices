package com.johaby.fintech.cartaoserver.dto;

import com.johaby.fintech.cartaoserver.entity.Cartao;
import com.johaby.fintech.cartaoserver.entity.enumeration.BandeiraCartao;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
public class CartaoDTO {

    private String nome;

    private BandeiraCartao bandeira;

    private BigDecimal renda;

    private BigDecimal limiteBasico;

    public Cartao toCartao() {
        return new Cartao(nome, bandeira, renda, limiteBasico);
    }
}
