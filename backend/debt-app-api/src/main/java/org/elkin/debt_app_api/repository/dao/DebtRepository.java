package org.elkin.debt_app_api.repository.dao;

import org.elkin.debt_app_api.model.entity.DebtEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DebtRepository extends JpaRepository<DebtEntity, String> {}
