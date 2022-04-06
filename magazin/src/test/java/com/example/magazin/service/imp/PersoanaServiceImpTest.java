package com.example.magazin.service.imp;

import com.example.magazin.constants.Rol;
import com.example.magazin.dto.AuthDTO;
import com.example.magazin.model.Persoana;
import com.example.magazin.repository.PersoanaRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;

class PersoanaServiceImpTest {

    private static final String NUME = "persoanaTest";
    private static final String PAROLA = "pass";


    //UUT
    private PersoanaServiceImp persoanaServiceImp;

    @Mock
    private PersoanaRepository persoanaRepository;

    private Persoana persoana;
    private AuthDTO authDTO;

    @BeforeEach
    void setUp() {
        initMocks(this);
        persoana = new Persoana();
        persoana.setNume(NUME);
        persoana.setParola(PAROLA);
        persoana.setRol(Rol.USER);

        authDTO = new AuthDTO();
        authDTO.setParola(PAROLA);
        authDTO.setNume(NUME);

        when(persoanaRepository.findByNumeAndParola(NUME,PAROLA)).thenReturn(persoana);
    }

    @Test
    void givenExistingNumeAndPass_whenFindByNumeAndPass_thenFindOne() {
        //given


    }

}