package com.joshaby.fintech.avaliadorcreditoserver.client;

import com.joshaby.fintech.avaliadorcreditoserver.entity.ClienteCartao;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(value = "cartaoserver", path = "/cartoes")
public interface CartaoResourceClient {

    @GetMapping(params = "cpf")
    ResponseEntity<List<ClienteCartao>> findByCpf(@RequestParam String cpf);
}
