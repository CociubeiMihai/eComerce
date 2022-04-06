package com.example.magazin.utils.initialization;

import com.example.magazin.model.Cart;
import com.example.magazin.model.Persoana;
import com.example.magazin.model.Produs;
import com.example.magazin.repository.*;
import com.example.magazin.service.CartService;
import com.example.magazin.service.PersoanaService;
import com.example.magazin.service.ProdusService;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;

@Service
public class InitializationService {

    private final MockDataRepo mockDataRepo;
    private final PersoanaRepository persoanaRepository;
    private final ProdusRepository produsRepository;
    private final EchipamentProtectieRepository echipamentProtectieRepository;
    private final CartRepository cartRepository;
    private final CardRepository cardRepository;

    private final CartService cartService;
    private final PersoanaService persoanaService;
    private final ProdusService produsService;

    public InitializationService(MockDataRepo mockDataRepo, PersoanaRepository persoanaRepository, ProdusRepository produsRepository, EchipamentProtectieRepository echipamentProtectieRepository, CartRepository cartRepository, CardRepository cardRepository, CartService cartService, PersoanaService persoanaService, ProdusService produsService) {
        this.mockDataRepo = mockDataRepo;
        this.persoanaRepository = persoanaRepository;
        this.produsRepository = produsRepository;
        this.echipamentProtectieRepository = echipamentProtectieRepository;
        this.cartRepository = cartRepository;
        this.cardRepository = cardRepository;
        this.cartService = cartService;
        this.persoanaService = persoanaService;
        this.produsService = produsService;
    }

    @Bean
    public void initializeData(){
        List<Produs> produses = (List<Produs>) produsRepository.saveAll(mockDataRepo.initProduse());
        List<Cart> cartList = (List<Cart>) cartRepository.saveAll(mockDataRepo.initCart());
        List<Persoana> persoane = mockDataRepo.initPersoane(produses,cartList);
        echipamentProtectieRepository.saveAll(mockDataRepo.initEchipament());

        for(Persoana p: persoane){
            Cart cart = new Cart();
            cart.setTotal(0);
            List<Produs> produses1 = new LinkedList<>();
            cart.setProduse(produses1);
            cartService.save(cart);

            p.setCart(cart);

        }
        persoanaRepository.saveAll(persoane);
        cardRepository.saveAll(mockDataRepo.initCarduri());
        //LoginControllerGui loginController = new LoginControllerGui(persoanaService, produsService,cartService);
    }
}
