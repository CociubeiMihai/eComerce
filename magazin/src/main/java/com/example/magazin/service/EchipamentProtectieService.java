package com.example.magazin.service;

import com.example.magazin.model.subProduse.EchipamentProtectie;
import com.example.magazin.constants.Marime;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface EchipamentProtectieService {

    List<EchipamentProtectie> findByMaterial(String material);
    List<EchipamentProtectie> findByNivelProtectie(int nivel);
    List<EchipamentProtectie> findByMarime(Marime marime);
    List<EchipamentProtectie> findByCuloare(String culoare);
    List<EchipamentProtectie> findAll();
    EchipamentProtectie deleteEchipament(Long id);
    EchipamentProtectie save(EchipamentProtectie echipamentProtectie);


}
