package com.example.magazin.service.imp;

import com.example.magazin.dto.AddCartDto;
import com.example.magazin.dto.UpdateProdusStocDTO;
import com.example.magazin.model.Cart;
import com.example.magazin.model.Persoana;
import com.example.magazin.model.Produs;
import com.example.magazin.repository.CartRepository;
import com.example.magazin.repository.PersoanaRepository;
import com.example.magazin.service.CartService;
import com.example.magazin.service.ProdusService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartServiceImp implements CartService {

    private final CartRepository cartRepository;
    private final PersoanaRepository persoanaRepository;
    private final ProdusService produsService;

    public CartServiceImp(CartRepository cartRepository, PersoanaRepository persoanaRepository, ProdusService produsService) {
        this.cartRepository = cartRepository;
        this.persoanaRepository = persoanaRepository;
        this.produsService = produsService;
    }

    @Override
    public Cart addToCart(Produs produs, Long idPersoana) {
        Persoana persoana = persoanaRepository.findById(idPersoana).get();
        Cart cart =  persoana.getCart();
        cart.getProduse().add(produs);

        cart.setTotal(cart.getTotal() + produs.getPret());
        cartRepository.save(cart);
        UpdateProdusStocDTO updateProdusStocDTO = new UpdateProdusStocDTO();
        updateProdusStocDTO.setId(produs.getId());
        updateProdusStocDTO.setCantitate(-1);
        produsService.updateStoc(updateProdusStocDTO);
        return persoana.getCart();
    }

    @Override
    public Cart save(Cart cart) {
        return cartRepository.save(cart);
    }

    @Override
    public List<Produs> findAllProducts(Long idPersoana) {
        Persoana persoana = persoanaRepository.findById(idPersoana).get();
        return persoana.getCart().getProduse();
    }

    @Override
    public Cart addToCart(AddCartDto addCartDto) {
        Long idPersoana = addCartDto.getIdPers();
        Produs produs = produsService.findById(addCartDto.getIdProdus());
        Persoana persoana = persoanaRepository.findById(idPersoana).get();
        Cart cart =  persoana.getCart();
        cart.getProduse().add(produs);

        cart.setTotal(cart.getTotal() + produs.getPret());
        cartRepository.save(cart);

        return persoana.getCart();
    }

    @Override
    public Cart emptyCart(Long idPersoana) {
        Cart cart = persoanaRepository.findById(idPersoana).get().getCart();
        cart.setTotal(0);
        cart.getProduse().clear();
        cartRepository.save(cart);
        return null;
    }

    @Override
    public int total(Long idPersoana) {
        return persoanaRepository.findById(idPersoana).get().getCart().getTotal();
    }

}
