package com.johaby.fintech.cartaoserver.resource;

import com.johaby.fintech.cartaoserver.dto.CartaoDTO;
import com.johaby.fintech.cartaoserver.dto.ClienteCartaoDTO;
import com.johaby.fintech.cartaoserver.entity.Cartao;
import com.johaby.fintech.cartaoserver.entity.ClienteCartao;
import com.johaby.fintech.cartaoserver.service.CartaoService;
import com.johaby.fintech.cartaoserver.service.ClienteCartaoService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cartoes")
@Slf4j
@RequiredArgsConstructor
public class CartaoResource {

    private final CartaoService cartaoService;

    private final ClienteCartaoService clienteCartaoService;

    @GetMapping("/status")
    public String status() {
        log.info("Obtendo o status do microservice de cartões");
        return "Ok";
    }

    @PostMapping
    public ResponseEntity save(@RequestBody CartaoDTO dto) {
        Cartao cartao = dto.toCartao();
        cartaoService.save(cartao);
        return ResponseEntity.ok().build();
    }

    @GetMapping(params = "renda")
    public ResponseEntity<List<Cartao>> findByRendaLessThanEqual(@RequestParam Long renda) {
        List<Cartao> cartoes = cartaoService.findByRendaLessThanEqual(renda);
        return ResponseEntity.ok(cartoes);
    }

    @GetMapping(params = "cpf")
    public ResponseEntity<List<ClienteCartaoDTO>> findByCpf(@RequestParam String cpf) {
        List<ClienteCartao> clienteCartoes = clienteCartaoService.findByCpf(cpf);
        List<ClienteCartaoDTO> dtos = clienteCartoes.stream().map(ClienteCartaoDTO::fromCartao).toList();
        return ResponseEntity.ok(dtos);
    }
}
