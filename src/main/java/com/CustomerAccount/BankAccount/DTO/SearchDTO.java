package com.CustomerAccount.BankAccount.DTO;

import jakarta.persistence.Column;

public class SearchDTO {
    int id;
    String fname;
    String lname;
    String phone;

    public SearchDTO(int id, String fname, String lname, String phone) {
        this.id = id;
        this.fname = fname;
        this.lname = lname;
        this.phone = phone;
    }

    public SearchDTO() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
