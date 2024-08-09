package com.CustomerAccount.BankAccount.DTO;

import jakarta.persistence.Column;

public class SearchDTO {
    int id;
    String accNo;
    String fname;
    String lname;

    public SearchDTO(int id, String accNo, String fname, String lname) {
        this.id = id;
        this.accNo = accNo;
        this.fname = fname;
        this.lname = lname;
    }

    public SearchDTO() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAccNo() {
        return accNo;
    }

    public void setAccNo(String accNo) {
        this.accNo = accNo;
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
}
