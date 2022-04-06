package com.example.magazin.service;

import com.example.magazin.dto.AddCartDto;
import com.example.magazin.model.Cart;
import com.example.magazin.model.Produs;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface CartService {

    Cart addToCart(Produs produs,Long idPersoana);
    Cart save(Cart cart);
    List<Produs> findAllProducts(Long idPersoana);

    Cart addToCart(AddCartDto addCartDto);
    Cart emptyCart(Long idPersoana);
    int total(Long idPersoana);
}
