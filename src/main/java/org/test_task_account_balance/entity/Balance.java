package org.test_task_account_balance.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.test_task_account_balance.entity.enums.CurrencyType;
import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@Table(name = "balance")
public class Balance {
    @Id
    private UUID id;

    private BigDecimal balance;

    @Column(unique = true, nullable = false)
    private String name;

    @Enumerated(EnumType.STRING)
    private CurrencyType currencyType = CurrencyType.USD;

    @OneToMany(cascade = CascadeType.ALL)
    List<Transaction> transactions;


}
