package br.com.estudos.combinatorPattern;

import java.time.LocalDate;
import static br.com.estudos.combinatorPattern.CustomerRegistrationValidator.*;

public class Main {

    public static void main(String[] args) {
        Customer customer = new Customer(
                "Alice",
                "alice@gmail.com",
                "+098764321",
                LocalDate.of(2000, 1,1)
        );
    //    System.out.println(new CustomerValidatorService().isValid(customer));

        //If valid we can store customer in db

        //Using Combinator Pattern
        ValidationResult result = isEmailValid()
                .and(isPhoneNumberValid())
                .and(isAdult())
                .apply(customer);

        System.out.println(result);
        if(result != ValidationResult.SUCCESS) {
            throw new IllegalStateException(result.name());
        }

    }
}
