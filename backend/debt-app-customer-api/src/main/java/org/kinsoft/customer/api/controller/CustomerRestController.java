package org.kinsoft.debt_app.customer_api.controller;

import org.kinsoft.debt_app.customer_api.model.entity.CustomerEntity;
import org.kinsoft.debt_app.customer_api.repository.ICustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CustomerRestController {
  @Autowired ICustomerRepository customerRepository;

  @GetMapping()
  public List<CustomerEntity> list() {
    return customerRepository.findAll();
  }

  @GetMapping("/{id}")
  public CustomerEntity get(@PathVariable String id) {
    return null;
  }

  @PutMapping("/{id}")
  public ResponseEntity<?> put(@PathVariable String id, @RequestBody CustomerEntity input) {
    return null;
  }

  @PostMapping
  public ResponseEntity<?> post(@RequestBody CustomerEntity input) {
    CustomerEntity save = customerRepository.save(input);
    return ResponseEntity.ok(save);
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<?> delete(@PathVariable String id) {
    return null;
  }
}
