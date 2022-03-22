package com.example.magazin.repository;

import com.example.magazin.model.subProduse.EchipamentProtectie;
import com.example.magazin.constants.Marime;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EchipamentProtectieRepository extends CrudRepository<EchipamentProtectie,Long> {

    List<EchipamentProtectie> findByMaterial(String material);
    List<EchipamentProtectie> findByNivelProtectieGreaterThanEqual(int nivel);
    List<EchipamentProtectie> findByMarime(Marime marime);
    List<EchipamentProtectie> findByCuloare(String culoare);
}
