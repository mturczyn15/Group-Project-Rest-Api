package com.kodilla.ecommercee.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;


@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@Entity
@Table(name = "CART_ITEM")
public class CartItem {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    @Column(name = "CART_ITEM_ID")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "PRODUCT_ID")
    private Product  product;

    @Column(name = "PRODUCT_NAME")
    private String productName;

    @Column(name = "PRICE_DATE")
    private LocalDate priceDate;

    @Column(name = "PRODUCT_COUNT")
    private Long productCount;

    @Column(name = "ADDED_DATE")
    private LocalDate addedDate;

    @ManyToOne
    @JoinColumn(name = "CART_ID")
    private Cart cart;
}

