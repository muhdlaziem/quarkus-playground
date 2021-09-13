package org.muhdlaziem.entity;

import javax.persistence.*;

@Entity
@Table(name = "engineer")
public class EngineerEntity extends BaseEntity{

    @Column(name = "department", nullable = false)
    public String department;

    @Column(name = "company", nullable = false)
    public String company;

    @OneToOne
    @JoinColumn(name = "user_id")
    public PersonEntity personEntity;

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public PersonEntity getPersonEntity() {
        return personEntity;
    }

    public void setPersonEntity(PersonEntity personEntity) {
        this.personEntity = personEntity;
    }
}
