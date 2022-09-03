package com.joshaby.fintech.clienteserver.resource;

import com.joshaby.fintech.clienteserver.dto.ClienteDTO;
import com.joshaby.fintech.clienteserver.entity.Cliente;
import com.joshaby.fintech.clienteserver.service.ClienteService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.Optional;

@RestController
@RequestMapping("/clientes")
@RequiredArgsConstructor
@Slf4j
public class ClienteResource {

    private final ClienteService service;

//    @GetMapping
//    public String status() {
//        log.info("Obtendo o status do microservice de clientes");
//        return "Ok";
//    }

    @PostMapping
    public ResponseEntity<URI> save(@RequestBody ClienteDTO dto) {
        Cliente cliente = dto.toCliente();
        service.save(cliente);
        URI headerLocation = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .query("cpf={cpf}")
                .buildAndExpand(cliente.getCpf())
                .toUri();
        return ResponseEntity.created(headerLocation).build();
    }

    @GetMapping
    public ResponseEntity<Cliente> findDados(@RequestParam("cpf") String cpf) {
        Optional<Cliente> cliente = service.findByCpf(cpf);
        if (cliente.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(cliente.get());
    }
}
