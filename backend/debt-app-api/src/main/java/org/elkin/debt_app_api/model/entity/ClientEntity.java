package org.elkin.debt_app_api.model.entity;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "client", schema = "debt_app", catalog = "")
public class ClientEntity {
    private String identification;
    private String name;
    private String email;
    private Collection<DebtEntity> debtsByIdentification;

    @Id
    @Column(name = "identification")
    public String getIdentification() {
        return identification;
    }

    public void setIdentification(String identification) {
        this.identification = identification;
    }

    @Basic
    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "email")
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ClientEntity that = (ClientEntity) o;
        return Objects.equals(identification, that.identification) && Objects.equals(name, that.name) && Objects.equals(email, that.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(identification, name, email);
    }

    @OneToMany(mappedBy = "clientByClientIdentification")
    public Collection<DebtEntity> getDebtsByIdentification() {
        return debtsByIdentification;
    }

    public void setDebtsByIdentification(Collection<DebtEntity> debtsByIdentification) {
        this.debtsByIdentification = debtsByIdentification;
    }
}
