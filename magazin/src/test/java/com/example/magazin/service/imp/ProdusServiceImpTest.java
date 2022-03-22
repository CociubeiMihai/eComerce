package com.example.magazin.service.imp;

import com.example.magazin.model.Produs;
import com.example.magazin.repository.ProdusRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;

class ProdusServiceImpTest {

    private static final String NUME = "produsTest";
    private static final int PRET = 10;
    private static final int CANTITATE = 2;

    //UUT
    private ProdusServiceImp produsServiceImp;

    @Mock
    private ProdusRepository produsRepository;

    private Produs produs;

    @BeforeEach
    void setUp() {
        initMocks(this);
        produs = new Produs();
        produs.setNume(NUME);
        produs.setPret(PRET);
        produs.setCantitate(CANTITATE);
        when(produsRepository.findByNume(NUME)).thenReturn(produs);
    }

    @Test
    void givenExistingNume_whenFindByNume_thenFindOne() {
        //given
        produsServiceImp = new ProdusServiceImp(produsRepository);

        //when
        Produs produs1 = produsServiceImp.findByNume(NUME);

        //then
        assertNotNull(produs1);
        assertEquals(NUME, produs1.getNume());

    }
}