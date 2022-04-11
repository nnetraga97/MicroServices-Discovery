package com.nikhil.customer;

import com.nikhil.clients.fraud.FraudCheckResponse;
import com.nikhil.clients.fraud.FraudClient;
import com.nikhil.clients.notification.NotificationClient;
import com.nikhil.clients.notification.NotificationRequest;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@AllArgsConstructor
@Slf4j
public class CustomerService {

    private final CustomerRepository customerRepository;
    private final FraudClient fraudClient;
    private final NotificationClient notificationClient;

    public void registerCustomer(CustomerRegistrationRequest request) {
        Customer customer = Customer.builder()
                .firstName(request.firstName())
                .lastName(request.lastName())
                .email(request.email())
                .build();
        customerRepository.saveAndFlush(customer);

        FraudCheckResponse fraudCheckResponse=
                fraudClient.isFraudster(customer.getId());

        if (fraudCheckResponse.isFraudster()){
            throw new IllegalStateException("fraudster");
        }
        NotificationRequest tosend = new NotificationRequest
                (customer.getId(),
                        customer.getEmail(),
                        "Hello!! Welcome to the System");
        log.info("noticification request: {}",tosend);
        notificationClient.sendNotification(tosend);

    }

}
