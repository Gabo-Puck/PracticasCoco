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
    Matriz matrizEscalar;
    Matriz matrizRotacionX;
    Matriz matrizRotacionY;
    Matriz matrizRotacionZ;
    Matriz matrizEstado;
    double[][] coordenadas;
    double angulo;
    int x, y, z;
    int zoom;
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
        matrizEscalar = new Matriz();
        matrizRotacionX = new Matriz();
        matrizRotacionY = new Matriz();
        matrizRotacionZ = new Matriz();
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
        Matriz rotX = setMatrizRotacionX();
        matrizEstado = matrizEstado.multiplicarMatriz(rotX);
    }

    public void rotarPosY() {
        Matriz rotY = setMatrizRotacionY();
        matrizEstado = matrizEstado.multiplicarMatriz(rotY);
    }

    public void rotarPosZ() {
        Matriz rotZ = setMatrizRotacionZ();
        matrizEstado = matrizEstado.multiplicarMatriz(rotZ);
    }

    public void setMatrizDesplazamiento() {
        double[] modificaciones = {x, y, z};
        for (int i = 0; i < 3; i++) {
            matrizDesplazamiento.matriz[i][3] = modificaciones[i];
        }
    }

    public void setMatrizEscalar() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (i == j) {
                    matrizEscalar.matriz[i][j] = zoom;
                }
            }
        }
    }

    public Matriz setMatrizRotacionX() {
        double a = Math.toRadians(20);
        double[][] matrizRot = new double[][]{
            {1, 0, 0, 0},
            {0, Math.cos(a), -Math.sin(a), 0},
            {0, Math.sin(a), Math.cos(a), 0},
            {0, 0, 0, 1}
        };
//        double[][] matrizRot = new double[][]{
//            {1,0,0,0},
//            {0,1,1,0},
//            {0,1,1,0},
//            {0,0,0,1}
//        };
        System.out.println("MATRIZ DE ROTACION X");
        Matriz matrizRotX = new Matriz(matrizRot);
        matrizRotX.imprimirMatriz();

//        for (int i = 1; i < 3; i++) {
//            for (int j = 1; j < 3; j++) {
//                if (i == j) {
//                    matrizRotX.matriz[i][j] = Math.cos(a);
//                } else if (i == 1 && j == 2) {
//                    matrizRotX.matriz[i][j] = Math.sin(a);
//                } else {
//                    matrizRotX.matriz[i][j] = -Math.sin(a);
//                }
//            }
//        }
        return matrizRotX;
    }

    public Matriz setMatrizRotacionY() {
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

    public Matriz setMatrizRotacionZ() {
        double t = Math.toRadians(20);
        double[][] matrizRot = new double[][]{
            {Math.cos(t), -Math.sin(t), 0, 0},
            {Math.sin(t), Math.cos(t), 0, 0},
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
        System.out.println("1");
        matricesBase[0].imprimirMatriz();
        matricesBase[1].setMatriz(createArray(0, 100, 0));
        System.out.println("2");
        matricesBase[1].imprimirMatriz();

        matricesBase[2].setMatriz(createArray(100, 0, 0));
        System.out.println("3");
        matricesBase[2].imprimirMatriz();

        matricesBase[3].setMatriz(createArray(0, -100, 0));
        System.out.println("4");
        matricesBase[3].imprimirMatriz();

        matricesBase[4].setMatriz(createArray(-100, 0, 0));
        System.out.println("5");
        matricesBase[4].imprimirMatriz();
        matricesBase[5].setMatriz(createArray(0, 0, 100));
        System.out.println("6");
        matricesBase[5].imprimirMatriz();
        matricesBase[6].setMatriz(createArray(100, 0, 0));
        System.out.println("7");
        matricesBase[6].imprimirMatriz();
        matricesBase[7].setMatriz(createArray(0, 0, -100));
        System.out.println("8");
        matricesBase[7].imprimirMatriz();

        matricesBase[8].setMatriz(createArray(0, 100, 0));
        System.out.println("9");
        matricesBase[8].imprimirMatriz();
        matricesBase[9].setMatriz(createArray(0, 0, 100));
        System.out.println("10");
        matricesBase[9].imprimirMatriz();
        matricesBase[10].setMatriz(createArray(0, -100, 0));
        System.out.println("11");
        matricesBase[10].imprimirMatriz();
        matricesBase[11].setMatriz(createArray(-100, 0, 0));
        System.out.println("12");
        matricesBase[11].imprimirMatriz();

        matricesBase[12].setMatriz(createArray(0, 100, 0));
        System.out.println("13");
        matricesBase[12].imprimirMatriz();
        matricesBase[13].setMatriz(createArray(100, 0, 0));
        System.out.println("14");
        matricesBase[13].imprimirMatriz();
        matricesBase[14].setMatriz(createArray(-100, 0, 0));
        System.out.println("15");
        matricesBase[14].imprimirMatriz();
        matricesBase[15].setMatriz(createArray(0, 0, -100));
        System.out.println("16");
        matricesBase[15].imprimirMatriz();

    }

    public Matriz getMatrizEstado() {
        Matriz resultado = new Matriz();
        setMatrizDesplazamiento();
        resultado = resultado.multiplicarMatriz(matrizDesplazamiento);
        return resultado;
    }

//    public Matriz getCoordenadas() {
//        //matricesAbs[0].setMatriz(setME(x, y, z, zoom, alpha, beta, delta, theta));
//        Matriz matrizTemporal = new Matriz();
//        matrizTemporal = matrizTemporal.multiplicarMatriz(getMatrizEstado());
////        matrizTemporal = matrizTemporal.multiplicarMatriz(matricesBase[0]);
//        for (int i = 0; i < matricesBase.length; i++) {
//            matrizTemporal = matrizTemporal.multiplicarMatriz(matricesBase[i]);
//
//            if (i % 2 == 0 || i == matricesBase.length - 1) {
//                int index = (i != matricesBase.length - 1) ? i / 2 : coordenadas.length - 1;
//                coordenadas[index][0] = matrizTemporal.matriz[0][3];//x
//                coordenadas[index][1] = matrizTemporal.matriz[1][3];//y
//                coordenadas[index][2] = matrizTemporal.matriz[2][3];//z
//            }
////            matrizTemporal = matrizTemporal.multiplicarMatriz(matricesBase[i]);
//
//        }
//
//        System.out.println();
//        return matrizTemporal;
//    }
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
        System.out.println("*********************COORDENADAS*********************");
        setMatricesBase();

        for (int i = 0; i < matricesBase.length - 1; i++) {
            if (i == 0) {
                System.out.println("MATRIZ ESTADO");
                matrizEstado.imprimirMatriz();
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
        System.out.println("*****************************************************");

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
