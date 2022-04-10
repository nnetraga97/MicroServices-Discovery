package com.nikhil.fraud;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@AllArgsConstructor
public class FraudCheckService {

    private final FraudCheckHistoryRepository fraudCheckHistoryRepository;

    public boolean isFraudulentCustomer(Integer customerid){
        fraudCheckHistoryRepository.save(
                FraudCheckHistory.builder().customerid(customerid)
                        .isFraudster(false)
                        .createdAt(LocalDateTime.now())
                        .build()
                       );

        return false;
    }


}
