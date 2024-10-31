package org.elkin.debt_app_api.service;

import org.elkin.debt_app_api.model.dto.Client;
import org.elkin.debt_app_api.model.entity.ClientEntity;
import org.elkin.debt_app_api.repository.dao.ClientRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.util.List;

@Service
public class ClientService implements IClientService {

  private final ClientRepository clientRepository;
  private final ModelMapper modelMapper;

  public ClientService(ClientRepository clientRepository, ModelMapper modelMapper) {
    this.clientRepository = clientRepository;
    this.modelMapper = modelMapper;
  }

  @Override
  public List<ClientEntity> getClientsList() {
    return this.clientRepository.findAll();
  }

  @Override
  public void updateClient(ClientEntity clientEntity) {
    this.clientRepository.save(clientEntity);
  }

  @Override
  public ClientEntity createClient(ClientEntity clientEntity) {
    return this.clientRepository.save(clientEntity);
  }

  @Override
  public ClientEntity getClientById(String identification) {
    return this.clientRepository.getOne(identification);
  }

  public Client convertToDto(ClientEntity clientEntity) {
    return modelMapper.map(clientEntity, Client.class);
  }

  public ClientEntity convertToEntity(Client client) {
    return modelMapper.map(client, ClientEntity.class);
  }
}
