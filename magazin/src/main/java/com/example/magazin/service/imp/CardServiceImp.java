package com.example.magazin.service.imp;

import com.example.magazin.dto.CardDto;
import com.example.magazin.model.Card;

import com.example.magazin.model.Cart;
import com.example.magazin.repository.CardRepository;
import com.example.magazin.repository.PersoanaRepository;
import com.example.magazin.service.CardService;
import com.example.magazin.service.ComandaService;
import org.springframework.stereotype.Service;

@Service
public class CardServiceImp implements CardService {

    private final CardRepository cardRepository;
    private final PersoanaRepository persoanaRepository;
    private final ComandaService comandaService;

    public CardServiceImp(CardRepository cardRepository, PersoanaRepository persoanaRepository, ComandaService comandaService) {
        this.cardRepository = cardRepository;
        this.persoanaRepository = persoanaRepository;
        this.comandaService = comandaService;
    }

    @Override
    public Card findCardByCcvAndNumber(CardDto cardDto) {
        if(cardRepository.findCardByCcvAndNumber(cardDto.getCcv(),cardDto.getNumber()) != null)
            return verificaBalance(cardDto);
        return null;
    }

    @Override
    public Card verificaBalance(CardDto cardDto) {
        if(persoanaRepository.findById(cardDto.getIdPersoana()).get().getCart().getTotal() <= cardRepository.findCardByNumber(cardDto.getNumber()).getBalance())
           return plateste(cardDto);
        return null;
    }

    @Override
    public Card plateste(CardDto cardDto) {
        Card card = cardRepository.findCardByNumber(cardDto.getNumber());
        Cart cart = persoanaRepository.findById(cardDto.getIdPersoana()).get().getCart();
        card.setBalance(card.getBalance() - cart.getTotal());
        cardRepository.save(card);

        comandaService.addComanda(cardDto.getIdPersoana(),"Da");
        return card;
    }


}
