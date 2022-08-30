/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package fracciones;

import java.lang.reflect.Array;

/**
 *
 * @author divah_000
 */
public class Fracciones {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println("aaa");
        fromExpression("nueve noventa");
        // TODO code application logic here
    }

    public static String fromExpression(String expression) {
        getNumeradorExpresion(expression);

//        int cantidad = 0;
//        for (String cadena : expresionPalabras) {
//            int decenaIndex = indexOf(decenas, cadena);
//            int unidadIndex = indexOf(unidades, cadena);
//            if (decenaIndex != -1) {
//                cantidad += equivalentes[decenaIndex] * 10;
//            }
//            if (unidadIndex != -1) {
//                cantidad += equivalentes[unidadIndex];
//            }
//        }
//        System.out.println(cantidad);
        return "";
    }

    public static void getNumeradorExpresion(String expression) {
        String[] decenas = {"diez", "veinte", "treinta", "cuarenta", "cincuenta", "sesenta", "setenta", "ochenta", "noventa"};
        String[] decenasEx = {"once", "doce", "trece", "catorce", "quince", "dieciseis", "diecisiete", "dieciocho", "diecinueve"};
        String[] unidades = {"un", "dos", "tres", "cuatro", "cinco", "seis", "siete", "ocho", "nueve"};
        int[] equivalentes = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        int[] equivalentesEx = {11, 12, 13, 14, 15, 16, 17, 18, 19};

        String[] expresionPalabras = expression.split(" ");
        int cantidad = 0;
        boolean isDisabled = false;
        boolean isEnabledUnidad = false;
        for (String cadena : expresionPalabras) {
            int decenaIndex = indexOf(decenas, cadena);
            int unidadIndex = indexOf(unidades, cadena);
            int ex = indexOf(decenasEx, cadena);
            if (decenaIndex != -1) {
                if (isDisabled) {
                    System.out.println("Expresión invalida!");
                    return;
                }
                cantidad += equivalentes[decenaIndex] * 10;
                isDisabled = true;
                isEnabledUnidad = true;
            }

            if (ex != -1) {
                if (isDisabled) {
                    System.out.println("Expresión invalida!");
                    return;
                }
                isDisabled = true;
                cantidad += equivalentesEx[ex];

            }

            if (unidadIndex != -1) {
                if (isDisabled && !isEnabledUnidad) {
                    System.out.println("Expresión invalida!");
                    return;
                }
                isDisabled = true;
                cantidad += equivalentes[unidadIndex];
            }
        }
        System.out.println(cantidad);
    }

    public static int indexOf(String[] array, String string) {
        for (int i = 0; i < array.length; i++) {
            if (array[i].equalsIgnoreCase(string)) {
                return i;
            }
        }
        return -1;
    }
}

class fraccionx {

    short numerador;
    short denominador;

    public void setNumerador(short numerador) {
        this.numerador = numerador;
    }

    public void setDenominador(short denominador) {
        this.denominador = denominador;
    }

    public short getNumerador() {
        return this.numerador;
    }

    public short getDenominador() {
        return this.denominador;
    }
}
