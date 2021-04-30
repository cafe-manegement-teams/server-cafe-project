package com.example.cafeserver.model;
import javax.persistence.*;
@Entity
@Table(name= "shift")
public class Shift {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id;

    @Column(name ="shiftname")
    private char shiftname;

    @Column(name="timework")
    private String timework;

    @Column(name="hourcount")
    private Integer hourcount;

    public Shift(char shiftname, String timework, Integer hourcount) {
        this.shiftname = shiftname;
        this.timework = timework;
        this.hourcount = hourcount;
    }

    public Shift(){}

    public Integer getId() {
        return id;
    }

    public char getShiftname() {
        return shiftname;
    }

    public String getTimework() {
        return timework;
    }

    public Integer getHourcount() {
        return hourcount;
    }

    public void setShiftname(char shiftname) {
        this.shiftname = shiftname;
    }

    public void setTimework(String timework) {
        this.timework = timework;
    }

    public void setHourcount(Integer hourcount) {
        this.hourcount = hourcount;
    }
}
