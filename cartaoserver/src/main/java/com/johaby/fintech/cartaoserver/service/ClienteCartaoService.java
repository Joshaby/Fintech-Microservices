package com.johaby.fintech.cartaoserver.service;

import com.johaby.fintech.cartaoserver.entity.ClienteCartao;
import com.johaby.fintech.cartaoserver.repository.ClienteCartaoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ClienteCartaoService {

    private final ClienteCartaoRepository repository;

    public List<ClienteCartao> findByCpf(String cpf) {
        return repository.findByCpf(cpf);
    }
}
