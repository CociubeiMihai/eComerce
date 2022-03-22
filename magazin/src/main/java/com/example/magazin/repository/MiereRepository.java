package com.example.magazin.repository;

import com.example.magazin.model.subProduse.Miere;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MiereRepository extends CrudRepository<Miere,Long> {

    Miere findByCantitate(int cantitate);
    Miere findByLot(int lot);

}
