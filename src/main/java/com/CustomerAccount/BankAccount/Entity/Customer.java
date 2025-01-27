package com.CustomerAccount.BankAccount.Entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Entity
@Table(name = "Bank Details")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID",nullable = false,unique = true)
    int id;
    @Column(name = "AccountNo",unique = true)
    @NotNull(message = "Please Enter The Bank Account No!")
    @Pattern(regexp = "^[0-9]{9,18}$",message = "Please Enter An Valid Account Number!")
    String accNo;
    @Column(name = "FirstName",nullable = false)
    @NotEmpty(message = "Please Provide First Name!")
    String fname;
    @Column(name = "LastName",nullable = false)
    @NotEmpty(message = "Please Provide a Last Name!")
    String lname;
    @Column(name = "Address",nullable = false)
    @NotEmpty(message = "Please Provide An Address!")
    String address;
    @Column(name = "PhoneNo",unique = true,nullable = false)
    @NotEmpty(message = "Please Enter an Phone Number!")
    @Pattern(regexp = "^[6-9]{1}[0-9]{9}$",message = "Please Enter An Valid Phone Number!")
    String phone;

//    @CreationTimestamp
    LocalDateTime openingDate;
    LocalDateTime maturityDate;

    public Customer(){
        this.openingDate=LocalDateTime.now();
        this.maturityDate=this.openingDate.plusYears(10);
    }

    public Customer(int id, String accNo, String fname, String lname, String address, String phone, LocalDateTime openingDate, LocalDateTime maturityDate) {
        this.id = id;
        this.accNo = accNo;
        this.fname = fname;
        this.lname = lname;
        this.address = address;
        this.phone = phone;
        this.openingDate = openingDate;
        this.maturityDate = maturityDate;
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public LocalDateTime getOpeningDate() {
        return openingDate;
    }

    public void setOpeningDate(LocalDateTime openingDate) {
        this.openingDate = openingDate;
    }

    public LocalDateTime getMaturityDate() {
        return maturityDate;
    }

    public void setMaturityDate(LocalDateTime maturityDate) {
        this.maturityDate = maturityDate;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
