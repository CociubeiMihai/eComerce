package com.example.magazin.controller;

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

    @GetMapping("/{nume}")
    public ResponseEntity findCarByNume(@PathVariable String nume) throws ApiExceptionResponse {
        return ResponseEntity.status(HttpStatus.OK).body(persoanaService.findByNume(nume));
    }

    @PostMapping
    public ResponseEntity saveNewPersoana(@RequestBody Persoana persoana){
        return ResponseEntity.status(HttpStatus.OK).body(persoanaService.save(persoana));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deletePersoanaById(@PathVariable Long id){
        return ResponseEntity.status(HttpStatus.OK).body(persoanaService.deletePersoana(id));
    }

    @PutMapping
    public ResponseEntity updatePersoana(@RequestBody UpdatePersoanaRolDTO dto){
        return ResponseEntity.status(HttpStatus.OK).body(persoanaService.updateRolPersoana(dto));
    }

}
