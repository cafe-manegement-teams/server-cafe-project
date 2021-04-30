package com.example.cafeserver.model;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name="delivery_bill")
public class DeliveryBill {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer id;

    @Column(name="create_at")
    private LocalDate create_at;

    @Column(name="status")
    private String status;

    public static String DONE = "DONE !";
    public static String PROCESS = "IN PROCESS...";

    public DeliveryBill(LocalDate create_at, String status) {
        this.create_at = create_at;
        this.status = status;
    }

    public DeliveryBill(){}


    public LocalDate getCreate_at() {
        return create_at;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Integer getId() {
        return id;
    }
}

