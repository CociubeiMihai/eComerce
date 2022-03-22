package com.example.magazin.model.subProduse;

import com.example.magazin.constants.Marime;
import com.example.magazin.model.Produs;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class EchipamentProtectie extends Produs {

    private String culoare;
    private int nivelProtectie;
    private String material;
    private Marime marime;

}
