package org.elkin.debt_app_api.model.entity;

import javax.persistence.*;
import java.sql.Date;
import java.util.Objects;

@Entity
@Table(name = "debt", schema = "debt_app", catalog = "")
public class DebtEntity {
    private String id;
    private long amount;
    private Date dueDate;
    private ClientEntity clientByClientIdentification;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DebtEntity that = (DebtEntity) o;
        return amount == that.amount && Objects.equals(id, that.id) && Objects.equals(dueDate, that.dueDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, amount, dueDate);
    }

    @ManyToOne
    @JoinColumn(name = "client_identification", referencedColumnName = "identification")
    public ClientEntity getClientByClientIdentification() {
        return clientByClientIdentification;
    }

    public void setClientByClientIdentification(ClientEntity clientByClientIdentification) {
        this.clientByClientIdentification = clientByClientIdentification;
    }
}
