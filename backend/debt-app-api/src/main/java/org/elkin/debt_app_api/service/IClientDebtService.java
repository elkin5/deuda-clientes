package org.elkin.debt_app_api.service;

import org.elkin.debt_app_api.model.dto.ClientDebt;
import org.elkin.debt_app_api.model.entity.ClientEntity;

import java.text.ParseException;
import java.util.List;

public interface IClientDebtService {
    List<ClientDebt> getAllClientDebts();

    void updateClientDebt(ClientEntity clientEntity);

    ClientDebt createClientDebt(ClientDebt clientDebt) throws ParseException;

    ClientEntity getClientDebtById(String id);
}
