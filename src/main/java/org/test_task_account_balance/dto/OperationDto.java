package org.test_task_account_balance.dto;

import lombok.Data;
import org.test_task_account_balance.entity.enums.OperationType;
import java.math.BigDecimal;
import java.util.UUID;

@Data
public class OperationDto {
    private UUID balanceId;
    private BigDecimal amount;
    private String currencyType;
    private OperationType operationType;
}
