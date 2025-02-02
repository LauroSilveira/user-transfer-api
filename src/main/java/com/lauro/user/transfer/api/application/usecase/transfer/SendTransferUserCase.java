package com.lauro.user.transfer.api.application.usecase.transfer;

import com.lauro.user.transfer.api.application.out.TransferProducer;
import com.lauro.user.transfer.api.infrastructure.adapters.in.transfer.TransferDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Slf4j
public class SendTransferUserCase {

    private final TransferProducer transferProducer;

    public void sendTransfer(final TransferDto transferDto) {
        transferProducer.send(transferDto);
    }
}
