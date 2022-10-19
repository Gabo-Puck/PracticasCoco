/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Vistas;

import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JFrame;

/**
 *
 * @author divah_000
 */
public class VistaPrincipal extends JFrame {
    private JButton boton1 = new JButton("Boton 1");
    private JButton boton2 = new JButton("Boton 2");
    private JButton boton3 = new JButton("Boton 3");
    private JButton boton4 = new JButton("Boton 4");
    public VistaPrincipal() {
        super("dD de ventana");
        init();
    }

    void init() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        GroupLayout orden = new GroupLayout(this.getContentPane());
        
        orden.setHorizontalGroup
            (
                    orden.createSequentialGroup()
                         .addComponent(boton1)
                         .addComponent(boton2)
                         .addComponent(boton3)
                         .addComponent(boton4)
            );
        orden.setVerticalGroup
            (
                    orden.createSequentialGroup()
                        .addGroup
                            (
                                    orden.createParallelGroup()
                                        .addComponent(boton1)
                                        .addComponent(boton3)
                            )
                        .addComponent(boton2)
                        .addComponent(boton4)
            );
        
        setLayout(orden);
        this.pack();
    }

}
