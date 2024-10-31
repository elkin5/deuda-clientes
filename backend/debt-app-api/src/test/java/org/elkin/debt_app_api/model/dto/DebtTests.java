package org.elkin.debt_app_api.model.dto;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.elkin.debt_app_api.model.entity.DebtEntity;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.modelmapper.ModelMapper;

class DebtTests {

  private final ModelMapper modelMapper = new ModelMapper();

  @BeforeEach
  void setUp() {}

  @Test
  void whenConvertDebtEntityToDebt_thenCorrect() {
    DebtEntity debtEntity = new DebtEntity();
    debtEntity.setId("12345");

    Debt debt = modelMapper.map(debtEntity, Debt.class);
    assertEquals(debtEntity.getId(), debt.getId());
  }

  @Test
  void whenConvertDebtToDebtEntity_thenCorrect() {
    Debt debt = new Debt();
    debt.setId("12345");

    DebtEntity debtEntity = modelMapper.map(debt, DebtEntity.class);
    assertEquals(debtEntity.getId(), debtEntity.getId());
  }
}
