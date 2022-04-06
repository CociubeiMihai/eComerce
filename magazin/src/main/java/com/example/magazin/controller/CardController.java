package com.example.magazin.controller;

import com.example.magazin.dto.CardDto;
import com.example.magazin.service.CardService;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/card")
@CrossOrigin(origins = "http://localhost:3000")
public class CardController {

    private final CardService cardService;

    public CardController(CardService cardService) {
        this.cardService = cardService;
    }

    @ApiOperation(value = "Controlează plata cu cardul și returnează cardul folosit in caz de eroare returnează null")
    @PostMapping
    public ResponseEntity plateste(@RequestBody CardDto cardDto){
        return ResponseEntity.status(HttpStatus.OK).body(cardService.findCardByCcvAndNumber(cardDto));
    }
}
