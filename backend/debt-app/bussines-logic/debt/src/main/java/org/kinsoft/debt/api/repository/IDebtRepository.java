package org.kinsoft.debt.api.repository;

import org.kinsoft.debt.api.model.entity.DebtEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IDebtRepository extends JpaRepository<DebtEntity, String> {
}
