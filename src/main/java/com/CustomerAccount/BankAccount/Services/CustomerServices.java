package com.CustomerAccount.BankAccount.Services;

import com.CustomerAccount.BankAccount.DTO.CustomerDTO;
import com.CustomerAccount.BankAccount.DTO.SearchDTO;
import com.CustomerAccount.BankAccount.Entity.Customer;
import com.CustomerAccount.BankAccount.Repository.CustomerRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CustomerServices implements ServicesInter{
    @Autowired
    CustomerRepository customerRepository;
    @Autowired
    ModelMapper mapper;

    @Override
    public CustomerDTO saveCustomer(CustomerDTO customerDTO){
        Customer customer=new Customer();
        mapper.map(customerDTO, customer);
        customerRepository.save(customer);
        return customerDTO;
    }
    @Override
    public List<CustomerDTO> findAll(){
        return customerRepository.findAll()
                .stream()
                .map(customer -> mapper.map(customer, CustomerDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public SearchDTO findById(int id){
        Optional<Customer>  customer=customerRepository.findById(id);
        return customer.map(customer1 -> mapper.map(customer1, SearchDTO.class))
                .orElse(null);
    }
    @Override
    public List<SearchDTO> findByName(String fname){
        return customerRepository.findByName(fname);
    }
    @Override
    public List<CustomerDTO> findByAccNo(String accNo){
        return customerRepository.findByAccNo(accNo);
    }
}
