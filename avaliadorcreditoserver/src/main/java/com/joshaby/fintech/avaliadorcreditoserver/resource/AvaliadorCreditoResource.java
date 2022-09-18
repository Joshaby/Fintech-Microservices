package com.joshaby.fintech.avaliadorcreditoserver.resource;

import com.joshaby.fintech.avaliadorcreditoserver.client.exception.DadosClienteNotFoundException;
import com.joshaby.fintech.avaliadorcreditoserver.client.exception.ErroComunicacaoMicroserviceException;
import com.joshaby.fintech.avaliadorcreditoserver.entity.DadosAvaliacao;
import com.joshaby.fintech.avaliadorcreditoserver.entity.RetornoAvalicaoCliente;
import com.joshaby.fintech.avaliadorcreditoserver.entity.SituacaoCliente;
import com.joshaby.fintech.avaliadorcreditoserver.service.AvaliadorCreditoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    public ResponseEntity consultarSituacaoCliente(@RequestParam("cpf") String cpf) {
        try {
            SituacaoCliente situacaoCliente = avaliadorCreditoService.obterSituacaoCliente(cpf);
            return ResponseEntity.ok(situacaoCliente);
        } catch (DadosClienteNotFoundException e) {
            return ResponseEntity.notFound().build();
        } catch (ErroComunicacaoMicroserviceException e) {
            return ResponseEntity.status(HttpStatus.resolve(e.getStatus())).body(e.getMessage());
        }
    }

    @PostMapping
    public ResponseEntity realizarAvaliacao(@RequestBody DadosAvaliacao dadosAvaliacao) {
        try {
            RetornoAvalicaoCliente retornoAvalicaoCliente =
                    avaliadorCreditoService.realizarAvaliacao(dadosAvaliacao.getCpf(), dadosAvaliacao.getRenda());
            return ResponseEntity.ok(retornoAvalicaoCliente);
        } catch (DadosClienteNotFoundException e) {
            return ResponseEntity.notFound().build();
        } catch (ErroComunicacaoMicroserviceException e) {
            return ResponseEntity.status(HttpStatus.resolve(e.getStatus())).body(e.getMessage());
        }
    }
}
