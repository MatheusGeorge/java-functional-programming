package br.com.estudos.functionalInterface;

import java.util.function.BiConsumer;
import java.util.function.Consumer;

public class _Consumer {

    public static void main(String[] args) {
        // IMPERATIVE
        Customer maria = new Customer("Maria", "99999");
        greetCustomer(maria);
        greetCustomerV2(maria, false);

        //DECLARATIVE
        greetCustomerConsumer.accept(maria);
        greetCustomerConsumerV2.accept(maria, false);
    }

    // IMPERATIVE
    static void greetCustomer(Customer customer) {
        System.out.println("Hello " + customer.customerName + ", thanks for registering phone number "
                + customer.customerPhoneNumber);
    }

    static void greetCustomerV2(Customer customer, Boolean showPhoneNumber) {
        System.out.println("Hello " + customer.customerName + ", thanks for registering phone number "
                + (showPhoneNumber ? customer.customerPhoneNumber : "******"));
    }

    //DECLARATIVE
    static Consumer<Customer> greetCustomerConsumer = customer ->
            System.out.println("Hello " + customer.customerName + ", thanks for registering phone number "
                    + customer.customerPhoneNumber);

    static BiConsumer<Customer, Boolean> greetCustomerConsumerV2 = (customer, showPhoneNumber) ->
            System.out.println("Hello " + customer.customerName + ", thanks for registering phone number "
                    + (showPhoneNumber ? customer.customerPhoneNumber : "******"));

    static class Customer {
        private final String customerName;
        private final String customerPhoneNumber;

        public Customer(String customerName, String customerPhoneNumber) {
            this.customerName = customerName;
            this.customerPhoneNumber = customerPhoneNumber;
        }
    }
}
