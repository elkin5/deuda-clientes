package org.kinsoft.debt.api.model.entity;

import javax.persistence.*;
import java.sql.Date;
import java.util.Objects;

@Entity
@Table(name = "debt", schema = "debt_app", catalog = "")
public class DebtEntity {
    private String id;
    private long amount;
    private Date dueDate;
    private String customerIdentification;

    @Id
    @Column(name = "id")
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Basic
    @Column(name = "amount")
    public long getAmount() {
        return amount;
    }

    public void setAmount(long amount) {
        this.amount = amount;
    }

    @Basic
    @Column(name = "due_date")
    public Date getDueDate() {
        return dueDate;
    }

    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }

    @Basic
    @Column(name = "customer_identification")
    public String getCustomerIdentification() {
        return customerIdentification;
    }

    public void setCustomerIdentification(String customerIdentification) {
        this.customerIdentification = customerIdentification;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DebtEntity that = (DebtEntity) o;
        return amount == that.amount && Objects.equals(id, that.id) && Objects.equals(dueDate, that.dueDate) && Objects.equals(customerIdentification, that.customerIdentification);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, amount, dueDate, customerIdentification);
    }
}
