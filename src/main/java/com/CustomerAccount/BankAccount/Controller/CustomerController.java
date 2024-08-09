package com.CustomerAccount.BankAccount.Controller;

import com.CustomerAccount.BankAccount.DTO.CustomerDTO;
import com.CustomerAccount.BankAccount.DTO.SearchDTO;
import com.CustomerAccount.BankAccount.Entity.Customer;
import com.CustomerAccount.BankAccount.Exceptions.AccountNotFoundException;
import com.CustomerAccount.BankAccount.Exceptions.IdNotFoundException;
import com.CustomerAccount.BankAccount.Exceptions.NameNotFoundException;
import com.CustomerAccount.BankAccount.Services.CustomerServices;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Pattern;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.MergedAnnotations;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@Validated
public class CustomerController {
    @Autowired
    CustomerServices services;

    @GetMapping("/test")
    public String test(){
        return "This A Test Run!";
    }

    @PostMapping("/save")
    public String save(@Valid @RequestBody CustomerDTO customerDTO){
        services.saveCustomer(customerDTO);
        return "Data Saved";
    }
    @GetMapping("/all")
    public List<CustomerDTO> findAll(){
        return services.findAll();
    }

    @GetMapping("/id/{id}")
    public ResponseEntity<SearchDTO> getCustomerById(@PathVariable int id) {
        SearchDTO searchDTO = services.findById(id);
        return ResponseEntity.ok(searchDTO);
    }

    @GetMapping("/fname/{fname}")
    public List<SearchDTO> findByfname(@PathVariable String fname)throws NameNotFoundException {
        List<SearchDTO> searchDTO=services.findByfname(fname);
        if (searchDTO.isEmpty()){
            throw new NameNotFoundException("No User Found By Name: "+fname);
        }
        return searchDTO;
    }
    @GetMapping("/accNo/{accNo}")
    public List<CustomerDTO> findByaccNo(@PathVariable String accNo)throws AccountNotFoundException{
        List<CustomerDTO> customerDTO=services.findByaccNo(accNo);
        if (customerDTO.isEmpty()){
            throw new AccountNotFoundException("No Account Found By Account NUmber: "+accNo);
        }
        return customerDTO;
    }
}
