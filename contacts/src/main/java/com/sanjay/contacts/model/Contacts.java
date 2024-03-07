package com.sanjay.contacts.model;


import com.fasterxml.jackson.annotation.JsonFormat;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;
import java.util.List;

@Document
public class Contacts {

    @Id
    private ObjectId id;
    private String fName;
    private String lName;
    private String company;
    private List<String> pNumbers;
    private List<String> labels;
    @JsonFormat(pattern="yyyy-MM-dd")
    private Date birthday;

    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    public String getfName() {
        return fName;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }

    public String getlName() {
        return lName;
    }

    public void setlName(String lName) {
        this.lName = lName;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public List<String> getpNumbers() {
        return pNumbers;
    }

    public void setpNumbers(List<String> pNumbers) {
        this.pNumbers = pNumbers;
    }

    public List<String> getLabels() {
        return labels;
    }

    public void setLabels(List<String> labels) {
        this.labels = labels;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    @Override
    public String toString() {
        return "Contacts{" +
                "id=" + id +
                ", fName='" + fName + '\'' +
                ", lName='" + lName + '\'' +
                ", company='" + company + '\'' +
                ", pNumbers=" + pNumbers +
                ", labels=" + labels +
                ", birthday=" + birthday +
                '}';
    }
}
