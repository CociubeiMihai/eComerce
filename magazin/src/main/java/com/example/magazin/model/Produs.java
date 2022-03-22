package com.example.magazin.model;


import lombok.*;

import javax.persistence.*;
import javax.swing.text.html.ImageView;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Builder
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class Produs {

    @Id
    @GeneratedValue
    private Long id;
    private String nume;
    private int pret;
    private String descriere;
    private int recenzie;
    private int cantitate;
    //private cv poza;

}
