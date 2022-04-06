package com.example.magazin.model;

import lombok.*;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Builder
public class Comanda {

    @Id
    @GeneratedValue
    private Long id;
    private LocalDateTime data;
    private Long idpersoana;
    private int total;
    private String achitat;

    @ManyToMany(fetch = FetchType.EAGER)
    private List<Produs> produse;
}
