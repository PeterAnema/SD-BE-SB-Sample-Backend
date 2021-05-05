package nl.novihogeschool.samplebackend.repository;

import nl.novihogeschool.samplebackend.model.Customer;

//import org.springframework.data.repository.CrudRepository;
//import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collection;

public interface CustomerRepository extends JpaRepository<Customer, Long> {

    Collection<Customer> findAllByCustomerNumber(String customer_number);

}