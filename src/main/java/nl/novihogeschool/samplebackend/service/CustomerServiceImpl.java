package nl.novihogeschool.samplebackend.service;

import nl.novihogeschool.samplebackend.exceptions.RecordNotFoundException;
import nl.novihogeschool.samplebackend.model.Customer;
import nl.novihogeschool.samplebackend.repository.CustomerRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Optional;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public Collection<Customer> getCustomers(String customer_number) {
        if (customer_number != null && !customer_number.isEmpty()) {
            return customerRepository.findAllByCustomerNumber(customer_number);
        }
        else {
            return customerRepository.findAll();
        }
    }

    @Override
    public long createCustomer(Customer customer) {
        Customer newCustomer = customerRepository.save(customer);
        return newCustomer.getId();
    }

    @Override
    public void updateCustomer(long id, Customer newCustomer) {
        Optional<Customer> optionalCustomer = customerRepository.findById(id);
        Customer customer;
        if (optionalCustomer.isPresent()) {
            customer = optionalCustomer.get();
            customer.setFirstName(newCustomer.getFirstName());
            customer.setLastName(newCustomer.getLastName());
            customerRepository.save(customer);
        }
        else {
            throw new RecordNotFoundException();
        }
    }

    @Override
    public void deleteCustomer(long id) {
        if (!customerRepository.existsById(id)) throw new RecordNotFoundException();
        customerRepository.deleteById(id);
    }

    @Override
    public Optional<Customer> getCustomerById(long id) {
        if (!customerRepository.existsById(id)) throw new RecordNotFoundException();
        return customerRepository.findById(id);
    }

    @Override
    public boolean customerExistsById(long id) {
        return customerRepository.existsById(id);
    }

}