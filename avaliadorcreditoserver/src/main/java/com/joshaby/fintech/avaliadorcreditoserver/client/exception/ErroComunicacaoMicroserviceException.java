package com.joshaby.fintech.avaliadorcreditoserver.client.exception;

import lombok.Getter;

public class ErroComunicacaoMicroserviceException extends Exception {

    @Getter
    private Integer status;

    public ErroComunicacaoMicroserviceException(String message, Integer status) {
        super(message);
        this.status = status;
    }
}
