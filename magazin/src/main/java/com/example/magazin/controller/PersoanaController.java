package com.example.magazin.controller;

import com.example.magazin.dto.AuthDTO;
import com.example.magazin.dto.UpdatePersoanaRolDTO;
import com.example.magazin.exceptions.ApiExceptionResponse;
import com.example.magazin.model.Persoana;
import com.example.magazin.service.PersoanaService;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/persoana")
@CrossOrigin(origins = "http://localhost:3000")
public class PersoanaController {

    private final PersoanaService persoanaService;


    public PersoanaController(PersoanaService persoanaService) {
        this.persoanaService = persoanaService;
    }

    @ApiOperation(value = "Returns a list of all users")
    @GetMapping()
    public ResponseEntity findAllUsers(){
        return ResponseEntity.status(HttpStatus.OK).body(persoanaService.findAll());
    }

    @ApiOperation(value = "Ne gaseste o persoana dupa nume")
    @GetMapping("/{nume}")
    public ResponseEntity findCarByNume(@PathVariable String nume) throws ApiExceptionResponse {
        return ResponseEntity.status(HttpStatus.OK).body(persoanaService.findByNume(nume));
    }

    @ApiOperation(value = "Adauga in baza de date o noua persoana pe care o va returna")
    @PostMapping("/register")
    public ResponseEntity saveNewPersoana(@RequestBody AuthDTO persoana){
        return ResponseEntity.status(HttpStatus.OK).body(persoanaService.save(persoana));
    }

    @ApiOperation("Sterge o persoana din baza de date pe care o si returneaza")
    @DeleteMapping("/{id}")
    public ResponseEntity deletePersoanaById(@PathVariable Long id){
        return ResponseEntity.status(HttpStatus.OK).body(persoanaService.deletePersoana(id));
    }

    @ApiOperation(value = "Schimba rolul unei persoane pe care o va si returna")
    @PutMapping
    public ResponseEntity updatePersoana(@RequestBody UpdatePersoanaRolDTO dto){
        return ResponseEntity.status(HttpStatus.OK).body(persoanaService.updateRolPersoana(dto));
    }

}
