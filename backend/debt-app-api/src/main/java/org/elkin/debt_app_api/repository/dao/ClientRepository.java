package org.elkin.debt_app_api.repository.dao;

import org.elkin.debt_app_api.model.entity.ClientEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IClientRepository extends JpaRepository<ClientEntity, String> {}
