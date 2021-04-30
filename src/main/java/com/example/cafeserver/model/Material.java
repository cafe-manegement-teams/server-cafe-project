package com.example.cafeserver.model;
import javax.persistence.*;


@Entity
@Table(name="material")
public class Material {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer id;

    @Column(name="materialname")
    private String materialname;

    @Column(name="unit")
    private String unit;

    @Column(name="quantity")
    private double quantity;

    @Column(name="unitprice")
    private double unitprice;


    public Material(String materialname, String unit, double quantity, double unitprice) {
        this.materialname = materialname;
        this.unit = unit;
        this.quantity = quantity;
        this.unitprice = unitprice;
    }

    public Material(){}


    public void setMaterialname(String materialname) {
        this.materialname = materialname;
    }

    public String getMaterialname() {
        return materialname;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public String getUnit() {
        return unit;
    }

    public void setQuantity(double quantity) {
        this.quantity = quantity;
    }

    public double getQuantity() {
        return quantity;
    }

    public void setUnitprice(double unitprice) {
        this.unitprice = unitprice;
    }

    public double getUnitprice() {
        return unitprice;
    }

    public Integer getId() {
        return id;
    }
}
