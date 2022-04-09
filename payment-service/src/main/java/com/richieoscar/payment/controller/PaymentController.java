package com.richieoscar.payment.controller;

import com.richieoscar.payment.dto.PaymentResponse;
import com.richieoscar.payment.entities.Payment;
import com.richieoscar.payment.service.PaymentService;
import com.richieoscar.payment.dto.PaymentRequest;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/payment")
@AllArgsConstructor
public class PaymentController {

    private PaymentService paymentService;

    @PostMapping("/pay")
    public ResponseEntity<PaymentResponse> makePayment(@RequestBody PaymentRequest request){
        PaymentResponse response = paymentService.makePayment(request);
        return new ResponseEntity<PaymentResponse>(response, HttpStatus.OK);
    }

    @GetMapping("/get-payment/{orderId}")
    public ResponseEntity<PaymentResponse> getPaymentByOrderId(@PathVariable("orderId") Long orderId){
        Payment payment = paymentService.getPaymentByOrderId(orderId);
        PaymentResponse response = new PaymentResponse();
        response.setPaymentStatus(payment.getPaymentStatus());
        response.setTransactionId(payment.getTransactionId());
        response.setAmount(payment.getAmount());
        response.setDateOfPayment(payment.getDateOfPayment());
        return new ResponseEntity<PaymentResponse>(response, HttpStatus.OK);
    }
}
