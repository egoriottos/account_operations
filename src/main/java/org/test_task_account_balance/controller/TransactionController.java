package org.test_task_account_balance.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.test_task_account_balance.dto.OperationDto;
import org.test_task_account_balance.entity.enums.OperationType;
import org.test_task_account_balance.entity.Transaction;
import org.test_task_account_balance.service.TransactionService;
import java.util.List;

@RestController
@RequestMapping("/api/transaction")
@RequiredArgsConstructor
public class TransactionController {
    private final TransactionService transactionService;

    @PostMapping("/wallet")
    public ResponseEntity<Transaction> operation(@Valid @RequestBody OperationDto dto) {
        if (dto.getOperationType().equals(OperationType.DEPOSIT.toString())) {
            var response = transactionService.deposit(dto);
            return ResponseEntity.ok(response);
        } else if (dto.getOperationType().equals(OperationType.WITHDRAW.toString())) {
            var response = transactionService.withdraw(dto);
            return ResponseEntity.ok(response);
        } else {
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping("/all")
    public ResponseEntity<List<Transaction>> getAll() {
        return ResponseEntity.ok(transactionService.getAllTransactions());
    }
}
