package com.lauro.user.transfer.api.infrastructure.adapters.in.transfer;

import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;

public record TransferDto(
        @NotNull String username,
        @NotNull String dni,
        @NotNull BigDecimal amount) {
}
