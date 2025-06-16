package org.test_task_account_balance.service;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.test_task_account_balance.dto.OperationDto;
import org.test_task_account_balance.entity.Balance;
import org.test_task_account_balance.entity.enums.OperationType;
import org.test_task_account_balance.entity.Transaction;
import org.test_task_account_balance.repository.BalanceRepository;
import org.test_task_account_balance.repository.TransactionRepository;
import org.test_task_account_balance.utils.CurrencyConverter;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class TransactionServiceImpl implements TransactionService{
    private final BalanceRepository balanceRepository;
    private final TransactionRepository transactionRepository;
    private final CurrencyConverter currencyConverter;

    @Override
    @Transactional
    public Transaction deposit( OperationDto dto) {
        Balance balance = balanceRepository.findById(dto.getBalanceId())
                .orElseThrow(() -> new EntityNotFoundException("Balance with UUID " + dto.getBalanceId() + " not found"));

        BigDecimal usdAmount = currencyConverter.convertToUsd(dto.getAmount(), dto.getCurrencyType());
        balance.setBalance(balance.getBalance().add(usdAmount));
        balanceRepository.save(balance);

        Transaction transaction = Transaction.builder()
                .id(UUID.randomUUID())
                .type(OperationType.DEPOSIT)
                .amount(usdAmount)
                .balance(balance)
                .createdAt(LocalDateTime.now())
                .build();

        return transactionRepository.save(transaction);
    }

    @Override
    @Transactional
    public Transaction withdraw(OperationDto dto) {
        Balance balance = balanceRepository.findById(dto.getBalanceId())
                .orElseThrow(() -> new EntityNotFoundException("Balance with UUID " + dto.getBalanceId() + " not found"));

        BigDecimal usdAmount = currencyConverter.convertToUsd(dto.getAmount(), dto.getCurrencyType());
        balance.setBalance(balance.getBalance().subtract(usdAmount));

        if (balance.getBalance().compareTo(BigDecimal.ZERO) < 0) {
            throw new IllegalArgumentException("You can't withdraw more than you have");
        }

        balanceRepository.save(balance);

        Transaction transaction = Transaction.builder()
                .id(UUID.randomUUID())
                .type(OperationType.WITHDRAW)
                .amount(usdAmount)
                .balance(balance)
                .createdAt(LocalDateTime.now())
                .build();

        return transactionRepository.save(transaction);
    }

    @Override
    public List<Transaction> getAllTransactions() {
        return transactionRepository.findAll();
    }
}
