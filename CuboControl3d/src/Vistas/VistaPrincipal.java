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
        for (int i = 0; i < matrices.length; i++) {
            matrices[i] = new Matriz();
        }
        matrices[0].setMatriz(createArray(0, 0, 0));
        matrices[1].setMatriz(createArray(0, 100, 0));
        matrices[2].setMatriz(createArray(100, 0, 0));
        matrices[3].setMatriz(createArray(0, -100, 0));
        
        matrices[4].setMatriz(createArray(-100, 0, 0));
        matrices[5].setMatriz(createArray(0, 0, 100));
        matrices[6].setMatriz(createArray(100, 0, 0));
        matrices[7].setMatriz(createArray(0, 0, -100));
        
        matrices[8].setMatriz(createArray(0, 100, 0));
        matrices[9].setMatriz(createArray(0, 0, 100));
        matrices[10].setMatriz(createArray(0, -100, 0));
        matrices[11].setMatriz(createArray(-100, 0, 0));
        
        matrices[12].setMatriz(createArray(0, 100, 0));
        matrices[13].setMatriz(createArray(100, 0, 0));
        matrices[14].setMatriz(createArray(-100, 0, 0));
        matrices[15].setMatriz(createArray(0, 0, -100));
        
        cubo = new Cubo(matrices);
    }

    public int[][] createArray(int y, int x, int z) { 
        int m[][] = {
            {1, 0, 0, y},
            {0, 1, 0, x},
            {0, 0, 1, z},
            {0, 0, 0, 1}
        };
        return m;
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
        cubo.dibujarCubo(g);

    }

}
