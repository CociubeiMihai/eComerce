package com.example.magazin.service.imp;

import com.example.magazin.model.subProduse.Miere;
import com.example.magazin.repository.MiereRepository;
import com.example.magazin.service.MiereService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MiereServiceImp implements MiereService {

    private final MiereRepository miereRepository;

    public MiereServiceImp(MiereRepository miereRepository) {
        this.miereRepository = miereRepository;
    }

    @Override
    public Miere findByCantitate(int cantitate) {
        return miereRepository.findByCantitate(cantitate);
    }

    @Override
    public Miere findByLot(int lot) {
        return miereRepository.findByLot(lot);
    }

    @Override
    public List<Miere> findAll() {
        List<Miere> miereList = (List<Miere>)miereRepository.findAll();
        return miereList;
    }

    @Override
    public Miere deleteMiere(Long id) {
        Miere miere = miereRepository.findById(id).get();
        miereRepository.delete(miere);
        return miere;
    }

    @Override
    public Miere save(Miere miere) {
        return miereRepository.save(miere);
    }
}
