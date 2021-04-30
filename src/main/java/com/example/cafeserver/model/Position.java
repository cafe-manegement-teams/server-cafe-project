package com.example.cafeserver.model;

import javax.persistence.*;

@Entity
@Table(name= "position")
public class Position {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "poname")
    private String poname;

    @Column(name = "salary")
    private double salary;

    public Position(String poname, double salary) {
        this.poname = poname;
        this.salary = salary;
    }

    public Position() {}

    public Integer getId() {
        return id;
    }

    public String getPoname() {
        return poname;
    }

    public void setPoname(String poname) {
        this.poname = poname;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

}
