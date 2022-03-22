package com.example.magazin.model;

import com.example.magazin.constants.Rol;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Builder
public class Persoana {

    @Id
    @GeneratedValue
    private Long id;
    private String nume;
    private String prenume;
    private String email;
    private String parola;
    private Rol rol;

    @OneToMany(fetch = FetchType.EAGER)
    private List<Produs> produsListl;

    @OneToOne
    private Cart cart;

    public String toString(){
        return "Id-ul persoanei: "+id + " numele: "+nume+" prenumele: "+prenume+" email: "+email+" cu rolul: "+rol;
    }
}
