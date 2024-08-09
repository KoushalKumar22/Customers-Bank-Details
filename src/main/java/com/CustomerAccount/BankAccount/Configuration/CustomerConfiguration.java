package com.CustomerAccount.BankAccount.Configuration;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;

public class CustomerConfiguration {
    @Bean
    ModelMapper myModel(){
        return new ModelMapper();
    }
}
