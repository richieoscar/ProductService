package com.richieoscar.payment.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PaymentResponse {

    private String paymentStatus;
    private String transactionId;
    private BigDecimal amount;
    private LocalDateTime dateOfPayment;
    private Long paymentId;
}
