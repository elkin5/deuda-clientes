package org.elkin.debt_app_api.service;

import org.elkin.debt_app_api.model.dto.Client;
import org.elkin.debt_app_api.model.dto.ClientDebt;
import org.elkin.debt_app_api.model.dto.Debt;
import org.elkin.debt_app_api.model.entity.ClientEntity;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ClientDebtService implements IClientDebtService {

  private final ClientService clientService;
  private final DebtService debtService;
  private final ModelMapper modelMapper;

  public ClientDebtService(
      ClientService clientService, DebtService debtService, ModelMapper modelMapper) {
    this.clientService = clientService;
    this.debtService = debtService;
    this.modelMapper = modelMapper;
  }

  @Override
  public List<ClientDebt> getAllClientDebts() {
    List<ClientDebt> clientDebtList = new ArrayList<>();

    var clientEntities = this.clientService.getClientsList();
    var clients =
        clientEntities.stream().map(clientService::convertToDto).collect(Collectors.toList());

    clients.forEach(
        client -> {
          var clientDebt = new ClientDebt();
          clientDebt.setIdentification(client.getIdentification());
          clientDebt.setName(client.getName());
          clientDebt.setEmail(client.getEmail());

          var debts = client.getDebts();
          debts.forEach(
              debt -> {
                clientDebt.setAmount(debt.getAmount());
                clientDebt.setIdDebt(debt.getId());
                clientDebt.setDueDate(debt.getDueDate());
                clientDebtList.add(clientDebt);
              });
        });

    return clientDebtList;
  }

  @Override
  @Transactional
  public ClientDebt createClientDebt(ClientDebt clientDebt) throws ParseException {
    var client = this.clientService.getClientById(clientDebt.getIdentification());
    if (client.getName() == null) {
      client = this.clientService.convertToEntity(this.getClient(clientDebt));
      this.clientService.createClient(client);
    }



    return clientDebt;
  }

  @Override
  public void updateClientDebt(ClientEntity clientEntity) {}

  @Override
  public ClientEntity getClientDebtById(String id) {
    return null;
  }

  private Client getClient(ClientDebt clientDebt) {
    var client = new Client();
    client.setIdentification(clientDebt.getIdentification());
    client.setName(clientDebt.getName());
    client.setEmail(clientDebt.getEmail());

    return client;
  }

  private Debt getDebt(ClientDebt clientDebt) {
    var debt = new Debt();
    debt.setId(clientDebt.getIdDebt());
    debt.setAmount(clientDebt.getAmount());
    debt.setDueDate(clientDebt.getDueDate());

    return debt;
  }
}
