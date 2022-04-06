package com.example.magazin.repository;

import com.example.magazin.model.Comanda;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ComandaRepository extends CrudRepository<Comanda,Long> {

    List<Comanda> findByIdpersoana(Long id);
}
