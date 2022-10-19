/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

import java.awt.Graphics;

/**
 *
 * @author divah_000
 */
public class Cubo {

    Matriz[] matrices;
    int angulo;
    int offset;
    int sda;

    public Cubo(Matriz[] _matrices) {
        matrices = _matrices;
        angulo = 150;
        offset = 450;
        sda = 0;
    }

    public void dibujarCubo(Graphics g) {
        int preX;
        int preY;
        Matriz m = matrices[0];
        preX = getX(matrices[0], 0);
        preY = getY(matrices[0], 0);

        for (int i = 1; i < matrices.length; i++) {
            int y = getY(matrices[i], preY);
            int x = getX(matrices[i], preX);
            if (sda == 0) {
                System.out.println("yprev: " + preY);
                System.out.println("xprev: " + preX);
                System.out.println("x: " + x);
                System.out.println("y: " + y);
            }

            g.drawLine(preX, preY, x, y);
            m = matrices[i];
            preX = x;
            preY = y;
        }
        sda = 1;
    }

    public int getY(Matriz m, int prevX) {
        int y = m.matriz[0][3]; //y
        int z = m.matriz[2][3]; //z
        int x = m.matriz[1][3]; //x

        
//        if (x != 0 && y == 0) {
//            return prevX;
//        }
        int yd = (int) (y - z * Math.sin(angulo));
        return yd;
    }

    public int getX(Matriz m, int prevY) {
        int x = m.matriz[1][3]; //x
        int z = m.matriz[2][3]; //z
        int y = m.matriz[0][3]; //y

       
//        if (y != 0 && x == 0) {
//            return prevY;
//        }
        int xd = (int) (x - z * Math.cos(angulo));
        return xd;
    }

}
