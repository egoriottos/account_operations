package org.test_task_account_balance.service;

import org.test_task_account_balance.dto.CreateBalanceDto;
import org.test_task_account_balance.entity.Balance;
import java.util.UUID;

public interface BalanceService {
    Balance createBalance(CreateBalanceDto dto);
}
