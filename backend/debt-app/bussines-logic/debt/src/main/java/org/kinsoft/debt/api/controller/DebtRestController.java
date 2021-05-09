package org.kinsoft.debt.api.controller;

import org.kinsoft.debt.api.model.entity.DebtEntity;
import org.kinsoft.debt.api.repository.IDebtRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DebtRestController {

    @Autowired
    IDebtRepository debtRepository;

    @GetMapping()
    public List<DebtEntity> list() {
        return debtRepository.findAll();
    }

    @GetMapping("/{id}")
    public DebtEntity get(@PathVariable String id) {
        return null;
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> put(@PathVariable String id, @RequestBody DebtEntity input) {
        return null;
    }

    @PostMapping
    public ResponseEntity<?> post(@RequestBody DebtEntity input) {
        DebtEntity save = debtRepository.save(input);
        return ResponseEntity.ok(save);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable String id) {
        this.debtRepository.deleteById(id);
        return null;
    }
}
