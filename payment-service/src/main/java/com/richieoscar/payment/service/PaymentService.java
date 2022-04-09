package com.richieoscar.payment.service;

import com.richieoscar.payment.dto.PaymentRequest;
import com.richieoscar.payment.dto.PaymentResponse;
import com.richieoscar.payment.entities.Payment;
import com.richieoscar.payment.exception.PaymentAlreadyExistException;
import com.richieoscar.payment.exception.PaymentNotFoundException;
import com.richieoscar.payment.repository.PaymentRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.Random;
import java.util.UUID;

@Service
@AllArgsConstructor
@Slf4j
public class PaymentService {

    private PaymentRepository paymentRepository;

    public PaymentResponse makePayment(PaymentRequest request) {
        Optional<Payment> optionalPayment = paymentRepository.findByOrderId(request.getOrder().getId());
        if (optionalPayment.isPresent()) {
            throw new PaymentAlreadyExistException(String.format("Payment for this order  with %d  has already been made", request.getOrder().getId()));
        } else {
            String paymentStatus = getPaymentStatus();
            Payment payment = new Payment();
            payment.setTransactionId(UUID.randomUUID().toString());
            payment.setPaymentStatus(getPaymentStatus());
            payment.setOrderId(request.getOrder().getId());
            payment.setDateOfPayment(LocalDateTime.now());
            payment.setAmount(request.getOrder().getPrice());
            log.info("Saving Payment to Database {}", payment);
            Payment savedPayment = paymentRepository.save(payment);
            PaymentResponse response = new PaymentResponse();
            response.setTransactionId(savedPayment.getTransactionId());
            response.setPaymentStatus(savedPayment.getPaymentStatus());
            return response;
        }
    }

    public String getPaymentStatus() {
        //make an api call to third party payment gateway and get response
        // this is a mock
        return new Random().nextBoolean() ? "Success" : "Not Successful";
    }

    public Payment getPaymentByOrderId(Long orderId){
        log.info("Retrieving payment with Id {}", orderId);
       return paymentRepository.findByOrderId(orderId)
               .orElseThrow(()-> new PaymentNotFoundException(String.format("Payment with %d does not exit",orderId)));
    }

}
