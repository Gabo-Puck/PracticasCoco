/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Vistas;

import java.awt.Graphics;
import java.awt.HeadlessException;
import javax.swing.JFrame;
import Clases.Cubo;
import Clases.Matriz;

/**
 *
 * @author divah_000
 */
public class VistaPrincipal extends JFrame {

    private Cubo cubo;

    public VistaPrincipal() throws HeadlessException {
        super("Cubo 3d");
        init();
    }

    public void init() {
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLayout(null);
        this.setSize(1920, 600);
        Matriz[] matrices = new Matriz[16];
        cubo = new Cubo();
        System.out.println();
    }    

    @Override
    public void paint(Graphics g) {
        super.paint(g); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
        cubo.dibujarCubo(g);
    }

}
