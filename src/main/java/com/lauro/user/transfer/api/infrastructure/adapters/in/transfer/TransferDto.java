package com.lauro.user.transfer.api.infrastructure.adapters.in.transfer;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
public class TransferDto {

    private @NotBlank String username;
    private @NotBlank String dni;
    private @NotBlank BigDecimal amount;
    private LocalDateTime createdAt = LocalDateTime.now();
    private @NotBlank String addressee;

}
