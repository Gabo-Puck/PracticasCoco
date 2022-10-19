/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package cubocontrol3d;

import Clases.Matriz;
import Vistas.VistaPrincipal;

/**
 *
 * @author divah_000
 */
public class CuboControl3d {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        int m1[][] = {
            {1, 2, 3, 4},
            {5, 6, 7, 8},
            {9, 10, 11, 12},
            {13, 14, 15, 16}
        };
        int m2[][] = {
            {1, 0, 0, 0},
            {0, 1, 0, 0},
            {0, 0, 1, 0},
            {0, 0, 0, 1}
        };
        Matriz matriz1 = new Matriz(m1);
        Matriz matriz2 = new Matriz(m2);
        matriz1.sumarMatriz(matriz2);

        new VistaPrincipal().setVisible(true);
    }
    
    public static int[][] createArray(int x,int z,int y){
        int m[][] = {
            {1, 0, 0, y},
            {0, 1, 0, x},
            {0, 0, 1, z},
            {0, 0, 0, 1}
        };
        return m;
    }

}
