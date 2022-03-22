package com.example.magazin.service.imp;

import com.example.magazin.model.subProduse.EchipamentProtectie;
import com.example.magazin.constants.Marime;
import com.example.magazin.repository.EchipamentProtectieRepository;
import com.example.magazin.service.EchipamentProtectieService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EchipamentProtectieImp implements EchipamentProtectieService {
    
    private final EchipamentProtectieRepository echipamentProtectieRepository;

    public EchipamentProtectieImp(EchipamentProtectieRepository echipamentProtectieRepository) {
        this.echipamentProtectieRepository = echipamentProtectieRepository;
    }

    @Override
    public List<EchipamentProtectie> findByMaterial(String material) {
        List<EchipamentProtectie> echipamentProtectieList=(List<EchipamentProtectie>)echipamentProtectieRepository.findByMaterial(material);
        return echipamentProtectieList;
    }

    @Override
    public List<EchipamentProtectie> findByNivelProtectie(int nivel) {
        List<EchipamentProtectie> echipamentProtectieList=(List<EchipamentProtectie>)echipamentProtectieRepository.findByNivelProtectieGreaterThanEqual(nivel);
        return echipamentProtectieList;
    }

    @Override
    public List<EchipamentProtectie> findByMarime(Marime marime) {
        return echipamentProtectieRepository.findByMarime(marime);
    }

    @Override
    public List<EchipamentProtectie> findByCuloare(String culoare) {
        return echipamentProtectieRepository.findByCuloare(culoare);
    }

    @Override
    public List<EchipamentProtectie> findAll() {
        List<EchipamentProtectie> echipamentProtectieList=(List<EchipamentProtectie>)echipamentProtectieRepository.findAll();
        return echipamentProtectieList;
    }

    @Override
    public EchipamentProtectie deleteEchipament(Long id) {
        EchipamentProtectie echipamentProtectie = echipamentProtectieRepository.findById(id).get();
        echipamentProtectieRepository.delete(echipamentProtectie);
        return echipamentProtectie;
    }

    @Override
    public EchipamentProtectie save(EchipamentProtectie echipamentProtectie) {
        return echipamentProtectieRepository.save(echipamentProtectie);
    }
}
