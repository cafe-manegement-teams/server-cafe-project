package com.example.cafeserver.model;

import javax.persistence.*;
import java.time.LocalDate;


@Entity
@Table(name= "orders")
public class Orders {
        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        private Integer id;

        @Column(name = "created_at")
        private LocalDate create_at;

        @Column(name = "total")
        private Double total;

        @Column(name = "status")
        private String status;

    public Orders(LocalDate create_at, Double total, String status) {
        this.create_at = create_at;
        this.total = total;
        this.status = status;
    }

    public Orders() {

    }


    public Integer getId() {
        return id;
    }

    public LocalDate getCreate_at() {
        return create_at;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public Double getTotal() {
        return total;
    }

    public String getStatus() {
        return status;
    }
}
