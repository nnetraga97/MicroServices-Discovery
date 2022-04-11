package com.nikhil.notification;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication(
        scanBasePackages = {
                "com.nikhil.notification",
                "com.nikhil.amqp"
        }
)
public class NotificationApplication {

    public static void main(String[] args) {
        SpringApplication.run(NotificationApplication.class,args);
    }

    //Publish testing
    /*@Bean
    CommandLineRunner commandLineRunner(
            RabbitMQMessageProducer producer, NotificationConfig notificationConfig){
        return args -> {
            producer.publish(new Person("Nikhil",24),
                    notificationConfig.getInternalExchange(),
                    notificationConfig.getInternalNotificationRoutingKey());
        };
    }

    record Person(String name, int age){}*/
}
