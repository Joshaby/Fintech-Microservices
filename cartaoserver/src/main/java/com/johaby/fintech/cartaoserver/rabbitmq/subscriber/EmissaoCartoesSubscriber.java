package com.johaby.fintech.cartaoserver.rabbitmq.subscriber;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.johaby.fintech.cartaoserver.entity.Cartao;
import com.johaby.fintech.cartaoserver.entity.ClienteCartao;
import com.johaby.fintech.cartaoserver.repository.CartaoRepository;
import com.johaby.fintech.cartaoserver.repository.ClienteCartaoRepository;
import com.johaby.fintech.cartaoserver.representation.DadosSolicitacaoEmissaoCartao;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class EmissaoCartoesSubscriber {

    private final CartaoRepository cartaoRepository;

    private final ClienteCartaoRepository clienteCartaoRepository;

    @RabbitListener(queues = "${rabbitmq-queues.emissao-cartoes}")
    public void recebeSolicitacaoEmissao(@Payload String payload) {
        try {
            ObjectMapper mapper = new ObjectMapper();
            DadosSolicitacaoEmissaoCartao dados = mapper.readValue(payload, DadosSolicitacaoEmissaoCartao.class);
            Cartao cartao = cartaoRepository.findById(dados.getIdCartao()).orElseThrow();
            ClienteCartao clienteCartao = new ClienteCartao();
            clienteCartao.setCartao(cartao);
            clienteCartao.setCpf(dados.getCpf());
            clienteCartao.setLimite(dados.getLimiteLiberado());
            clienteCartaoRepository.save(clienteCartao);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
