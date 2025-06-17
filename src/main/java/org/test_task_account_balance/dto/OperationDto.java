package org.test_task_account_balance.dto;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Data;
import java.math.BigDecimal;
import java.util.UUID;

@Data
public class OperationDto {
    @NotNull(message = "Balance ID cannot be null")
    private UUID balanceId;
    @NotNull(message = "Amount cannot be null")
    @DecimalMin(value = "0.01", message = "Amount must be greater than 0")
    private BigDecimal amount;
    @NotBlank(message = "Currency type cannot be blank")
    @Pattern(regexp = "USD|EUR|BYN|RUB", message = "Invalid currency type")
    private String currencyType;
    @NotNull(message = "Operation type cannot be null")
    @Pattern(regexp = "DEPOSIT|WITHDRAW", message = "Invalid operation type")
    private String operationType;
}
