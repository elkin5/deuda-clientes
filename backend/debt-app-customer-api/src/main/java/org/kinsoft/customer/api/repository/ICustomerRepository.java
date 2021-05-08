package org.kinsoft.debt_app.customer_api.repository;

import org.kinsoft.debt_app.customer_api.model.entity.CustomerEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICustomerRepository extends JpaRepository<CustomerEntity, String> {
}
