package org.test_task_account_balance.service;

import org.test_task_account_balance.dto.OperationDto;
import org.test_task_account_balance.entity.Transaction;
import java.util.List;
import java.util.UUID;

public interface TransactionService {
    Transaction deposit(OperationDto dto);
    Transaction withdraw(OperationDto dto);

    List<Transaction> getAllTransactions();
}
