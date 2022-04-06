package com.example.magazin.service;

import com.example.magazin.dto.CardDto;
import com.example.magazin.model.Card;
import org.springframework.stereotype.Component;

@Component
public interface CardService {

    Card findCardByCcvAndNumber(CardDto cardDto);
    Card verificaBalance(CardDto cardDto);
    Card plateste(CardDto cardDto);
}
