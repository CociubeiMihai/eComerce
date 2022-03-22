package com.example.magazin.service.imp;

import com.example.magazin.dto.AuthDTO;
import com.example.magazin.dto.UpdatePersoanaRolDTO;
import com.example.magazin.model.Persoana;
import com.example.magazin.repository.PersoanaRepository;
import com.example.magazin.service.PersoanaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class PersoanaServiceImp implements PersoanaService {

    @Autowired
    private final PersoanaRepository persoanaRepository;

    public PersoanaServiceImp(PersoanaRepository persoanaRepository) {
        this.persoanaRepository = persoanaRepository;
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
    public Persoana save(Persoana persoana) {
        return persoanaRepository.save(persoana);
    }

    @Override
    public Persoana findByNume(String nume) {
        return persoanaRepository.findByNume(nume);
    }
}
