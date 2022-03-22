package com.example.magazin.controller;

import com.example.magazin.dto.UpdateProdusStocDTO;
import com.example.magazin.exceptions.ApiExceptionResponse;
import com.example.magazin.model.Persoana;
import com.example.magazin.model.Produs;
import com.example.magazin.model.subProduse.EchipamentProtectie;
import com.example.magazin.service.EchipamentProtectieService;
import com.example.magazin.service.ProdusService;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/produs")
public class ProdusController {

    private final ProdusService produsService;
    private final EchipamentProtectieService echipamentProtectieService;


    public ProdusController(ProdusService produsService, EchipamentProtectieService echipamentProtectieService) {
        this.produsService = produsService;
        this.echipamentProtectieService = echipamentProtectieService;
    }

    @ApiOperation(value = "Returns a list of all products")
    @GetMapping()
    public ResponseEntity findAllProduscts(){
        return ResponseEntity.status(HttpStatus.OK).body(produsService.findAll());
    }

    @GetMapping("/{nume}")
    public ResponseEntity findCarByNume(@PathVariable String nume) throws ApiExceptionResponse {
        return ResponseEntity.status(HttpStatus.OK).body(produsService.findByNume(nume));
    }

    @PutMapping
    public ResponseEntity updateStoc(@RequestBody UpdateProdusStocDTO dto){
        return ResponseEntity.status(HttpStatus.OK).body(produsService.updateStoc(dto));
    }

    @GetMapping("/material/{nume}")
    public ResponseEntity findCarByMaterial(@PathVariable String nume) throws ApiExceptionResponse {
        return ResponseEntity.status(HttpStatus.OK).body(echipamentProtectieService.findByMaterial(nume));
    }

    @GetMapping("/protectie/{nivel}")
    public ResponseEntity findCarByNivelProtectie(@PathVariable int nivel) throws ApiExceptionResponse {
        return ResponseEntity.status(HttpStatus.OK).body(echipamentProtectieService.findByNivelProtectie(nivel));
    }

    @GetMapping("/price/{low}/{high}")
    public ResponseEntity findCarByPriceBetwin(@PathVariable int low, @PathVariable int high) throws ApiExceptionResponse {
        return ResponseEntity.status(HttpStatus.OK).body(produsService.findByPriceBetwin(low,high));
    }

    @PostMapping
    public ResponseEntity saveNewProdus(@RequestBody Produs produs){
        return ResponseEntity.status(HttpStatus.OK).body(produsService.save(produs));
    }

    @PostMapping("/e")
    public ResponseEntity saveNewEchipament(@RequestBody EchipamentProtectie echipamentProtectie){
        return ResponseEntity.status(HttpStatus.OK).body(echipamentProtectieService.save(echipamentProtectie));
    }

}
