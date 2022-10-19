/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

/**
 *
 * @author divah_000
 */
public class Matriz {

    public int[][] getMatriz() {
        return matriz;
    }

    public void setMatriz(int[][] matriz) {
        this.matriz = matriz;
    }

    int[][] matriz;
    int x;
    int y;

    public Matriz(int[][] _matriz) {
        if (_matriz.length < 0) {
            throw new Error("La matriz no puede ser 0");
        }
        matriz = _matriz;
        x = matriz[0].length;
        y = matriz.length;
    }

    public Matriz() {
    }

    public Matriz sumarMatriz(Matriz xd) {
        System.out.println("x: " + x + ", y: " + y);
        int m[][] = {
            {0, 0, 0, 0},
            {0, 0, 0, 0},
            {0, 0, 0, 0},
            {0, 0, 0, 0}
        };
        if (x != xd.y) {
            throw new Error("El numero de columnas de una matriz debe ser igual al numero de filas de de la otra matriz ");
        }
        for (int d = 0; d < y; d++) {
            int[] fila = matriz[d];
            for (int i = 0; i < x; i++) {
                int suma = 0;

                for (int x = 0; x < y; x++) {
                    int elementoFila = xd.matriz[x][i];
                    int elementoColumna = fila[x];
                    int res = elementoColumna * elementoFila;
                    suma += res;

                }
                System.out.print(suma + " ");
                m[d][i] = suma;
            }

            System.out.println();

        }
        System.out.println();

        Matriz resultado = new Matriz(m);

        /*
        1,0,0,0         1,0,0,0
        
        0,1,0,0         0,1,0,0
                    +
        0,0,1,0         0,0,1,0
        
        0,0,0,1         0,0,0,1
         */
        return resultado;
    }

}
