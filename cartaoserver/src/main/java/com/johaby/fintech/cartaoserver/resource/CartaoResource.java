package com.johaby.fintech.cartaoserver.resource;

import com.johaby.fintech.cartaoserver.dto.CartaoDTO;
import com.johaby.fintech.cartaoserver.entity.Cartao;
import com.johaby.fintech.cartaoserver.service.CartaoService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cartoes")
@Slf4j
@RequiredArgsConstructor
public class CartaoResource {

    private final CartaoService service;

    @GetMapping("/status")
    public String status() {
        log.info("Obtendo o status do microservice de cartões");
        return "Ok";
    }

    @PostMapping
    public ResponseEntity save(@RequestBody CartaoDTO dto) {
        Cartao cartao = dto.toCartao();
        service.save(cartao);
        return ResponseEntity.ok().build();
    }
}
