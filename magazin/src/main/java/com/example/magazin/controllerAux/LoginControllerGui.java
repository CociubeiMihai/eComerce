package com.example.magazin.controllerAux;

import com.example.magazin.constants.Rol;
import com.example.magazin.dto.AuthDTO;
import com.example.magazin.dto.UpdatePersoanaRolDTO;
import com.example.magazin.dto.UpdateProdusStocDTO;
import com.example.magazin.model.Cart;
import com.example.magazin.model.Persoana;
import com.example.magazin.model.Produs;
import com.example.magazin.service.CartService;
import com.example.magazin.service.PersoanaService;
import com.example.magazin.service.ProdusService;
import com.example.magazin.view.LoginView;
import com.example.magazin.view.OperatiiGui;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;
import java.util.List;

public class LoginControllerGui {

    private  LoginView loginView;
    private OperatiiGui operatiiGui;
    private final PersoanaService persoanaService;
    private final ProdusService produsService;
    private final CartService cartService;

    public LoginControllerGui(PersoanaService persoanaService, ProdusService produsService, CartService cartService) {
        this.persoanaService = persoanaService;
        this.produsService = produsService;
        this.cartService = cartService;
        this.loginView = new LoginView();
        this.operatiiGui = new OperatiiGui();

        loginView.logInActionlistener(new Logare());
        loginView.registerActionListener(new Register());
        operatiiGui.findAllUsersBtn(new FindUsers());
        operatiiGui.updatePersoana(new ChangeRole());
        operatiiGui.deletePersoana(new StergePers());
        operatiiGui.searchBtn(new SearchPersoana());
        operatiiGui.findAllProducts(new PrintProducts());
        operatiiGui.deleteProduct(new DeleteProdus());
        operatiiGui.updateCantitate(new UpdateCantitate());
        operatiiGui.addProdusCart(new AddProduct());
        operatiiGui.findAllCartProducts(new CartProducts());
    }

    class Logare implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            AuthDTO authDTO = new AuthDTO();
            authDTO.setNume(loginView.getNume());
            authDTO.setParola(loginView.genPassword());
            Persoana persoana = persoanaService.findFirstByNameAndPassword(authDTO);
            try {
                persoana.getNume();
                operatiiGui.setVizibil(true);

            }
            catch(NullPointerException eroare){
                JOptionPane.showMessageDialog(loginView, "Date incorecte");
            }

        }
    }

    class Register implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            Persoana persoana = new Persoana();
            persoana.setNume(loginView.getNume());
            persoana.setParola(loginView.genPassword());
            persoana.setRol(Rol.USER);
            Cart cart = new Cart();
            cart.setTotal(0);
            List<Produs> produses = new LinkedList<>();
            cart.setProduse(produses);
            cartService.save(cart);

            persoana.setCart(cart);
            persoanaService.save(persoana);
            JOptionPane.showMessageDialog(loginView, "Cont creat cu succes");
        }
    }

    class FindUsers implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            JFrame jFrame = new JFrame();
            String []column = {"id","Email","Nume", "Parola","Rol","Prenume"};

            List<Persoana> meniu =  persoanaService.findAll();
            String [][] data = new String[meniu.size()][7];
            int i = 0;
            for(Persoana m: meniu){
                data[i][0] = String.valueOf(m.getId());
                data[i][1] = m.getEmail();
                data[i][2] = m.getNume();
                data[i][3] = m.getParola();
                if(m.getRol() == Rol.USER)
                    data[i++][4] = "USER";
                else
                    data[i++][4] = "ADMIN";
            }
            JTable jt=new JTable(data,column);
            JScrollPane sp=new JScrollPane(jt);
            jt.setBounds(30,40,1000,600);
            jFrame.add(sp);
            jFrame.setSize(1000,600);
            jFrame.setVisible(true);
        }
    }

    class ChangeRole implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            Long id = operatiiGui.getIdPersoana();
            String rol = operatiiGui.getRolComboBox();
            UpdatePersoanaRolDTO updatePersoanaRolDTO =new UpdatePersoanaRolDTO();
            updatePersoanaRolDTO.setId(id);
            if(rol.equals("ADMIN")){
                updatePersoanaRolDTO.setRol(Rol.ADMIN);
            }
            else{
                updatePersoanaRolDTO.setRol(Rol.USER);
            }
            persoanaService.updateRolPersoana(updatePersoanaRolDTO);
        }
    }

    class StergePers implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            Long id = operatiiGui.getIdPersoana();
            persoanaService.deletePersoana(id);
        }
    }

    class SearchPersoana implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            String nume = operatiiGui.getNumeTf();
            System.out.println(nume);
            Persoana persoana = persoanaService.findByNume(nume);
            JOptionPane.showMessageDialog(loginView, persoana.toString());
        }
    }

    class PrintProducts implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            JFrame jFrame = new JFrame();
            String []column = {"id","Cantitate","Descriere", "Nume","Pret","Recenzie"};

            List<Produs> meniu =  produsService.findAll();
            String [][] data = new String[meniu.size()][7];
            int i = 0;
            for(Produs m: meniu){
                data[i][0] = String.valueOf(m.getId());
                data[i][1] = String.valueOf(m.getCantitate());
                data[i][2] = m.getDescriere();
                data[i][3] = m.getNume();
                data[i++][4] = String.valueOf(m.getRecenzie());
            }
            JTable jt=new JTable(data,column);
            JScrollPane sp=new JScrollPane(jt);
            jt.setBounds(30,40,1000,600);
            jFrame.add(sp);
            jFrame.setSize(1000,600);
            jFrame.setVisible(true);
        }
    }

    class DeleteProdus implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            Long id = operatiiGui.getIdPersoana();
            produsService.deleteProduct(id);
        }
    }

    class UpdateCantitate implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            UpdateProdusStocDTO updateProdusStocDTO = new UpdateProdusStocDTO();
            updateProdusStocDTO.setCantitate(operatiiGui.getCantitate());
            updateProdusStocDTO.setId(operatiiGui.getIdPersoana());
            produsService.updateStoc(updateProdusStocDTO);
        }
    }

    class AddProduct implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            Long idPers = operatiiGui.getIdPersoaneiPtCart();
            Long idProdus = operatiiGui.getIdProdus();

            Produs produs = produsService.findById(idProdus);
            cartService.addToCart(produs,idPers);

        }
    }

    class CartProducts implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            JFrame jFrame = new JFrame();
            String []column = {"Nume","Pret","Recenzie"};

            Long id = operatiiGui.getIdPersoaneiPtCart();
            List<Produs> meniu =  cartService.findAllProducts(id);
            String [][] data = new String[meniu.size()][7];
            int i = 0;
            for(Produs m: meniu){
                data[i][0] = m.getNume();
                data[i][1] = String.valueOf(m.getPret());
                data[i++][2] = String.valueOf(m.getRecenzie());
            }
            JTable jt=new JTable(data,column);
            JScrollPane sp=new JScrollPane(jt);
            jt.setBounds(30,40,300,600);
            jFrame.add(sp);
            jFrame.setSize(1000,600);
            jFrame.setVisible(true);
        }
    }
}
