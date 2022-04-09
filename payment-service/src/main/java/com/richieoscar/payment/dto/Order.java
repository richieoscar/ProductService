package com.richieoscar.payment.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Order {
    private Long id;
    private String name;
    private int quantity;
    private BigDecimal price;
}
