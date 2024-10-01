package model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "employee")

public class Employee {
    @Id
    private long id;
    private String name;
    private String email;
    private String phone_number;
    private String departement;
    private String position;

    public Employee() {

    }

    public Employee(int id, String name, String email, String phone_number, String departement, String position) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.phone_number = phone_number;
        this.departement = departement;
        this.position = position;
    }




    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }

    public String getDepartement() {
        return departement;
    }

    public void setDepartement(String departement) {
        this.departement = departement;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }


}
