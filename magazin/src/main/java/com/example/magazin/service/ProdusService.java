package com.example.magazin.service;

import com.example.magazin.dto.UpdateProdusStocDTO;
import com.example.magazin.model.Produs;
import com.example.magazin.model.subProduse.EchipamentProtectie;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface ProdusService {

    Produs findByNume(String nume);
    Produs updateStoc(UpdateProdusStocDTO produs);
    List<Produs> findAll();
    List<Produs> findByPriceBetwin(int low,int high);
    Produs deleteProduct(Long id);
    Produs save(Produs echipamentProtectie);
    Produs findById(Long id);

}
