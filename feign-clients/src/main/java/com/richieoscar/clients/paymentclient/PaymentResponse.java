package com.richieoscar.clients.paymentclient;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PaymentResponse implements Serializable {
    private String paymentStatus;
    private String transactionId;
}
