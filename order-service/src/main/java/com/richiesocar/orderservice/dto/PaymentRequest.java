package com.richiesocar.orderservice.dto;

import com.richiesocar.orderservice.entities.Order;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
@AllArgsConstructor
@Data
@NoArgsConstructor
public class PaymentRequest {
  private Order order;
}
