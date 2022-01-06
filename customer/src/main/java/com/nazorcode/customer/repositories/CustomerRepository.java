package com.nazorcode.customer.repositories;

import com.nazorcode.customer.dao.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {
}
