package org.test_task_account_balance.repository;

import jakarta.persistence.LockModeType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Lock;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Repository;
import org.test_task_account_balance.entity.Balance;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface BalanceRepository extends JpaRepository<Balance, UUID> {
    @Lock(LockModeType.PESSIMISTIC_WRITE)
    @NonNull
    Optional<Balance> findById(@NonNull UUID uuid);
}
