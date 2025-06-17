package org.test_task_account_balance.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class CreateBalanceDto {
    @NotBlank(message = "Name must not be blank")
    private String name;
}
