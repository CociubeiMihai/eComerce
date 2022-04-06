package com.example.magazin.dto;

import com.example.magazin.model.Produs;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AddCartDto {
    private Long idPers;
    private Long idProdus;
}
