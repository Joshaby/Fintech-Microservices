package com.joshaby.fintech.avaliadorcreditoserver.service.exception;

public class DadosClienteNotFoundException extends Exception{

    public DadosClienteNotFoundException() {
        super("Dados do cliente não encotrados para o CPF informado.");
    }
}
