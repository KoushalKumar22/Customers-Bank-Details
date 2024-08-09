package com.CustomerAccount.BankAccount.Repository;

import com.CustomerAccount.BankAccount.Entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer,Integer> {
}
