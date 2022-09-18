package com.joshaby.fintech.avaliadorcreditoserver.client;

import com.joshaby.fintech.avaliadorcreditoserver.representation.DadosCliente;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "clienteserver", path = "/clientes")
public interface ClienteResourceClient {

    @GetMapping
    ResponseEntity<DadosCliente> findDados(@RequestParam("cpf") String cpf);
}
