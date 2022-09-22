package com.johaby.fintech.cartaoserver.rabbitmq.subscriber;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
public class EmissaoCartoesSubscriber {

    @RabbitListener(queues = "${rabbitmq-queues.emissao-cartoes}")
    public void recebeSolicitacaoEmissao(@Payload String payload) {
        System.out.println(payload);
    }
}
