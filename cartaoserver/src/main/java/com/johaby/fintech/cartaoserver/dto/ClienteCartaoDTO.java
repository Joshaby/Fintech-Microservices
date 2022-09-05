package com.johaby.fintech.cartaoserver.dto;

import com.johaby.fintech.cartaoserver.entity.ClienteCartao;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ClienteCartaoDTO {

    private String nome;

    private String bandeira;

    private BigDecimal limiteLiberado;

    public static ClienteCartaoDTO fromCartao(ClienteCartao clienteCartao) {
        return new ClienteCartaoDTO(
                clienteCartao.getCartao().getNome(), clienteCartao.getCartao().getBandeira().toString(), clienteCartao.getLimite());
    }
}
