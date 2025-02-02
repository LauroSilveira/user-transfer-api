package com.lauro.user.transfer.api.infrastructure.adapters.out.producer;

import com.lauro.user.transfer.api.application.out.TransferProducer;
import com.lauro.user.transfer.api.infrastructure.adapters.in.transfer.TransferDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Slf4j
public class TransferProducerImpl implements TransferProducer {

    private final KafkaTemplate<String, TransferDto> kafkaTemplate;

    @Override
    public void send(TransferDto transferDto) {
        log.info("Sending transfer to {}", transferDto.getUsername());
        kafkaTemplate.send("transfer-topic", transferDto.getDni(), transferDto);
        log.info("Transfer sent successfully!");
    }
}
