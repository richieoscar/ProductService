package com.richieoscar.payment.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "payment_table")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Payment {
    @Id
    @SequenceGenerator(name = "payment_sequence", sequenceName = "payment_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "payment_sequence")
    private Long paymentId;
    private String transactionId;
    private String paymentStatus;
    private Long orderId;
    private BigDecimal amount;
    private LocalDateTime dateOfPayment;
}
