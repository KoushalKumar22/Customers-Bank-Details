package com.CustomerAccount.BankAccount.Repository;

import com.CustomerAccount.BankAccount.DTO.CustomerDTO;
import com.CustomerAccount.BankAccount.DTO.SearchDTO;
import com.CustomerAccount.BankAccount.Entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository<Customer,Integer> {
    List<SearchDTO> findByName(String fname);

    List<CustomerDTO> findByAccNo(String accNo);
}
