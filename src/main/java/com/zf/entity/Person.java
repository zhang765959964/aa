package com.zf.entity;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by Administrator on 2017/11/8.
 */
@Entity
@Table(name="t_person")
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private Integer sex;

    @Column(name="birth_date")
    private String birthDate;

    private String school;

    private String pwd;

    private String address;

    private Integer hobby;

    private Integer age;

    private String note;




    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getHobby() {
        return hobby;
    }

    public void setHobby(Integer hobby) {
        this.hobby = hobby;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public Person(String name, Integer sex, String birthDate, String school, String pwd, String address, Integer hobby, Integer age, String note) {
        this.name = name;
        this.sex = sex;
        this.birthDate = birthDate;
        this.school = school;
        this.pwd = pwd;
        this.address = address;
        this.hobby = hobby;
        this.age = age;
        this.note = note;
    }

    public Person() {
        super();
    }
}
