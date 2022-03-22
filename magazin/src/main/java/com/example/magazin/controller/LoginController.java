package com.example.magazin.controller;

import com.example.magazin.dto.AuthDTO;
import com.example.magazin.service.PersoanaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/login")
public class LoginController {

    private final PersoanaService persoanaService;

    public LoginController(PersoanaService persoanaService) {
        this.persoanaService = persoanaService;
    }

    @PostMapping
    public ResponseEntity login(@RequestBody AuthDTO auth){
        return ResponseEntity.status(HttpStatus.OK).body(persoanaService.findFirstByNameAndPassword(auth));
    }
}
