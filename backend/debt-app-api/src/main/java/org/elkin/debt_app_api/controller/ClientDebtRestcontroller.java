package org.elkin.debt_app_api.controller;

import org.elkin.debt_app_api.model.dto.ClientDebt;
import org.elkin.debt_app_api.service.IClientDebtService;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.List;

@Controller
@RequestMapping("/api/v1/debt")
public class ClientDebtRestcontroller {

  private final IClientDebtService clientDebtService;

  public ClientDebtRestcontroller(IClientDebtService debtService) {
    this.clientDebtService = debtService;
  }

  @GetMapping
  @ResponseBody
  public List<ClientDebt> getDebts() {
    return this.clientDebtService.getAllClientDebts();
  }

  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  @ResponseBody
  public ClientDebt createPost(@RequestBody ClientDebt clientDebt) throws ParseException {
    return this.clientDebtService.createClientDebt(clientDebt);
  }
}
