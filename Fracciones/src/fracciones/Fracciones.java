/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package fracciones;

import java.lang.reflect.Array;
import java.util.Scanner;

/**
 *
 * @author Melkor
 */
public class Fracciones {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            System.out.println("Escribe tu operación: ");
            Scanner input = new Scanner(System.in);
            String expression = input.nextLine();
            fromExpression(expression);
        } catch (Error err) {
            System.out.println("Error: ".concat(err.getMessage()));
        }
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
        String[] operaciones = {"mas", "menos", "por", "entre"};
        //String[] terminos = new String[2];
        expression = expression.trim();
        int indexOperacion = 0;
        Fraccion[] fracciones = new Fraccion[4];
        for (int i = 0; i < operaciones.length; i++) {
            indexOperacion = indexOf(expression.split(" "), operaciones[i]);
            if (indexOperacion != -1) {

                indexOperacion = i;
                String[] terminos = expression.split(operaciones[i]);

                fracciones[0] = getFraccion(terminos[0]);
                if (terminos[0].contains("negativo")) {
                    fracciones[0].setNumeradorNegativo();
                }
                fracciones[0].printFraccion();
                //System.out.println(fraccion[0] + "/" + fraccion[1]);
                fracciones[1] = getFraccion(terminos[1]);

                if (terminos[1].contains("negativo")) {
                    fracciones[1].setNumeradorNegativo();
                }

                fracciones[1].printFraccion();

                //System.out.println(fraccion2[0] + "/" + fraccion2[1]);
                break;
            }

        }
        if (indexOperacion == -1) {
            throw new Error("Se esperaba una operacion (mas,menos,por,entre)");
        }
        Fraccion f = new Fraccion();
        String fraccion = "";
        switch (indexOperacion) {
            case 0://mas
                f = fracciones[0].sumar(fracciones[1]);

                break;
            case 1://menos
                f = fracciones[0].restar(fracciones[1]);

                break;
            case 2://por
                f = fracciones[0].multiplicar(fracciones[1]);

                break;
            case 3://entre
                f = fracciones[0].dividir(fracciones[1]);
                break;
        }
        fraccion = fraccionToTexto(f);

        System.out.println("Resultado: ".concat(fraccion));
        f.printFraccion();

    }

    public static Fraccion getFraccion(String termino) {
        String[] decenas = {"diez", "veinte", "treinta", "cuarenta", "cincuenta", "sesenta", "setenta", "ochenta", "noventa"};
        String[] decenasEx = {"once", "doce", "trece", "catorce", "quince", "dieciseis", "diecisiete", "dieciocho", "diecinueve"};
        String[] unidades = {"un", "dos", "tres", "cuatro", "cinco", "seis", "siete", "ocho", "nueve"};
        String[] partitivos = {"medios", "tercios", "cuartos", "quintos", "sextos", "septimos", "octavos", "novenos", "decimos"};
        int cantidad = 0;
        int[] equivalentesEx = {11, 12, 13, 14, 15, 16, 17, 18, 19};

        int[] equivalentes = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        boolean isEnabled = true;
        boolean isNegative = false;
        termino = termino.trim();
        //System.out.println(termino);
        termino = termino.replaceAll("negativo ", "");
        String[] palabras = termino.split((" "));
        for (String palabra : palabras) {
            palabra = palabra.trim();
        }
        String denominador = "";
        if (palabras[0].equals("menos")) {
            isNegative = true;
        }

        if (palabras[palabras.length - 1].contains("avo")) {
            String pal = palabras[palabras.length - 1];
            char lastLetra = pal.charAt(pal.length() - 4);
            denominador = palabras[palabras.length - 1].replaceAll("avo", "");
            int index = indexOf(decenas, denominador.concat("a"));
            if (index != -1) {
                denominador = decenas[index];
            }

        }
        if (palabras[palabras.length - 1].contains("avos")) {
            //denominador = palabras[palabras.length - 1].replaceAll("avos", "");
            String pal = palabras[palabras.length - 1];
            char lastLetra = pal.charAt(pal.length() - 4);
            denominador = palabras[palabras.length - 1].replaceAll("avos", "");
            int index = indexOf(decenas, denominador.concat("a"));
            if (index != -1) {
                denominador = decenas[index];
            }
        }
        if (indexOf(partitivos, palabras[palabras.length - 1]) != -1) {
            int index = indexOf(partitivos, palabras[palabras.length - 1]);
            denominador = partitivos[index];
        }
        if (indexOf(partitivos, palabras[palabras.length - 1].concat("s")) != -1) {
            int index = indexOf(partitivos, palabras[palabras.length - 1].concat("s"));
            denominador = partitivos[index];
        }
        if (denominador.equals("")) {

            throw new Error("No se encontró un denominador");

        }

        if (palabras.length < 2 || palabras.length > 5) {
            throw new Error("Se esperaba una expresión: [numerador] [denominador]");
        }
        if (termino.contains("y")) {
            int indexY = indexOf(palabras, "y");
            boolean isFinded = false;
            if (indexY != 1) {
                throw new Error("Se esperaba un numero antes y despues de 'y'");
            }

        }
        if (indexOf(decenasEx, palabras[0]) != -1) {
            int index = indexOf(decenasEx, palabras[0]);
            if (index != -1) {
                cantidad += equivalentesEx[index];
                isEnabled = false;
            }
        }
        if (palabras[0].contains("veinti")) {
            if (isEnabled) {
                int index = indexOf(unidades, palabras[0].substring(6));
                if (index != -1) {
                    cantidad += 20 + equivalentes[index];
                    isEnabled = false;
                }
            } else {
                throw new Error("Se esperaba denominador después del numerador");
            }

        }

        if (indexOf(decenas, palabras[0]) != -1) {
            if (isEnabled) {
                int index = indexOf(decenas, palabras[0]);
                if (index != -1) {
                    cantidad += equivalentes[index] * 10;
                    if (palabras[1].equalsIgnoreCase("y")) {
                        if (palabras.length == 3) {
                            throw new Error("Se esperaba una unidad");

                        }
                        palabras[0] = palabras[2];
                    } else {
                        isEnabled = false;

                    }

                }
            }
        }
        if (indexOf(unidades, palabras[0]) != -1) {
            if (isEnabled) {
                int index = indexOf(unidades, palabras[0]);
                if (index != -1) {
                    cantidad += equivalentes[index];
                }
            }
        } else {
            if (palabras[0].equals("cero")) {
                cantidad = 0;
            } else {
                if (cantidad == 0) {
                    throw new Error("No se encontro el numero escrito para el numerador");
                }
            }

        }
        int cantidadDen = 0;

        int indexContain = indexOfContains(decenas, denominador);
        if (indexContain != -1) {
            if (decenas[indexContain].equals(denominador)) {
                denominador = "";
            } else {
                denominador = denominador.replaceAll(decenas[indexContain].concat("i"), "");
            }
            cantidadDen += equivalentes[indexContain] * 10;
            if (!denominador.equals("")) {
                int indexUnidad = indexOf(unidades, denominador);
                if (indexUnidad != -1) {
                    denominador = denominador.replaceAll(unidades[indexUnidad], "");
                    cantidadDen += equivalentes[indexUnidad];
                } else {
                    throw new Error("El denominador esta mal");
                }
            }

        }
        if (denominador.contains("veint")) {

            int index = indexOf(unidades, denominador.substring(6));
            if (denominador.equalsIgnoreCase("veinte")) {
                cantidad = 20;
            }
            if (index != -1) {
                cantidadDen = 20 + equivalentes[index];
            }

        }

        indexContain = indexOfContains(decenasEx, denominador);
        if (indexContain != -1) {
            cantidadDen = equivalentesEx[indexContain];
        }
        indexContain = indexOfContains(partitivos, denominador);
        if (indexContain != -1) {
            cantidadDen += indexContain + 2;
        }

//        for (String palabra : palabras) {
//            System.out.println(palabra + "x");
//        }
        //int[] fraccion = {cantidad, cantidadDen};
        Fraccion fraccion = new Fraccion(cantidad, cantidadDen);
        return fraccion;
    }

    public static String fraccionToTexto(Fraccion f) {
        String denominador = numeroToTexto(f.denominador);
        String numerador = numeroToTexto(f.numerador);
        if (denominador.equals(numerador)) {
            return "un entero";
        }
        if (numerador.equals("cero")) {
            return numerador;
        }
        if (denominador.equals("cero")) {
            throw new Error("No se puede poner cero en el denominador");
        }
        if (denominador.charAt(denominador.length() - 1) == 'a') {
            denominador = denominador.replace(" ", "").replace("y", "i").concat("vos");
        } else {
            denominador = denominador.replace(" ", "").replace("y", "i").concat("avos");
        }

        denominador = removerLetrasRepetidas(denominador);

        return numerador.concat(" ").concat(denominador);
    }

    public static String removerLetrasRepetidas(String s) {
        char[] expression = s.toCharArray();
        StringBuilder sa = new StringBuilder(s);
        for (int i = 0; i < sa.length() - 1; i++) {
            if (sa.charAt(i) == sa.charAt(i + 1)) {
                sa = sa.deleteCharAt(i + 1);
            }
        }
        return sa.toString();
    }

    public static String numeroToTexto(int numero) {
        String[] decenas = {"diez", "veinte", "treinta", "cuarenta", "cincuenta", "sesenta", "setenta", "ochenta", "noventa"};
        String[] decenasEx = {"once", "doce", "trece", "catorce", "quince", "dieciseis", "diecisiete", "dieciocho", "diecinueve"};
        String[] unidades = {"un", "dos", "tres", "cuatro", "cinco", "seis", "siete", "ocho", "nueve"};
        String[] centenas = {"cien", "doscientos", "trescientos", "cuatrocientos", "quinientos", "seiscientos", "setecientos", "ochoscientos", "novescientos"};
        String[] partitivos = {"medios", "tercios", "cuartos", "quintos", "sextos", "septimos", "octavos", "novenos", "decimos"};
        if (numero == 0) {
            return "cero";
        }
        String mil = "mil";
        String read = "";
        String valor = "";
        if (numero < 0) {
            read = read.concat("negativo");
            numero *= -1;
        }
        String[] equivalentes = {"1", "2", "3", "4", "5", "6", "7", "8", "9"};
        String[] equivalentesEx = {"11", "12", "13", "14", "15", "16", "17", "18", "19"};
        String formatNum = String.format("%04d", numero);

        char[] numerador = formatNum.toString().toCharArray();
        int longitud = numerador.length;
        for (int i = 0; i < longitud; i++) {
            if (i == 0) {
                if (!String.valueOf(numerador[i]).equals("0")) {
                    if (numerador[i] == '1') {
                        read = read.concat(mil).concat(" ");
                    } else {
                        valor = unidades[Integer.parseInt(String.valueOf(numerador[i])) - 1];

                        read = read.concat(valor).concat(" mil");
                    }
                }

            }
            if (i == 1) {
                if (!String.valueOf(numerador[i]).equals("0")) {
                    valor = centenas[Integer.parseInt(String.valueOf(numerador[i])) - 1];

                    if (numerador[i] == '1') {
                        if (numerador[i + 1] == '0' && numerador[i + 2] == '0') {
                            read = read.concat(" ").concat(valor);

                        } else {
                            read = read.concat(" ").concat(valor).concat("to");
                        }
                    } else {
                        read = read.concat(" ").concat(valor);
                    }
                }

            }
            if (i == 2) {
                String conjunto = String.valueOf(numerador[i]);
                conjunto = conjunto.concat(String.valueOf(numerador[i + 1]));

                if (conjunto.charAt(0) != '0') {
                    int index = indexOf(equivalentesEx, conjunto);
                    if (conjunto.charAt(0) == '2') {
                        int indexUnidad = indexOf(equivalentes, String.valueOf(conjunto.charAt(1)));
                        read = read.concat(" ").concat("veinti").concat(unidades[indexUnidad]);
                        break;
                    }
                    if (index != -1) {

                        read = read.concat(" ").concat(decenasEx[index]);
                        break;
                    } else {
                        valor = decenas[Integer.parseInt(String.valueOf(numerador[i])) - 1];
                        read = read.concat(" ").concat(valor).concat(" y");
                    }
                } else {
                    if (conjunto.charAt(0) == '0' && conjunto.charAt(1) == '0') {
                        break;
                    }
                }
            }

            if (i == 3) {
                if (!String.valueOf(numerador[i]).equals("0")) {
                    valor = unidades[Integer.parseInt(String.valueOf(numerador[i])) - 1];
                    read = read.concat(" ").concat(valor);
                } else {
                    read = read.replace("y", "");
                }

            }
        }

        return read;
    }

    public static int indexOf(String[] array, String string) {
        for (int i = 0; i < array.length; i++) {
            if (array[i].equalsIgnoreCase(string)) {
                return i;
            }
        }
        return -1;
    }

    public static int indexOfContains(String[] array, String string) {
        for (int i = 0; i < array.length; i++) {
            if (string.contains(array[i])) {
                return i;
            }
        }
        return -1;
    }

}

class Fraccion {

    int numerador;
    int denominador;

    public Fraccion(int numerador, int denominador) {
        this.numerador = numerador;
        this.denominador = denominador;
    }

    public void setNumeradorNegativo() {
        this.numerador *= -1;
    }

    public Fraccion() {

    }

    public Fraccion sumar(Fraccion f1) {
        Fraccion f = new Fraccion();
        if (this.numerador == 0) {
            f.numerador = f1.numerador;
            f.denominador = 1;
            return f;
        }
        if (f1.numerador == 0) {
            f.numerador = this.numerador;
            f.denominador = 1;

            return f;
        }
        f.denominador = this.denominador * f1.denominador;
        f.numerador = (this.numerador * f1.denominador) + (f1.numerador * this.denominador);
        return f;

    }

    public Fraccion restar(Fraccion f1) {
        Fraccion f = new Fraccion();
        if (this.numerador == 0) {
            f.numerador = f1.numerador;
            f.denominador = 1;
            return f;
        }
        if (f1.numerador == 0) {
            f.numerador = this.numerador;
            f.denominador = 1;

            return f;
        }
        f.denominador = this.denominador * f1.denominador;
        f.numerador = (this.numerador * f1.denominador) - (f1.numerador * this.denominador);
        return f;

    }

    public Fraccion multiplicar(Fraccion f1) {

        Fraccion f = new Fraccion();
        f.denominador = this.denominador * f1.denominador;
        f.numerador = this.numerador * f1.numerador;
        return f;

    }

    public Fraccion dividir(Fraccion f1) {
        Fraccion f = new Fraccion();
        f.denominador = this.denominador * f1.numerador;
        f.numerador = this.numerador * f1.denominador;
        return f;
    }

    public void printFraccion() {
        System.out.println(this.numerador + "/" + this.denominador);
    }
}
