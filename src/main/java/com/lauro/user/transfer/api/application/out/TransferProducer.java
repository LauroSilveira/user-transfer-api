package com.lauro.user.transfer.api.application.out;

import com.lauro.user.transfer.api.infrastructure.adapters.in.transfer.TransferDto;

public interface TransferProducer {

    void send(TransferDto transferDto);
}
