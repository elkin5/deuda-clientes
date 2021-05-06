package org.elkin.debt_app_api.controller;

import org.elkin.debt_app_api.model.dto.Debt;
import org.elkin.debt_app_api.model.entity.DebtEntity;
import org.elkin.debt_app_api.service.IDebtService;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/api/v1/debt")
public class DebtRestcontroller {

  private final IDebtService debtService;
  private final ModelMapper modelMapper;

  public DebtRestcontroller(IDebtService debtService, ModelMapper modelMapper) {
    this.debtService = debtService;
    this.modelMapper = modelMapper;
  }

  @GetMapping
  @ResponseBody
  public List<Debt> getDebts() {

    List<DebtEntity> debtEntities = this.debtService.getDebsList();

    return debtEntities.stream().map(this::convertToDto).collect(Collectors.toList());
  }

  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  @ResponseBody
  public Debt createDebt(@RequestBody Debt debt) throws ParseException {
    var debtEntity = convertToEntity(debt);
    var debtCreated = debtService.createDebt(debtEntity);
    return convertToDto(debtCreated);
  }

  @GetMapping(value = "/{id}")
  @ResponseBody
  public Debt getDebt(@PathVariable("id") String id) {
    return convertToDto(debtService.getDebtById(id));
  }

  @PutMapping(value = "/{id}")
  @ResponseStatus(HttpStatus.OK)
  public void updateDebt(@PathVariable("id") String id, @RequestBody Debt debt)
      throws ParseException {
    var debtUpdate = convertToDto(debtService.getDebtById(id));
    debtUpdate.setDueDate(
        (debt.getDueDate() != null) ? debt.getDueDate() : debtUpdate.getDueDate());
    debtUpdate.setAmount((debt.getAmount() != 0) ? debt.getAmount() : debtUpdate.getAmount());

    var debtEntity = convertToEntity(debtUpdate);
    debtService.updateDebt(debtEntity);
  }


}
