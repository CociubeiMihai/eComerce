package com.example.magazin.service;

import com.example.magazin.model.subProduse.Miere;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface MiereService {

    Miere findByCantitate(int cantitate);
    Miere findByLot(int lot);
    List<Miere> findAll();
    Miere deleteMiere(Long id);
    Miere save(Miere miere);

}
