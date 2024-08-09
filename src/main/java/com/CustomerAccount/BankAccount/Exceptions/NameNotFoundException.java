package com.CustomerAccount.BankAccount.Exceptions;

public class NameNotFoundException extends RuntimeException{
    public NameNotFoundException(String message){
        super(message);
    }
}
