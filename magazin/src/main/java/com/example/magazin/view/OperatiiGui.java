package com.example.magazin.view;

import java.awt.*;
import java.awt.event.ActionListener;

import javax.swing.*;

public class OperatiiGui extends Component {

    private JFrame frame;
    private JButton findAllUsersBtn;
    private JTextField idPersoana;
    private JComboBox comboBox;
    private JButton updatePersoanaBtn;
    private JButton deleteBtn;
    private JTextField numeTf;
    private JButton searchBtn;
    private JTextField cantitateTf;
    private JButton updateCantitate;
    private JButton deleteProduct;
    private JButton findAllProducts;
    private JTextField idCart;
    private JTextField idPersoanei;
    private JButton addCart;
    private JButton findAllCartProducts;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    OperatiiGui window = new OperatiiGui();
                    window.frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the application.
     */
    public OperatiiGui() {
        initialize();
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
        frame = new JFrame();
        frame.setBounds(100, 100, 740, 483);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);

        findAllUsersBtn = new JButton("Find all users");
        findAllUsersBtn.setBounds(38, 40, 115, 23);
        frame.getContentPane().add(findAllUsersBtn);

        JLabel lblNewLabel = new JLabel("Id");
        lblNewLabel.setBounds(38, 93, 115, 14);
        frame.getContentPane().add(lblNewLabel);

        idPersoana = new JTextField();
        idPersoana.setBounds(38, 118, 86, 20);
        frame.getContentPane().add(idPersoana);
        idPersoana.setColumns(10);

        comboBox = new JComboBox();
        comboBox.setModel(new DefaultComboBoxModel(new String[] {"ADMIN", "USER"}));
        comboBox.setBounds(149, 118, 74, 22);
        frame.getContentPane().add(comboBox);

        updatePersoanaBtn = new JButton("UpdatePersoana");
        updatePersoanaBtn.setBounds(262, 117, 115, 23);
        frame.getContentPane().add(updatePersoanaBtn);

        deleteBtn = new JButton("Delete");
        deleteBtn.setBounds(387, 117, 89, 23);
        frame.getContentPane().add(deleteBtn);

        JLabel lblNewLabel_1 = new JLabel("Nume");
        lblNewLabel_1.setBounds(38, 149, 46, 14);
        frame.getContentPane().add(lblNewLabel_1);

        numeTf = new JTextField();
        numeTf.setBounds(38, 174, 86, 20);
        frame.getContentPane().add(numeTf);
        numeTf.setColumns(10);

        searchBtn = new JButton("Search");
        searchBtn.setBounds(134, 173, 89, 23);
        frame.getContentPane().add(searchBtn);

        findAllProducts = new JButton("Find all products");
        findAllProducts.setBounds(178, 40, 134, 23);
        frame.getContentPane().add(findAllProducts);

        deleteProduct = new JButton("Delete product");
        deleteProduct.setBounds(486, 117, 146, 23);
        frame.getContentPane().add(deleteProduct);

        JLabel lblNewLabel_2 = new JLabel("Cantitate");
        lblNewLabel_2.setBounds(38, 205, 200, 14);
        frame.getContentPane().add(lblNewLabel_2);

        cantitateTf = new JTextField();
        cantitateTf.setBounds(38, 230, 86, 20);
        frame.getContentPane().add(cantitateTf);
        cantitateTf.setColumns(10);

        updateCantitate = new JButton("Update cantitate");
        updateCantitate.setBounds(134, 229, 146, 23);
        frame.getContentPane().add(updateCantitate);

        JLabel lblNewLabel_3 = new JLabel("Id produs");
        lblNewLabel_3.setBounds(38, 275, 86, 14);
        frame.getContentPane().add(lblNewLabel_3);

        JLabel lblNewLabel_4 = new JLabel("Id persoana");
        lblNewLabel_4.setBounds(134, 275, 115, 14);
        frame.getContentPane().add(lblNewLabel_4);

        idCart = new JTextField();
        idCart.setBounds(38, 300, 86, 20);
        frame.getContentPane().add(idCart);
        idCart.setColumns(10);

        idPersoanei = new JTextField();
        idPersoanei.setBounds(134, 300, 86, 20);
        frame.getContentPane().add(idPersoanei);
        idPersoanei.setColumns(10);

        addCart = new JButton("Add to cart");
        addCart.setBounds(230, 300, 134, 23);
        frame.getContentPane().add(addCart);

        findAllCartProducts = new JButton("Find your order ");
        findAllCartProducts.setBounds(387, 299, 214, 23);
        frame.getContentPane().add(findAllCartProducts);
    }

    public void setVizibil(Boolean l){
        frame.setVisible(l);
    }

    public void findAllUsersBtn(ActionListener a){
        findAllUsersBtn.addActionListener(a);
    }
    public void updatePersoana(ActionListener a){
        updatePersoanaBtn.addActionListener(a);
    }
    public String getRolComboBox(){return String.valueOf(comboBox.getSelectedItem());}
    public Long getIdPersoana(){return Long.parseLong(idPersoana.getText());}
    public void deletePersoana(ActionListener a){deleteBtn.addActionListener(a);}
    public String getNumeTf(){return numeTf.getText();}
    public void searchBtn(ActionListener a){searchBtn.addActionListener(a);}
    public void findAllProducts(ActionListener a){
        findAllProducts.addActionListener(a);
    }
    public void deleteProduct(ActionListener a){deleteProduct.addActionListener(a);}
    public void updateCantitate(ActionListener a){updateCantitate.addActionListener(a);}
    public int getCantitate(){return Integer.valueOf(cantitateTf.getText());}
    public Long getIdProdus(){return Long.valueOf(idCart.getText());}
    public Long getIdPersoaneiPtCart(){return Long.valueOf(idPersoanei.getText());}
    public void addProdusCart(ActionListener a){addCart.addActionListener(a);}
    public void findAllCartProducts(ActionListener a){findAllCartProducts.addActionListener(a);}

}

