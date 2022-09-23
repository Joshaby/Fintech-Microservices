package com.johaby.fintech.cartaoserver.representation;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class DadosSolicitacaoEmissaoCartao {

    private Long idCartao;

    private String cpf;

    private String endereco;

    private BigDecimal limiteLiberado;
}
