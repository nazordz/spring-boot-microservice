package com.amigoscode.fraud.services;

import com.amigoscode.fraud.entites.FraudCheckHistory;
import com.amigoscode.fraud.repositories.FraudCheckHistoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDateTime;

@Service
public class FraudCheckService {
    @Autowired
    private FraudCheckHistoryRepository repository;

    @Transactional
    public boolean isFraudulentCustomer(Integer customerId) {
        FraudCheckHistory data = FraudCheckHistory.builder()
                .customerId(customerId)
                .isFraudster(false)
                .createdAt(LocalDateTime.now())
                .build();
        repository.save(data);
        return false;
    }
}
