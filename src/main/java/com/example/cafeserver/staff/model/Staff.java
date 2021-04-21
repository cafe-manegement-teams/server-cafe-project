package com.example.cafeserver.staff.model;

import javax.persistence.*;

@Entity
@Table(name="staff")
public class Staff {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id;

    @Column(name = "fullname")
    private String fullname;

    @Column(name = "datebirth")
    private String datebirth ;

    @Column(name = "phone")
    private String phone;

    @Column(name = "address")
    private String address;

    @Column(name = "position")
    private String position;


    public String getPhone() {
        return phone;
    }

    public String getPosition() {
        return position;
    }

    public String getAddress() {
        return address;
    }





    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getDatebirth() {
        return datebirth;
    }

    public void setDatebirth(String datebirth) {
        this.datebirth = datebirth;
    }

    public Integer getId() {
        return id;
    }
}
