package org.elkin.debt_app_api.model.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Collection;

@Getter
@Setter
@NoArgsConstructor
public class Client {
  private String identification;
  private String name;
  private String email;
  private Collection<Debt> debts;

  public Client(String identification, String name, String email) {
    this.identification = identification;
    this.name = name;
    this.email = email;
  }
}
