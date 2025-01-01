package com.lauro.user.transfer.api.application.transfer;

import com.lauro.user.transfer.api.infrastructure.adapters.in.transfer.TransferDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Slf4j
public class TransferUserCase {

    private final KafkaTemplate<String, String> kafkaTemplate;

    public void sendTransfer(final TransferDto transferDto) {
        log.info("Sending transfer to {}", transferDto.username());
        kafkaTemplate.send("transfer-topic", transferDto.dni(), transferDto.toString());
        log.info("Transfer sent successfully!");
    }
}
