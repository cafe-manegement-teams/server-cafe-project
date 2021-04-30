package com.example.cafeserver.model;

import javax.persistence.*;

@Entity
@Table(name="import")
public class Import {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "receipt_id", referencedColumnName = "id")
    private Receipt receipt;

    @ManyToOne
    @JoinColumn(name = "material_id", referencedColumnName = "id")
    private Material material;

    @Column(name="quantity")
    private double quantity;

    @Column(name="subtotal")
    private double subtotal;

    public Import(Receipt receipt, Material material, double quantity, double subtotal) {
        this.receipt = receipt;
        this.material = material;
        this.quantity = quantity;
        this.subtotal = subtotal;
    }

    public Import(){}


    public void setReceipt(Receipt receipt) {
        this.receipt = receipt;
    }

    public Receipt getReceipt() {
        return receipt;
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

    public void setSubtotal(double subtotal) {
        this.subtotal = subtotal;
    }

    public double getSubtotal() {
        return subtotal;
    }
}
