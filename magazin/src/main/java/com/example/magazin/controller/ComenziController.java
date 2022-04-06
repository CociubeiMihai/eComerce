package com.example.magazin.controller;

import com.example.magazin.service.ComandaService;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/comenzi")
@CrossOrigin(origins = "http://localhost:3000")
public class ComenziController {

    private final ComandaService comenziService;

    public ComenziController(ComandaService comandaService) {
        this.comenziService = comandaService;
    }

    @ApiOperation(value = "Plaseaza comanda. Functia are nevoie de id persoanei care doreste sa plaseze comanda si va returna o comanda")
    @PostMapping("/add/{id}")
    public ResponseEntity addComanda(@PathVariable Long id){
        //System.out.println(id);
        return ResponseEntity.status(HttpStatus.OK).body(comenziService.addComanda(id,"Nu"));
    }

    @ApiOperation(value = "Ne cauta comenzile plasate de un anumit utilizator pe care le va returna")
    @GetMapping("/findOrders/{id}")
    public ResponseEntity findOrder(@PathVariable Long id){
        return ResponseEntity.status(HttpStatus.OK).body(comenziService.findPersonComanda(id));
    }

    @ApiOperation(value = "Returneaza toate comenzile in care se afla produs vandut de o anumita persoana")
    @GetMapping("/primite/{id}")
    public ResponseEntity findOr(@PathVariable Long id){
        return ResponseEntity.status(HttpStatus.OK).body(comenziService.findComenziPrimite(id));
    }

}
