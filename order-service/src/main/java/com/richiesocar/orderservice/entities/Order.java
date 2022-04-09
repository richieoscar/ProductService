package com.richiesocar.orderservice.entities;

import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Getter
@Setter
@ToString
@Table(name = "order_table")
@AllArgsConstructor
@NoArgsConstructor
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private int quantity;
    private BigDecimal price;
}
