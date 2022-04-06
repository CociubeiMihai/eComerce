package com.example.magazin.controller;

import com.example.magazin.dto.AuthDTO;
import com.example.magazin.service.PersoanaService;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/login")
@CrossOrigin(origins = "http://localhost:3000")
public class LoginController {

    private final PersoanaService persoanaService;

    public LoginController(PersoanaService persoanaService) {
        this.persoanaService = persoanaService;
    }

    @ApiOperation(value = "Realizeaza conexiunea la aplicatie. Returneaza o persoana")
    @PostMapping
    public ResponseEntity login(@RequestBody AuthDTO auth){
        return ResponseEntity.status(HttpStatus.OK).body(persoanaService.findFirstByNameAndPassword(auth));
    }
}
