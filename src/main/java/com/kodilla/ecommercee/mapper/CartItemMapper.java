package com.kodilla.ecommercee.mapper;


import com.kodilla.ecommercee.domain.Cart;
import com.kodilla.ecommercee.domain.CartItem;
import com.kodilla.ecommercee.domain.CartItemDto;
import com.kodilla.ecommercee.domain.Product;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class CartItemMapper {

    public CartItem mapToCartItem(final CartItemDto cartItemDto, final Cart cart, final Product product) {
        return CartItem.builder()
                .id(cartItemDto.getId())
                .product(product)
                .productName(cartItemDto.getProductName())
                .priceDate(cartItemDto.getPriceDate())
                .productCount(cartItemDto.getProductCount())
                .addedDate(cartItemDto.getAddedDate())
                .cart(cart)
                .build();
    }

    public CartItemDto mapToCartItemDto(final CartItem cartItem) {
        CartItemDto.builder()
                .cartId(cartItem.getId())
                .build();
        return new CartItemDto(
                cartItem.getId(),
                cartItem.getProduct().getId(),
                cartItem.getCart().getId(),
                cartItem.getProductName(),
                cartItem.getPriceDate(),
                cartItem.getProductCount(),
                cartItem.getAddedDate()
        );
    }

    public List<CartItemDto> mapToDtoList(final List<CartItem> cartItemList) {
        return cartItemList.stream()
                .map(this::mapToCartItemDto)
                .collect(Collectors.toList());
    }


}
