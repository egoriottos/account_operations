package org.test_task_account_balance.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.test_task_account_balance.entity.enums.OperationType;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@Table(name = "transaction")
public class Transaction {
    @Id
    private UUID id;

    @Enumerated(EnumType.STRING)
    private OperationType type;

    private BigDecimal amount;

    @ManyToOne
    @JoinColumn(name = "balance_id", referencedColumnName = "id")
    private Balance balance;

    private LocalDateTime createdAt;
}
