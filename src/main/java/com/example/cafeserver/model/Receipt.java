package com.example.cafeserver.model;

import javax.persistence.*;
import java.time.LocalDate;


@Entity
@Table(name="receipt")
public class Receipt {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer id;

    @Column(name="create_at")
    private LocalDate create_at;

    @Column(name="status")
    private String status;

    @Column(name="total")
    private double total;


    public Receipt(LocalDate create_at, String status, double total) {
        this.create_at = create_at;
        this.status = status;
        this.total = total;
    }

    public Receipt(){}

    public static String DONE = "DONE !";
    public static String PROCESS = "IN PROCESS...";


    public LocalDate getCreate_at() {
        return create_at;
    }

    public String getStatus() {
        return status;
    }

    public Integer getId() {
        return id;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public double getTotal() {
        return total;
    }
}
