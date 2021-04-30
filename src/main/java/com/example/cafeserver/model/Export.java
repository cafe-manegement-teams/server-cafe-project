package com.example.cafeserver.model;

import javax.persistence.*;

@Entity
@Table(name="export")
public class Export {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "delivery_id", referencedColumnName = "id")
    private DeliveryBill deliveryBill;

    @ManyToOne
    @JoinColumn(name = "material_id", referencedColumnName = "id")
    private Material material;

    @Column(name="quantity")
    private double quantity;


    public Export(DeliveryBill deliveryBill, Material material, double quantity) {
        this.deliveryBill = deliveryBill;
        this.material = material;
        this.quantity = quantity;
    }

    public Export(){}


    public void setDeliveryBill(DeliveryBill deliveryBill) {
        this.deliveryBill = deliveryBill;
    }

    public DeliveryBill getDeliveryBill() {
        return deliveryBill;
    }

    public void setMaterial(Material material) {
        this.material = material;
    }

    public Material getMaterial() {
        return material;
    }

    public void setQuantity(double quantity) {
        this.quantity = quantity;
    }

    public double getQuantity() {
        return quantity;
    }

    public Integer getId() {
        return id;
    }
}
