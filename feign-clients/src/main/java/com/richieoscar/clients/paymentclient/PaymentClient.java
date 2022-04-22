package com.richieoscar.clients.paymentclient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(value = "payment-service")
public interface PaymentClient {
    @PostMapping("/api/v1/payment/pay")
    PaymentResponse makePayment(@RequestBody PaymentRequest request);
}
