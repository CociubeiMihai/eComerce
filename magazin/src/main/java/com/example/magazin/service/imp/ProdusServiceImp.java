package com.example.magazin.service.imp;

import com.example.magazin.dto.UpdateProdusStocDTO;
import com.example.magazin.model.Persoana;
import com.example.magazin.model.Produs;
import com.example.magazin.repository.ProdusRepository;
import com.example.magazin.service.ProdusService;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class ProdusServiceImp implements ProdusService {

    private final ProdusRepository produsRepository;

    public ProdusServiceImp(ProdusRepository produsRepository) {
        this.produsRepository = produsRepository;
    }

    @Override
    public Produs findByNume(String nume) {
        return produsRepository.findByNume(nume);
    }

    @Override
    @Transactional
    public Produs updateStoc(UpdateProdusStocDTO produs) {
        Produs produsDb = produsRepository.findById(produs.getId()).get();
        produsDb.setCantitate(produsDb.getCantitate() + produs.getCantitate());
        return produsDb;
    }

    @Override
    public List<Produs> findAll() {
        List<Produs> produsList=(List<Produs>)produsRepository.findAll();
        return produsList;
    }

    @Override
    public List<Produs> findByPriceBetwin(int low, int high) {
        return produsRepository.findByPretIsBetween(low,high);
    }

    @Override
    public Produs deleteProduct(Long id) {
        Produs echipamentProtectie = produsRepository.findById(id).get();
        produsRepository.delete(echipamentProtectie);
        return echipamentProtectie;
    }

    @Override
    public Produs save(Produs produs) {
        return produsRepository.save(produs);
    }

    @Override
    public Produs findById(Long id) {
        return produsRepository.findById(id).get();
    }

}
