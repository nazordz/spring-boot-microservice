package com.amigoscode.fraud.repositories;

import com.amigoscode.fraud.entites.FraudCheckHistory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FraudCheckHistoryRepository extends JpaRepository<FraudCheckHistory, Integer> {
}
