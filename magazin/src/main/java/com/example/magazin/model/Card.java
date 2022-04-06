package com.example.magazin.model;


import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Builder
public class Card {

    @Id
    @GeneratedValue
    private Long id;

    private int ccv;
    private Long number;
    private int balance;
}
