package com.example.magazin.utils;

import com.example.magazin.model.Produs;

import javax.persistence.PostPersist;

public class ProdusEventListener {

    @PostPersist
    public void modifyCreation(Produs produs){
        System.out.println("Produs: " + produs.getNume());
    }

}
