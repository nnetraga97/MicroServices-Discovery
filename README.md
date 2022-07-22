# MicroServices-Discovery
Microservice discovery

3 APIS - Notification, Customer and Fraud

Simulating Custom full microservice deployment without Cloud. (On-premise)

Mainly discovery for why Cloud is better that on pupose

Architecure  - 

1) Tracing - Zipkin
2) Logs - SL4j (main integration for above)
3) Api Gateway - A custom api gateway using Feign.
4) Messaging - Kafka/RabbitMq. Both queues were tested to see which perform better. 
5) Container - Docker/DockerHub. Images are private 
6) Datbase  - postgres
7) Cluster - minikube
8) SourceControl - Git(here)
