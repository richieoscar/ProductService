package com.richiesocar.orderservice.controllers;

import com.richiesocar.orderservice.dto.OrderRequest;
import com.richiesocar.orderservice.dto.PaymentRequest;
import com.richiesocar.orderservice.dto.PaymentResponse;
import com.richiesocar.orderservice.service.OrderService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/order")
@AllArgsConstructor
public class OrderController {
    private final OrderService orderService;

    @PostMapping("/save")
    public ResponseEntity<String> saveOrder(@RequestBody OrderRequest request) {
        if (request != null) {
            orderService.saveOrder(request);
            return ResponseEntity.ok("Order Created");
        }
        return null;
    }

    @PostMapping("/make-payment")
    public PaymentResponse makePayment(@RequestBody PaymentRequest request) {
        return orderService.makePayment(request);
    }
}
