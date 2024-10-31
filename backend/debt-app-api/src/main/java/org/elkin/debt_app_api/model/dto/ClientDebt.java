package org.elkin.debt_app_api.model.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ClientDebt {
  private String identification;
  private String name;
  private String email;
  private long amount;
  private String idDebt;
  private String dueDate;

  public ClientDebt(
      String identification,
      String name,
      String email,
      long amount,
      String idDebt,
      String dueDate) {
    this.identification = identification;
    this.name = name;
    this.email = email;
    this.amount = amount;
    this.idDebt = idDebt;
    this.dueDate = dueDate;
  }
}
