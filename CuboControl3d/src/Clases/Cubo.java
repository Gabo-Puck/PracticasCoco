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

    Matriz[] matricesBase;
    Matriz matrizDesplazamiento;
    Matriz matrizEstado;
    double[][] coordenadas;
    double angulo;
    int x, y, z;
    double zoom;
    Graphics g;

    public void setG(Graphics g) {
        this.g = g;
    }

    public Cubo() {
        matricesBase = new Matriz[16];
        angulo = 60;

        x = 300;
        y = 300;
        z = 60;
        zoom = 1;

        matrizDesplazamiento = new Matriz();
        matrizEstado = new Matriz();

        setMatricesBase();
        matrizEstado.setMatriz(createArray(x, y, z));//Inicializamos la matriz de estado unicamente con una matriz de desplazamiento;
        System.out.println();
    }

    public void moverPosX() {
        Matriz despX = new Matriz();
        despX.setMatriz(createArray(10, 0, 0));
        despX = despX.multiplicarMatriz(matrizEstado);
        matrizEstado = (despX);
    }

    public void moverPosY() {
        Matriz despY = new Matriz();
        despY.setMatriz(createArray(0, 10, 0));
        despY = despY.multiplicarMatriz(matrizEstado);
        matrizEstado = (despY);
    }

    public void moverPosZ() {
        Matriz despZ = new Matriz();
        despZ.setMatriz(createArray(0, 0, 10));
        despZ = despZ.multiplicarMatriz(matrizEstado);
        matrizEstado = (despZ);
    }

    public void moverNegX() {
        Matriz despX = new Matriz();
        despX.setMatriz(createArray(-10, 0, 0));
        despX = despX.multiplicarMatriz(matrizEstado);
        matrizEstado = (despX);
    }

    public void moverNegY() {
        Matriz despY = new Matriz();
        despY.setMatriz(createArray(0, -10, 0));
        despY = despY.multiplicarMatriz(matrizEstado);
        matrizEstado = (despY);
    }

    public void moverNegZ() {
        Matriz despZ = new Matriz();
        despZ.setMatriz(createArray(0, 0, -10));
        despZ = despZ.multiplicarMatriz(matrizEstado);
        matrizEstado = (despZ);
    }

    public void rotarPosX() {
        Matriz rotX = setMatrizRotacionPosX();
        matrizEstado = matrizEstado.multiplicarMatriz(rotX);
    }

    public void rotarPosY() {
        Matriz rotY = setMatrizRotacionPosY();
        matrizEstado = matrizEstado.multiplicarMatriz(rotY);
    }

    public void rotarPosZ() {
        Matriz rotZ = setMatrizRotacionPosZ();
        matrizEstado = matrizEstado.multiplicarMatriz(rotZ);
    }

    public void rotarNegX() {
        Matriz rotX = setMatrizRotacionNegX();
        matrizEstado = matrizEstado.multiplicarMatriz(rotX);
    }

    public void rotarNegY() {
        Matriz rotY = setMatrizRotacionNegY();
        matrizEstado = matrizEstado.multiplicarMatriz(rotY);
    }

    public void rotarNegZ() {
        Matriz rotZ = setMatrizRotacionNegZ();
        matrizEstado = matrizEstado.multiplicarMatriz(rotZ);
    }

    public void escalarPos() {
        System.out.println("ZOOM: " + zoom);

        Matriz es = setMatrizEscalarPos();
        matrizEstado = matrizEstado.multiplicarMatriz(es);
    }

    public void escalarNeg() {
        System.out.println("ZOOM: " + zoom);

        if (zoom > 0.5) {
            Matriz es = setMatrizEscalarNeg();
            matrizEstado = matrizEstado.multiplicarMatriz(es);
        }

    }

    public Matriz setMatrizEscalarPos() {
        if (zoom < 1.06) {
            zoom *= 1.06;
        } else {
            zoom /= 1.06;
        }
        double[][] matrizEscalar = new double[][]{
            {zoom * 1.1, 0, 0, 0},
            {0, zoom * 1.1, 0, 0},
            {0, 0, zoom * 1.1, 0},
            {0, 0, 0, 1}
        };
        return new Matriz(matrizEscalar);
    }

    public Matriz setMatrizEscalarNeg() {
        if (zoom <= 0.9) {
            zoom /= 0.9;
        } else {
            zoom *= 0.9;
        }
        double[][] matrizEscalar = new double[][]{
            {zoom * 0.9, 0, 0, 0},
            {0, zoom * 0.9, 0, 0},
            {0, 0, zoom * 0.9, 0},
            {0, 0, 0, 1}
        };
        return new Matriz(matrizEscalar);
    }

    public Matriz setMatrizRotacionPosX() {
        double a = Math.toRadians(20);
        double[][] matrizRot = new double[][]{
            {1, 0, 0, 0},
            {0, Math.cos(a), -Math.sin(a), 0},
            {0, Math.sin(a), Math.cos(a), 0},
            {0, 0, 0, 1}
        };
        Matriz matrizRotX = new Matriz(matrizRot);
        matrizRotX.imprimirMatriz();
        return matrizRotX;
    }

    public Matriz setMatrizRotacionPosY() {
        double b = Math.toRadians(20);
        double[][] matrizRot = new double[][]{
            {Math.cos(b), 0, Math.sin(b), 0},
            {0, 1, 0, 0},
            {-Math.sin(b), 0, Math.cos(b), 0},
            {0, 0, 0, 1}
        };
        Matriz matrizRotY = new Matriz(matrizRot);
        return matrizRotY;
    }

    public Matriz setMatrizRotacionPosZ() {
        double t = Math.toRadians(20);
        double[][] matrizRot = new double[][]{
            {Math.cos(t), -Math.sin(t), 0, 0},
            {Math.sin(t), Math.cos(t), 0, 0},
            {0, 0, 1, 0},
            {0, 0, 0, 1}
        };
        return new Matriz(matrizRot);
    }

    public Matriz setMatrizRotacionNegX() {
        double a = Math.toRadians(20);
        double[][] matrizRot = new double[][]{
            {1, 0, 0, 0},
            {0, Math.cos(-a), -Math.sin(-a), 0},
            {0, Math.sin(-a), Math.cos(-a), 0},
            {0, 0, 0, 1}
        };
        Matriz matrizRotX = new Matriz(matrizRot);
        matrizRotX.imprimirMatriz();
        return matrizRotX;
    }

    public Matriz setMatrizRotacionNegY() {
        double b = Math.toRadians(20);
        double[][] matrizRot = new double[][]{
            {Math.cos(-b), 0, Math.sin(-b), 0},
            {0, 1, 0, 0},
            {-Math.sin(-b), 0, Math.cos(-b), 0},
            {0, 0, 0, 1}
        };
        Matriz matrizRotY = new Matriz(matrizRot);
        return matrizRotY;
    }

    public Matriz setMatrizRotacionNegZ() {
        double t = Math.toRadians(20);
        double[][] matrizRot = new double[][]{
            {Math.cos(-t), -Math.sin(-t), 0, 0},
            {Math.sin(-t), Math.cos(-t), 0, 0},
            {0, 0, 1, 0},
            {0, 0, 0, 1}
        };
        return new Matriz(matrizRot);
    }

    public void setMatricesBase() {
        for (int i = 0; i < matricesBase.length; i++) {
            matricesBase[i] = new Matriz();
        }
        matricesBase[0].setMatriz(createArray(0, 0, 0));
        matricesBase[1].setMatriz(createArray(0, 100, 0));

        matricesBase[2].setMatriz(createArray(100, 0, 0));

        matricesBase[3].setMatriz(createArray(0, -100, 0));

        matricesBase[4].setMatriz(createArray(-100, 0, 0));
        matricesBase[5].setMatriz(createArray(0, 0, 100));
        matricesBase[6].setMatriz(createArray(100, 0, 0));
        matricesBase[7].setMatriz(createArray(0, 0, -100));
        matricesBase[8].setMatriz(createArray(0, 100, 0));
        matricesBase[9].setMatriz(createArray(0, 0, 100));
        matricesBase[10].setMatriz(createArray(0, -100, 0));
        matricesBase[11].setMatriz(createArray(-100, 0, 0));
        matricesBase[12].setMatriz(createArray(0, 100, 0));
        matricesBase[13].setMatriz(createArray(100, 0, 0));
        matricesBase[14].setMatriz(createArray(-100, 0, 0));
        matricesBase[15].setMatriz(createArray(0, 0, -100));
    }

    public Matriz getMatrizEstado() {
        Matriz resultado = new Matriz();
        resultado = resultado.multiplicarMatriz(matrizDesplazamiento);
        return resultado;
    }

    public double[][] createArray(int x, int y, int z) {
        double m[][] = {
            {1, 0, 0, x},
            {0, 1, 0, y},
            {0, 0, 1, z},
            {0, 0, 0, 1}
        };
        return m;
    }

    public void dibujarCubo() {
        setMatricesBase();

        for (int i = 0; i < matricesBase.length - 1; i++) {
            if (i == 0) {
                matricesBase[0] = matricesBase[0].multiplicarMatriz(matrizEstado);
            }
            double xMatrizActual = matricesBase[i].matriz[0][3];
            double yMatrizActual = matricesBase[i].matriz[1][3];
            double zMatrizActual = matricesBase[i].matriz[2][3];

            int x1 = getX(xMatrizActual, zMatrizActual);
            int y1 = getY(yMatrizActual, zMatrizActual);
            matricesBase[i + 1] = matricesBase[i].multiplicarMatriz(matricesBase[i + 1]);

            double xMatrizNext = matricesBase[i + 1].matriz[0][3];
            double yMatrizNext = matricesBase[i + 1].matriz[1][3];
            double zMatrizNext = matricesBase[i + 1].matriz[2][3];

            int x2 = getX(xMatrizNext, zMatrizNext);
            int y2 = getY(yMatrizNext, zMatrizNext);

            g.drawLine(x1, y1, x2, y2);

        }

    }

    public int getY(double y, double z) {
        double a = Math.toRadians(angulo);
        int yd = (int) (y - z * Math.sin(a));
        return yd;
    }

    public int getX(double x, double z) {
        double a = Math.toRadians(angulo);
        int xd = (int) (x - z * Math.cos(a));
        return xd;
    }

}
