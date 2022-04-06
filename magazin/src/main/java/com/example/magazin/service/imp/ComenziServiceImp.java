package com.example.magazin.service.imp;

import com.example.magazin.dto.UpdateProdusStocDTO;
import com.example.magazin.model.Cart;
import com.example.magazin.model.Comanda;
import com.example.magazin.model.Persoana;
import com.example.magazin.model.Produs;
import com.example.magazin.repository.ComandaRepository;
import com.example.magazin.repository.PersoanaRepository;
import com.example.magazin.service.CartService;
import com.example.magazin.service.ComandaService;
import com.example.magazin.service.ProdusService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

@Service
public class ComenziServiceImp implements ComandaService {

    private final ComandaRepository comenziRepository;
    private final PersoanaRepository persoanaRepository;
    private final CartService cartService;
    private final ProdusService produsService;

    public ComenziServiceImp(ComandaRepository comenziRepository, PersoanaRepository persoanaRepository, CartService cartService, ProdusService produsService) {
        this.comenziRepository = comenziRepository;
        this.persoanaRepository = persoanaRepository;
        this.cartService = cartService;
        this.produsService = produsService;
    }

    @Override
    public Comanda addComanda(Long idPersoana, String achitat) {
        Persoana persoana = persoanaRepository.findById(idPersoana).get();
        Cart cart = persoana.getCart();
        Comanda comanda = new Comanda();
        comanda.setData(LocalDateTime.now());
        comanda.setIdpersoana(idPersoana);
        List<Produs> produses = new LinkedList<>();
        for(Produs p: cart.getProduse()){
            UpdateProdusStocDTO dto = new UpdateProdusStocDTO();
            dto.setId(p.getId());
            dto.setCantitate(-1);
            produsService.updateStoc(dto);
            produses.add(p);
        }
        comanda.setTotal(cart.getTotal());
        comanda.setProduse(produses);
        comanda.setAchitat(achitat);
        comenziRepository.save(comanda);
        cartService.emptyCart(idPersoana);

        return comanda;
    }

    @Override
    public List<Comanda> findPersonComanda(Long idPersoana) {
        return comenziRepository.findByIdpersoana(idPersoana);
    }

    @Override
    public List<Comanda> findComenziPrimite(Long idPersoana) {
        List<Produs> produse = persoanaRepository.findById(idPersoana).get().getProdusListl();
        List<Comanda> comenzi = new LinkedList<>();
        int ok = 0;
        for(Comanda c: findAll()){
            ok = 0;
            for(Produs p: c.getProduse()){
                for(Produs persoanaProdus: produse){
                    if(Objects.equals(p.getId(), persoanaProdus.getId()) && ok == 0) {
                        comenzi.add(c);
                        ok = 1;
                    }
                }
            }
        }
        return comenzi;
    }

    @Override
    public List<Comanda> findAll() {
        return (List<Comanda>) comenziRepository.findAll();
    }


}
