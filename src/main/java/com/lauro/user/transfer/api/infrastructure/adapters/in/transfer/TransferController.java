package com.lauro.user.transfer.api.infrastructure.adapters.in.transfer;

import com.lauro.user.transfer.api.application.transfer.TransferUserCase;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/transfer")
@RequiredArgsConstructor
@Slf4j
public class TransferController {

    private final TransferUserCase transferUserCase;

    @PostMapping
    public ResponseEntity<String> sendTransfer(@RequestBody final TransferDto transferDto) {
        log.info("Sending transfer to user {}", transferDto.username());
        this.transferUserCase.sendTransfer(transferDto);
        return ResponseEntity.ok().build();
    }
}
