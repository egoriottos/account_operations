package org.test_task_account_balance.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.test_task_account_balance.dto.CreateBalanceDto;
import org.test_task_account_balance.entity.Balance;
import org.test_task_account_balance.service.BalanceService;

@RestController
@RequestMapping("/api/balance")
@RequiredArgsConstructor
public class BalanceController {
    private final BalanceService balanceService;

    @PostMapping
    public ResponseEntity<Balance> createBalance(@Valid @RequestBody CreateBalanceDto dto) {
        return ResponseEntity.ok(balanceService.createBalance(dto));
    }
}
