package org.elkin.debt_app_api.service;

import org.elkin.debt_app_api.model.entity.ClientEntity;

import java.util.List;

public interface IClientService {
  List<ClientEntity> getClientsList();

  void updateClient(ClientEntity clientEntity);

  ClientEntity createClient(ClientEntity clientEntity);

  ClientEntity getClientById(String id);
}
