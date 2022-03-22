package com.example.magazin.utils.initialization;

import com.example.magazin.constants.Marime;
import com.example.magazin.model.Cart;
import com.example.magazin.model.Persoana;
import com.example.magazin.model.Produs;
import com.example.magazin.constants.Rol;
import com.example.magazin.model.subProduse.EchipamentProtectie;
import org.springframework.stereotype.Component;

import java.util.LinkedList;
import java.util.List;

@Component
public class MockDataRepo {

    private static final Long noOfEntities = 4L;

    public List<Persoana> initPersoane(List<Produs> produsList, List<Cart> cartList) {
        Long i;
        int k = 0;
        List<Persoana> persoane = new LinkedList<>();
        for ( i = 1L; i < noOfEntities; i++) {
            List<Produs> produses = new LinkedList<>();
            produses.add(produsList.get(k));
            produses.add(produsList.get(k + 4));
            persoane.add(Persoana.builder().nume("Nume_" + i).parola("pass").prenume("Prenume_" + i).rol(Rol.USER).email("email_" + i).produsListl(produses).cart(cartList.get(k)).build());
            k++;
        }
        persoane.add(Persoana.builder().nume("Admin").parola("pass").prenume("Prenume_Admin").rol(Rol.ADMIN).email("email_Admin").build());
        return persoane;
    }

    public List<Cart> initCart(){
        List<Cart> cartList = new LinkedList<>();
        List<Produs> produses = new LinkedList<>();
        for(Long i = 0L; i < noOfEntities; i++){
            cartList.add(Cart.builder().total(0).produse(produses).build());
        }
        return cartList;
    }

    public List<Produs> initProduse(){
        List<Produs> produses = new LinkedList<>();

        for(Long i = 0L; i < noOfEntities * 2; i++){
            produses.add(Produs.builder().nume("Produs_"+ i).pret((int)((i + 1) * 20) %200).cantitate(20).build());
        }

        return  produses;
    }

    public List<EchipamentProtectie> initEchipament(){
        List<EchipamentProtectie> echipamentProtectieList = new LinkedList<>();

        for(Long i = 0L; i < noOfEntities * 2; i++){
            EchipamentProtectie e = new EchipamentProtectie();
            e.setCuloare("Culoare_" + i);
            e.setMarime(Marime.M);
            e.setCantitate(15);
            e.setMaterial("Material_"+i);
            e.setNivelProtectie(3);
            e.setNume("Nume" +i);
            echipamentProtectieList.add(e);
        }

        return echipamentProtectieList;
    }

}
