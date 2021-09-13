package org.muhdlaziem.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name= "person")
public class PersonEntity extends BaseEntity{

    @Column(name = "name", unique = true, nullable = false)
    public String name;

    @Column(name = "age", nullable = false)
    public int age;

    @Column(name = "ic_no", unique = true, nullable = false)
    public String icNo;

    @Column(name = "status",nullable = false)
    public String status;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getIcNo() {
        return icNo;
    }

    public void setIcNo(String icNo) {
        this.icNo = icNo;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
