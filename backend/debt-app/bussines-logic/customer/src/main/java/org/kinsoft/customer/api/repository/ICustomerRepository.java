package org.kinsoft.customer.api.repository;

import org.kinsoft.customer.api.model.entity.CustomerEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICustomerRepository extends JpaRepository<CustomerEntity, String> {
}
