package com.joshaby.fintech.clienteserver.dto;

import com.joshaby.fintech.clienteserver.entity.Cliente;
import lombok.Data;

@Data
public class ClienteDTO {

    private String cpf;

    private String nome;

    private Integer idade;

    public Cliente toCliente() {
        return new Cliente(cpf, nome, idade);
    }
}
