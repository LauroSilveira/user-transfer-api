package com.lauro.user.transfer.api.infrastructure.adapters.in.transfer;

import com.lauro.user.transfer.api.application.usecase.transfer.SendTransferUserCase;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/transfer")
@RequiredArgsConstructor
@Slf4j
public class TransferController {

    private final SendTransferUserCase sendTransferUserCase;

    @PostMapping
    public ResponseEntity<String> sendTransfer(@RequestBody final TransferDto transferDto) {
        log.info("Sending transfer to user {}", transferDto.getUsername());
        this.sendTransferUserCase.sendTransfer(transferDto);
        return ResponseEntity.ok().build();
    }
}
