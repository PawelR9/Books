package com.library.model;


import java.util.Date;


import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlType;

@XmlRootElement(name = "author")
@XmlType(propOrder = { "name", "birthYear", "birthDate" })
public class Author extends BaseModel {

    private String name;
    private int birthYear;
    private Date birthDate;

    public Author() {
    }

    public Author(int id, String name, int birthYear, Date birthDate) {
        this.id = id;
        this.name = name;
        this.birthYear = birthYear;
        this.birthDate = birthDate;
    }

    @Override
    public String toString() {
        return "Author{" +
                "id=" + id +
                "name='" + name + '\'' +
                ", birthYear=" + birthYear +
                ", birthDate=" + birthDate +
                '}';
    }

    public String getName() {
        return name;
    }
    @XmlElement(name = "authorName")

    public void setName(String name) {
        this.name = name;
    }

    public int getBirthYear() {
        return birthYear;
    }

    @XmlElement(name = "authorBirthYear")
    public void setBirthYear(int birthYear) {
        this.birthYear = birthYear;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    @XmlElement(name = "authorBirthDate")
    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

}
