package com.zf.dto;

/**
 * Created by Administrator on 2017/11/20.
 */
public class PersonQuery {

    private Long id;

    private String name;

    private String pwd;

    private String school;

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

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }



    public PersonQuery() {
        super();
    }

    @Override
    public String toString() {
        return "PersonQuery{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", pwd='" + pwd + '\'' +
                ", school='" + school + '\'' +
                '}';
    }
}
