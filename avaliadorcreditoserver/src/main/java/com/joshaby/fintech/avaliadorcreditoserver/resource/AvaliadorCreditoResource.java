package com.joshaby.fintech.avaliadorcreditoserver.resource;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/avaliador-credito")
public class AvaliadorCreditoResource {

    @GetMapping("/status")
    public String status() {
        return "Ok!";
    }
}
