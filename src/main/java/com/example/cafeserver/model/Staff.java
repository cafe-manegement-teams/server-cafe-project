package com.example.cafeserver.model;

import javax.persistence.*;

@Entity
@Table(name="staff")
public class Staff {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "fullname")
    private String fullname;

    @Column(name = "datebirth")
    private String datebirth ;

    @Column(name = "phone")
    private String phone;

    @Column(name = "address")
    private String address;

    @ManyToOne
    @JoinColumn(name ="id_shift", referencedColumnName = "id" )
    private Shift shift;

    @ManyToOne
    @JoinColumn(name = "id_position", referencedColumnName = "id")
    private Position position;


    public Staff(String fullname, String datebirth, String phone, String address, Shift shift, Position position) {
        this.fullname = fullname;
        this.datebirth = datebirth;
        this.phone = phone;
        this.address = address;
        this.shift = shift;
        this.position = position;
    }

    public Staff(){}

    public Integer getId() {
        return id;
    }

    public String getFullname() {
        return fullname;
    }

    public String getDatebirth() {
        return datebirth;
    }

    public String getPhone() {
        return phone;
    }

    public String getAddress() {
        return address;
    }

    public Shift getShift() {
        return shift;
    }

    public Position getPosition() {
        return position;
    }


    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public void setDatebirth(String datebirth) {
        this.datebirth = datebirth;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public void setShift(Shift shift) {
        this.shift = shift;
    }
}
