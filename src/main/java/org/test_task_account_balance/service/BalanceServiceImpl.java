package org.test_task_account_balance.service;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.test_task_account_balance.dto.CreateBalanceDto;
import org.test_task_account_balance.entity.Balance;
import org.test_task_account_balance.repository.BalanceRepository;
import java.math.BigDecimal;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class BalanceServiceImpl implements BalanceService{
    private final BalanceRepository balanceRepository;

    @Override
    public Balance createBalance(CreateBalanceDto dto) {
        Balance balance = Balance.builder()
                .id(UUID.randomUUID())
                .balance(new BigDecimal("0.0"))
                .name(dto.getName())
                .build();

        return balanceRepository.save(balance);
    }

}
