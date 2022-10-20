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
    double[][] coordenadas;

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

    public void setMatrizRotacionX() {
        double a = Math.toRadians(angulo);
        for (int i = 1; i < 3; i++) {
            for (int j = 1; j < 3; j++) {
                if (i == j) {
                    matrizRotacionX.matriz[i][j] = Math.cos(a);
                } else if (i == 1 && j == 2) {
                    matrizRotacionX.matriz[i][j] = Math.sin(a);
                } else {
                    matrizRotacionX.matriz[i][j] = -Math.sin(a);
                }
            }
        }
    }

    public void setMatrizRotacionY() {
        double b = Math.toRadians(angulo);
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (i == j && i == 0) {
                    matrizRotacionY.matriz[i][j] = Math.cos(b);
                }
                if (i == j && i == 2) {
                    matrizRotacionY.matriz[i][j] = Math.cos(b);
                } else if (j == 2 && i == 0) {
                    matrizRotacionY.matriz[i][j] = -Math.sin(b);
                } else if (i == 2 && j == 0) {
                    matrizRotacionY.matriz[i][j] = Math.sin(b);
                }
            }
        }
    }

    public void setMatrizRotacionZ() {
        double t = Math.toRadians(angulo);
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                if (i == j) {
                    matrizRotacionZ.matriz[i][j] = Math.cos(t);
                } else if (i == 1 && j == 0) {
                    matrizRotacionZ.matriz[i][j] = Math.sin(t);
                } else {
                    matrizRotacionZ.matriz[i][j] = -Math.sin(t);
                }
            }
        }
    }

    int angulo;
    int x, y, z;
    int offset;
    int zoom;

    public Cubo() {
        matricesBase = new Matriz[16];
        angulo = 90;

        x = 350;
        y = 350;
        z = 50;
        zoom = 1;

        matrizDesplazamiento = new Matriz();
        matrizEscalar = new Matriz();
        matrizRotacionX = new Matriz();
        matrizRotacionY = new Matriz();
        matrizRotacionZ = new Matriz();
        setMatrizDesplazamiento();
        setMatrizEscalar();
        setMatrizRotacionX();
        setMatrizRotacionY();
        setMatrizRotacionZ();
        setMatricesBase();
        coordenadas = new double[][]{
            {0, 0, 0},
            {0, 0, 0},
            {0, 0, 0},
            {0, 0, 0},
            {0, 0, 0},
            {0, 0, 0},
            {0, 0, 0},
            {0, 0, 0}};
        getCoordenadas();
        System.out.println();
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
//        resultado = resultado.multiplicarMatriz(matrizEscalar);
//        resultado = resultado.multiplicarMatriz(matrizRotacionX);
//        resultado = resultado.multiplicarMatriz(matrizRotacionY);
//        resultado = resultado.multiplicarMatriz(matrizRotacionZ);
        return resultado;
    }

    public Matriz getCoordenadas() {
        //matricesAbs[0].setMatriz(setME(x, y, z, zoom, alpha, beta, delta, theta));
        Matriz matrizTemporal = new Matriz();
        matrizTemporal = matrizTemporal.multiplicarMatriz(getMatrizEstado());
        matrizTemporal = matrizTemporal.multiplicarMatriz(matricesBase[0]);
        for (int i = 1; i < matricesBase.length; i++) {
            matrizTemporal = matrizTemporal.multiplicarMatriz(matricesBase[i]);
            if (i % 2 == 0 || i == matricesBase.length - 1) {
                int index = (i != matricesBase.length - 1) ? i / 2 : coordenadas.length;
                coordenadas[index - 1][0] = matrizTemporal.matriz[0][3];//x
                coordenadas[index - 1][1] = matrizTemporal.matriz[1][3];//y
                coordenadas[index - 1][2] = matrizTemporal.matriz[2][3];//z
            }
        }

        System.out.println();
        return matrizTemporal;
    }

    public double[][] createArray(int y, int x, int z) {
        double m[][] = {
            {1, 0, 0, y},
            {0, 1, 0, x},
            {0, 0, 1, z},
            {0, 0, 0, 1}
        };
        return m;
    }

    public void dibujarCubo(Graphics g) {
        double coordPrevX = coordenadas[0][0];
        double coordPrevY = coordenadas[0][1];
        double coordPrevZ = coordenadas[0][2];

        int prevY = getY(coordPrevY, coordPrevZ);
        int prevX = getX(coordPrevX, coordPrevZ);
        System.out.println("*********************COORDENADAS*********************");
        for (int i = 1; i < coordenadas.length; i++) {
            double coordActualX = coordenadas[i][0];
            double coordActualY = coordenadas[i][1];
            double coordActualZ = coordenadas[i][2];
            int actualX = getY(coordActualX, coordActualZ);
            int actualY = getY(coordActualY, coordActualZ);

            System.out.println("prevX: " + prevX + " prevY: " + prevY + " actualX: " + actualX + " actualY: " + actualY);
            g.drawLine(prevX, prevY, actualX, actualY);
//            g.drawLine(actualX, actualY, prevX, prevY);

            prevY = actualY;
            prevX = actualX;

        }
        System.out.println("*****************************************************");

    }

    public int getY(double y, double z) {
        int yd = (int) (y - z * Math.sin(angulo));
        return yd;
    }

    public int getX(double x, double z) {
        int xd = (int) (x - z * Math.cos(angulo));
        return xd;
    }

}
