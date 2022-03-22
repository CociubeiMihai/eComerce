package com.example.magazin.model.subProduse;

import com.example.magazin.model.Produs;
import lombok.Data;

import javax.persistence.Entity;
import java.time.LocalDateTime;

@Entity
@Data
public class Miere extends Produs {

    private int cantitate;
    private int lot;
    private LocalDateTime dataExpirare;

}
