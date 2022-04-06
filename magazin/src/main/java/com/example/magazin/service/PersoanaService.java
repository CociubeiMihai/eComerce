package com.example.magazin.service;

import com.example.magazin.dto.AuthDTO;
import com.example.magazin.dto.UpdatePersoanaRolDTO;
import com.example.magazin.model.Cart;
import com.example.magazin.model.Persoana;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface PersoanaService {

    Persoana updateRolPersoana(UpdatePersoanaRolDTO persoana);
    Persoana findFirstByNameAndPassword(AuthDTO dto);
    List<Persoana> findAll();
    Persoana deletePersoana(Long id);
    Persoana save(AuthDTO persoana);
    Persoana save(Persoana persoana);
    Persoana findByNume(String nume);

}
