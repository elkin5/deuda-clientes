package org.elkin.debt_app_api.service;

import org.elkin.debt_app_api.model.entity.DebtEntity;

import java.util.List;

public interface IDebtService {
  List<DebtEntity> getDebsList();

  void updateDebt(DebtEntity debtEntity);

  DebtEntity createDebt(DebtEntity debtEntity);

  DebtEntity getDebtById(String id);
}
