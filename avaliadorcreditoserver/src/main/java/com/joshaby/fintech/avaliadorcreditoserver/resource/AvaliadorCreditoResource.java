package com.joshaby.fintech.avaliadorcreditoserver.resource;

import com.joshaby.fintech.avaliadorcreditoserver.entity.SituacaoCliente;
import com.joshaby.fintech.avaliadorcreditoserver.service.AvaliadorCreditoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/avaliador-credito")
@RequiredArgsConstructor
public class AvaliadorCreditoResource {

    private final AvaliadorCreditoService avaliadorCreditoService;

    @GetMapping("/status")
    public String status() {
        return "Ok!";
    }

    @GetMapping(value = "/situacao-cliente", params = "cpf")
    public ResponseEntity<SituacaoCliente> consultarSituacaoCliente(@RequestParam("cpf") String cpf) {
        SituacaoCliente situacaoCliente = avaliadorCreditoService.obterSituacaoCliente(cpf);
        return null;
    }
}
