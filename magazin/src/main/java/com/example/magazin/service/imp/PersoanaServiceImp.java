package com.example.magazin.service.imp;

import com.example.magazin.constants.Rol;
import com.example.magazin.dto.AuthDTO;
import com.example.magazin.dto.UpdatePersoanaRolDTO;
import com.example.magazin.model.Cart;
import com.example.magazin.model.Persoana;
import com.example.magazin.model.Produs;
import com.example.magazin.repository.PersoanaRepository;
import com.example.magazin.service.CartService;
import com.example.magazin.service.PersoanaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.LinkedList;
import java.util.List;

@Service
public class PersoanaServiceImp implements PersoanaService {

    @Autowired
    private final PersoanaRepository persoanaRepository;
    private final CartService cartService;



    public PersoanaServiceImp(PersoanaRepository persoanaRepository, CartService cartService) {
        this.persoanaRepository = persoanaRepository;
        this.cartService = cartService;
    }


    @Override
    @Transactional
    public Persoana updateRolPersoana(UpdatePersoanaRolDTO persoana) {
        Persoana persoanaDb = persoanaRepository.findById(persoana.getId()).get();
        persoanaDb.setRol(persoana.getRol());
        return persoanaDb;
    }

    @Override
    public Persoana findFirstByNameAndPassword(AuthDTO dto) {
        return persoanaRepository.findByNumeAndParola(dto.getNume(), dto.getParola());
    }

    @Override
    public List<Persoana> findAll() {
        List<Persoana> persoanaList = (List<Persoana>)persoanaRepository.findAll();
        return persoanaList;
    }

    @Override
    public Persoana deletePersoana(Long id) {
        Persoana persoana = persoanaRepository.findById(id).get();
        persoanaRepository.delete(persoana);
        return persoana;
    }

    @Override
    public Persoana save(AuthDTO p) {
        Persoana persoana = new Persoana();
        persoana.setParola(p.getParola());
        persoana.setNume(p.getNume());
        Cart cart = new Cart();
        cart.setTotal(0);
        List<Produs> produses1 = new LinkedList<>();
        cart.setProduse(produses1);
        cartService.save(cart);
        persoana.setCart(cart);
        persoana.setRol(Rol.USER);
        return persoanaRepository.save(persoana);
    }

    @Override
    public Persoana save(Persoana persoana) {
        return persoanaRepository.save(persoana);
    }

    @Override
    public Persoana findByNume(String nume) {
        return persoanaRepository.findByNume(nume);
    }
}
