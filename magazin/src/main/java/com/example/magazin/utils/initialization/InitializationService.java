package com.example.magazin.utils.initialization;

import com.example.magazin.controllerAux.LoginControllerGui;
import com.example.magazin.model.Cart;
import com.example.magazin.model.Persoana;
import com.example.magazin.model.Produs;
import com.example.magazin.repository.CartRepository;
import com.example.magazin.repository.EchipamentProtectieRepository;
import com.example.magazin.repository.PersoanaRepository;
import com.example.magazin.repository.ProdusRepository;
import com.example.magazin.service.CartService;
import com.example.magazin.service.PersoanaService;
import com.example.magazin.service.ProdusService;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InitializationService {

    private final MockDataRepo mockDataRepo;
    private final PersoanaRepository persoanaRepository;
    private final ProdusRepository produsRepository;
    private final EchipamentProtectieRepository echipamentProtectieRepository;
    private final CartRepository cartRepository;

    private final CartService cartService;
    private final PersoanaService persoanaService;
    private final ProdusService produsService;

    public InitializationService(MockDataRepo mockDataRepo, PersoanaRepository persoanaRepository, ProdusRepository produsRepository, EchipamentProtectieRepository echipamentProtectieRepository, CartRepository cartRepository, CartService cartService, PersoanaService persoanaService, ProdusService produsService) {
        this.mockDataRepo = mockDataRepo;
        this.persoanaRepository = persoanaRepository;
        this.produsRepository = produsRepository;
        this.echipamentProtectieRepository = echipamentProtectieRepository;
        this.cartRepository = cartRepository;
        this.cartService = cartService;
        this.persoanaService = persoanaService;
        this.produsService = produsService;
    }

    @Bean
    public void initializeData(){
        List<Produs> produses = (List<Produs>) produsRepository.saveAll(mockDataRepo.initProduse());
        List<Cart> cartList = (List<Cart>) cartRepository.saveAll(mockDataRepo.initCart());
        List<Persoana> persoane = (List<Persoana>)persoanaRepository.saveAll(mockDataRepo.initPersoane(produses,cartList));
        echipamentProtectieRepository.saveAll(mockDataRepo.initEchipament());

        LoginControllerGui loginController = new LoginControllerGui(persoanaService, produsService,cartService);
    }
}
