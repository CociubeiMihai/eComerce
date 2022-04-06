package com.example.magazin.controller;

import com.example.magazin.dto.AddCartDto;
import com.example.magazin.service.CartService;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cart")
@CrossOrigin(origins = "http://localhost:3000")
public class CartController {

    private final CartService cartService;

    public CartController(CartService cartService) {
        this.cartService = cartService;
    }

    @ApiOperation(value = "Primim lista de produse din cart a persoanei curent logate")
    @GetMapping("/all/{id}")
    public ResponseEntity findCart(@PathVariable Long id){
        return ResponseEntity.status(HttpStatus.OK).body(cartService.findAllProducts(id));
    }

    @ApiOperation(value = "Adauga un produs in cosul utilizatorului are nevoie de id persoanei si id produsului")
    @PostMapping("/addCart")
    public void addToCart(@RequestBody AddCartDto produs){
        cartService.addToCart(produs);
    }

    @ApiOperation(value = "Goleste cartul utilizatorului daca acesta s-a razgandit si doreste alte produse")
    @PostMapping("/empty/{id}")
    public ResponseEntity empltyCart(@PathVariable Long id){
        return ResponseEntity.status(HttpStatus.OK).body(cartService.emptyCart(id));
    }

    @ApiOperation(value = "Returneaza suma totala pe care trebuie sa o achite utilizatorul")
    @GetMapping("/total/{id}")
    public ResponseEntity total(@PathVariable Long id){
        return  ResponseEntity.status(HttpStatus.OK).body(cartService.total(id));
    }
}
