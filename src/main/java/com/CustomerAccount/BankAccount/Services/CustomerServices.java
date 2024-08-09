package com.CustomerAccount.BankAccount.Services;

import com.CustomerAccount.BankAccount.DTO.CustomerDTO;
import com.CustomerAccount.BankAccount.DTO.SearchDTO;
import com.CustomerAccount.BankAccount.Entity.Customer;
import com.CustomerAccount.BankAccount.Exceptions.IdNotFoundException;
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
    public String saveCustomer(CustomerDTO customerDTO){
        Customer customer=new Customer();
        mapper.map(customerDTO, customer);
        customerRepository.save(customer);
        return "Data Saved!";
    }
    @Override
    public List<CustomerDTO> findAll(){
        return customerRepository.findAll()
                .stream()
                .map(customer -> mapper.map(customer, CustomerDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public SearchDTO findById(int id) {
        Customer customer = customerRepository.findById(id)
                .orElseThrow(() -> new IdNotFoundException("Customer not found with ID " + id));
        return mapper.map(customer, SearchDTO.class);
    }
    @Override
    public List<SearchDTO> findByfname(String fname){
        return customerRepository.findByfname(fname);
    }
    @Override
    public List<CustomerDTO> findByaccNo(String accNo){
        return customerRepository.findByaccNo(accNo);
    }
}
