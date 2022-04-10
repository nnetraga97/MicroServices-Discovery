package com.nikhil.fraud;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/fraud-check")
@AllArgsConstructor
@Slf4j
public class FraudController {

    private final FraudCheckService fraudCheckService;

    @GetMapping(path = "/{customerid}")
    public FraudCheckResponse isFraudster(@PathVariable Integer customerid){
        boolean isFraudulentCustomer = fraudCheckService.isFraudulentCustomer(customerid);
        log.info("fraud check request for customer{}",customerid);
        return new FraudCheckResponse(isFraudulentCustomer);
    }
}
