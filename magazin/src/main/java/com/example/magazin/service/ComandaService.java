package com.example.magazin.service;

import com.example.magazin.model.Comanda;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
public interface ComandaService {

    Comanda addComanda(Long idPersoana, String achitat);
    List<Comanda> findPersonComanda(Long idPersoana);
    List<Comanda> findComenziPrimite(Long idPersoana);
    List<Comanda> findAll();
}
