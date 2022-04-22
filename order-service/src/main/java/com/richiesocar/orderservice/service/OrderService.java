package com.richiesocar.orderservice.service;

import com.richieoscar.clients.paymentclient.PaymentClient;
import com.richieoscar.clients.paymentclient.PaymentRequest;
import com.richieoscar.clients.paymentclient.PaymentResponse;
import com.richiesocar.orderservice.dto.OrderRequest;
import com.richiesocar.orderservice.entities.Order;
import com.richiesocar.orderservice.repository.OrderRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Service;

@Service
@RefreshScope
@Slf4j
public class OrderService {
    private final OrderRepository orderRepository;
    // private final RestTemplate restTemplate;
    private final PaymentClient paymentClient;

    @Autowired
    public OrderService(OrderRepository orderRepository, PaymentClient paymentClient) {
        this.orderRepository = orderRepository;
        this.paymentClient = paymentClient;
    }

    @Value("${microservice.payment-service.endpoints.endpoint.uri}")
    private String PAYMENT_SERVICE_ENDPOINT_URL;

    public void saveOrder(OrderRequest request) {
        Order order = new Order();
        order.setName(request.getName());
        order.setPrice(request.getPrice());
        order.setQuantity(request.getQuantity());
        log.info("Saving Order {}", order);
        orderRepository.save(order);
    }

    public PaymentResponse makePayment(PaymentRequest request) {
        log.info("Making Rest call from Order Service to Payment Service to make payment: {}", request);
        return paymentClient.makePayment(request);
        //  return restTemplate.postForObject(PAYMENT_SERVICE_ENDPOINT_URL, request, PaymentResponse.class);
    }
}
