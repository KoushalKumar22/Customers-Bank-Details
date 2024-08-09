package com.CustomerAccount.BankAccount.Services;

import com.CustomerAccount.BankAccount.DTO.CustomerDTO;
import com.CustomerAccount.BankAccount.DTO.SearchDTO;

import java.util.List;

public interface ServicesInter {
    CustomerDTO saveCustomer(CustomerDTO customerDTO);
    List<CustomerDTO> findAll();
    SearchDTO findById(int id);
    List<SearchDTO> findByName(String fname);
    List<CustomerDTO> findByAccNo(String accNo);

}
