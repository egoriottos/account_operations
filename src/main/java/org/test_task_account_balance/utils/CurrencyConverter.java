package org.test_task_account_balance.utils;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import java.math.BigDecimal;
import java.math.RoundingMode;

@Component
@RequiredArgsConstructor
public class CurrencyConverter {

    public BigDecimal convertToUsd(BigDecimal amount, String type) {
        if (amount.compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalArgumentException("Amount must be positive");
        }
        BigDecimal rate = getRate(type);
        return amount.multiply(rate).setScale(2, RoundingMode.HALF_UP);
    }

    private BigDecimal getRate(String type) {
        return switch (type.toUpperCase()) {
            case "USD" -> BigDecimal.ONE;
            case "EUR" -> new BigDecimal("1.1");
            case "BYN" -> new BigDecimal("0.3");
            case "RUB" -> new BigDecimal("0.01");
            default -> throw new IllegalArgumentException("Unsupported currency type " + type);
        };
    }
}
