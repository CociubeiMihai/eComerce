package com.example.magazin.service;

import com.example.magazin.constants.Rol;
import com.example.magazin.dto.UpdatePersoanaRolDTO;
import com.example.magazin.model.Cart;
import com.example.magazin.model.Persoana;
import com.example.magazin.model.Produs;
import com.example.magazin.repository.CartRepository;
import com.example.magazin.repository.PersoanaRepository;
import com.example.magazin.repository.ProdusRepository;
import com.example.magazin.service.imp.PersoanaServiceImp;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.*;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;

import static org.mockito.Mockito.when;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.verify;
import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
class PersoanaServiceTest {

    @InjectMocks
    private PersoanaServiceImp persoanaServiceImp;

    @Mock
    private PersoanaRepository persoanaRepository;


    @Test
    void save_persoana_expectedPersoana() {
        MockitoAnnotations.initMocks(this);
        Persoana persoana = Persoana.builder().nume("Marcel").parola("pass").rol(Rol.USER).build();
        when(persoanaRepository.save(ArgumentMatchers.any(Persoana.class))).thenReturn(persoana);

        Persoana created = persoanaServiceImp.save(persoana);
        assertThat(created.getNume()).isSameAs(persoana.getNume());
        verify(persoanaRepository).save(persoana);
    }


}