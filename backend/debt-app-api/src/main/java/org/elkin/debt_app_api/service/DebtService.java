package org.elkin.debt_app_api.service;

import org.elkin.debt_app_api.model.dto.Debt;
import org.elkin.debt_app_api.model.entity.DebtEntity;
import org.elkin.debt_app_api.repository.dao.DebtRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.util.List;

@Service
public class DebtService implements IDebtService {

  private final DebtRepository debtRepository;
  private final ModelMapper modelMapper;

  public DebtService(DebtRepository debtRepository, ModelMapper modelMapper) {
    this.debtRepository = debtRepository;
    this.modelMapper = modelMapper;
  }

  @Override
  public List<DebtEntity> getDebsList() {
    return this.debtRepository.findAll();
  }

  @Override
  public void updateDebt(DebtEntity debtEntity) {
    this.debtRepository.save(debtEntity);
  }

  @Override
  public DebtEntity createDebt(DebtEntity debtEntity) {
    return this.debtRepository.save(debtEntity);
  }

  @Override
  public DebtEntity getDebtById(String id) {
    return this.debtRepository.getOne(id);
  }

  public Debt convertToDto(DebtEntity debtEntity) {
    var debt = modelMapper.map(debtEntity, Debt.class);
    debt.setDueDate(debtEntity.getDueDate(), "America/Bogota");

    return debt;
  }

  public DebtEntity convertToEntity(Debt debt) throws ParseException {
    var debtEntity = modelMapper.map(debt, DebtEntity.class);
    debtEntity.setDueDate(debt.getDueDateConverted("America/Bogota"));

    return debtEntity;
  }
}
