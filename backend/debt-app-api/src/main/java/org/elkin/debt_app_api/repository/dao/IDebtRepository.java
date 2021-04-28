package org.elkin.debt_app_api.repository.dao;

import org.elkin.debt_app_api.model.entity.DebtEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IDebtRepository extends JpaRepository<DebtEntity, String> {}
