package com.example.magazin.repository;

import com.example.magazin.model.Persoana;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersoanaRepository extends CrudRepository<Persoana,Long> {

    Persoana findByNume(String nume);
    Persoana findByNumeAndParola(String nume, String parola);
}
