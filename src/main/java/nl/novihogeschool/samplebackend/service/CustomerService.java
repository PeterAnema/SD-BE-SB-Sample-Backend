package nl.novihogeschool.samplebackend.service;

import nl.novihogeschool.samplebackend.model.Customer;

import java.util.Collection;
import java.util.Optional;

public interface CustomerService {
    long createCustomer(Customer customer);
    void updateCustomer(long id, Customer customer);
    void deleteCustomer(long id);
    Collection<Customer> getCustomers(String customer_number);
    Optional<Customer> getCustomerById(long id);
    boolean customerExistsById(long id);
}