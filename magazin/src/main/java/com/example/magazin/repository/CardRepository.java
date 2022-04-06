package com.example.magazin.repository;

import com.example.magazin.model.Card;
import com.example.magazin.model.Cart;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CardRepository extends CrudRepository<Card,Long> {

    Card findCardByCcvAndNumber(int ccv, Long number);
    Card findCardByNumber(Long number);
}
