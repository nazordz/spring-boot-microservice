package com.nazorcode.customer.services;

import com.nazorcode.customer.dao.Customer;
import com.nazorcode.customer.dao.CustomerRegistrationRequest;
import com.nazorcode.customer.dao.FraudCheckResponse;
import com.nazorcode.customer.repositories.CustomerRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@Slf4j
public record CustomerService(
        CustomerRepository customerRepository, RestTemplate restTemplate
) {
    public void register(CustomerRegistrationRequest request) {
        Customer customer = new Customer();
        customer.setEmail(request.getEmail());
        customer.setFirstName(request.getFirstName());
        customer.setLastName(request.getLastName());
        customerRepository.saveAndFlush(customer);
        log.info("customer {}", customer);
        FraudCheckResponse response = restTemplate.getForObject(
                "http://localhost:8081/api/v1/fraud-check/{customerId}",
                FraudCheckResponse.class,
                customer.getId()
        );

        if (response.isFraudster()) {
            throw new IllegalStateException("Fraudster");
        }
    }
}
