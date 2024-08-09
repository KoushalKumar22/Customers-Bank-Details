package com.CustomerAccount.BankAccount.Repository;

import com.CustomerAccount.BankAccount.DTO.CustomerDTO;
import com.CustomerAccount.BankAccount.DTO.SearchDTO;
import com.CustomerAccount.BankAccount.Entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository<Customer,Integer> {
    @Query("SELECT new com.CustomerAccount.BankAccount.DTO.SearchDTO(c.id, c.fname, c.lname, c.phone) " +
            "FROM Customer c WHERE c.fname = :fname")
    List<SearchDTO> findByfname(@Param("fname") String fname);
    @Query("SELECT new com.CustomerAccount.BankAccount.DTO.CustomerDTO(c.id, c.accNo, c.fname, c.lname, c.address, c.phone, c.openingDate, c.maturityDate) " +
            "FROM Customer c WHERE c.accNo = :accNo")
    List<CustomerDTO> findByaccNo(@Param("accNo") String accNo);

}
