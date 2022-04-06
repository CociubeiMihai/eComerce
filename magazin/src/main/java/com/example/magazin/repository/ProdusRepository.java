package com.example.magazin.repository;

import com.example.magazin.model.Produs;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface  ProdusRepository extends CrudRepository<Produs,Long> {

    Produs findByNume(String nume);
    List<Produs> findByPretIsBetween(int low, int high);
    List<Produs> findByPretIsGreaterThan(int value);
    List<Produs> findByPretIsLessThan(int value);
    List<Produs> findByCantitateGreaterThan(int val);
}
