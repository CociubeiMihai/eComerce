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
@CrossOrigin(origins = "http://localhost:3000")
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

    @ApiOperation(value = "Ne filtreaza produsele dupa nume > < si valoarea indicata. Returneaza o lista de produse")
    @GetMapping("/{camp}/{valoare}")
    public ResponseEntity findByValue(@PathVariable String camp, @PathVariable String valoare){
        if(camp.equals("nume"))
            return ResponseEntity.status(HttpStatus.OK).body(produsService.findByNumePartial(valoare));
        if(camp.equals(">"))
            return ResponseEntity.status(HttpStatus.OK).body(produsService.findByPrice(">",Integer.valueOf(valoare)));
        if(camp.equals("<"))
            return ResponseEntity.status(HttpStatus.OK).body(produsService.findByPrice("<",Integer.valueOf(valoare)));
        return (ResponseEntity) ResponseEntity.status(HttpStatus.BAD_REQUEST);

    }

    @ApiOperation(value = "Cauta un produs dupa numele sau")
    @GetMapping("/{nume}")
    public ResponseEntity findCarByNume(@PathVariable String nume) throws ApiExceptionResponse {
        return ResponseEntity.status(HttpStatus.OK).body(produsService.findByNume(nume));
    }

    @ApiOperation(value = "Actualizam stocul unui produs. Trebuie sa i trimitem id produsului si noua cantitate")
    @PutMapping
    public ResponseEntity updateStoc(@RequestBody UpdateProdusStocDTO dto){
        return ResponseEntity.status(HttpStatus.OK).body(produsService.updateStoc(dto));
    }

    @ApiOperation(value = "Ne gaseste echipamente de protectie dupa material")
    @GetMapping("/material/{nume}")
    public ResponseEntity findCarByMaterial(@PathVariable String nume) throws ApiExceptionResponse {
        return ResponseEntity.status(HttpStatus.OK).body(echipamentProtectieService.findByMaterial(nume));
    }

    @ApiOperation(value = "Ne gaseste echipamente de protectie dupa nivelul de protectie oferit")
    @GetMapping("/protectie/{nivel}")
    public ResponseEntity findCarByNivelProtectie(@PathVariable int nivel) throws ApiExceptionResponse {
        return ResponseEntity.status(HttpStatus.OK).body(echipamentProtectieService.findByNivelProtectie(nivel));
    }

    @ApiOperation(value = "Returneaza produse in intervalul low-high")
    @GetMapping("/price/{low}/{high}")
    public ResponseEntity findCarByPriceBetwin(@PathVariable int low, @PathVariable int high) throws ApiExceptionResponse {
        return ResponseEntity.status(HttpStatus.OK).body(produsService.findByPriceBetwin(low,high));
    }

    @ApiOperation(value = "Salvam un nou produs pe care il va si returna")
    @PostMapping
    public ResponseEntity saveNewProdus(@RequestBody Produs produs){
        return ResponseEntity.status(HttpStatus.OK).body(produsService.save(produs));
    }

    @ApiOperation(value = "Salvam un echipament de protectie pe care il vom returna")
    @PostMapping("/e")
    public ResponseEntity saveNewEchipament(@RequestBody EchipamentProtectie echipamentProtectie){
        return ResponseEntity.status(HttpStatus.OK).body(echipamentProtectieService.save(echipamentProtectie));
    }

    @ApiOperation(value = "Stergem un produs din baza de date.")
    @PutMapping("/remove/{id}")
    public ResponseEntity deleteProdus(@PathVariable Long id){
        return ResponseEntity.status(HttpStatus.OK).body(produsService.deleteProduct(id));
    }


}
