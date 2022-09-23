package com.joshaby.fintech.avaliadorcreditoserver.service.exception;

import lombok.Getter;

public class ErroComunicacaoMicroserviceException extends Exception {

    @Getter
    private Integer status;

    public ErroComunicacaoMicroserviceException(String message, Integer status) {
        super(message);
        this.status = status;
    }
}
