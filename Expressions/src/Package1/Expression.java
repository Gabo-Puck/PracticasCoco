/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Package1;

import java.util.Dictionary;

/**
 *
 * @author divah_000
 */
public class Expression {

    String exp;
    String expRec;
    Integer variableInt;
    String variableString;

    public Expression(String exp, int variableInt, String variableString) {
        this.exp = exp;
        this.variableInt = variableInt;
        this.variableString = variableString;
    }

    public int getValorNumerico(String prev) {
        try {
            int x = Integer.parseInt(prev) * this.variableInt;
            return x;
        } catch (Exception ex) {
            throw new Error("No es numero");
        }

    }

    public String resolverExpresion() {

        return resolveParentesis(exp);
    }

    public String doMath(float n1, float n2, char op) {

        switch (op) {
            case '^':
                return String.valueOf(Math.pow(n2, n1));
            case '*':
                return String.valueOf(n1 * n2);

            case '/':
                return String.valueOf(n1 / n2);
            case '+':
                return String.valueOf(n1 + n2);

            case '-':
                return String.valueOf(n1 - n2);
        }

        return null;

    }

    public float[] getTerminos(int index, String expression) {

        return null;

    }

    public String resolveOperaciones(String expression) {
        String operaciones = "^*/+-";
        expression = expression.replaceAll(variableString, variableInt.toString());
        StringBuilder expression2 = new StringBuilder(expression);

        for (int i = 0; i < operaciones.length(); i++) {
            float n1 = 0, n2 = 0;
            int rango1 = 0, rango2 = 0;
            char charAt = operaciones.charAt(i);
            int index = expression2.indexOf(String.valueOf(charAt));
            if (index != -1) {

                for (int x = index + 1; x <= expression2.length(); x++) {

                    if (x == expression2.length() || operaciones.indexOf(expression2.charAt(x)) != -1) {
                        if (x != expression2.length()) {

                        }
                        rango2 = (x == expression2.length()) ? x + 1 : x;
                        n1 = Float.parseFloat(expression2.substring(index + 1, x));
                        break;
                    }
                }
                for (int x = index - 1; x >= 0; x--) {
                    if (operaciones.indexOf(expression2.charAt(x)) != -1 || x == 0) {
                        rango1 = (x == 0) ? x : x + 1;
                        if (x != expression2.length()) {
                            if (operaciones.indexOf(expression2.charAt(x)) == '-') {
                                n2 = Float.parseFloat(expression2.substring(index + 2, x));
                                break;
                            }
                        }
                        n2 = Float.parseFloat(expression2.substring(x, index));

                        break;
                    }
                }
                String result = doMath(n1, n2, expression2.charAt(index));
                expression2.replace(rango1, rango2, result);
                i--;
            } else {

            }
        }
        return expression2.toString();

    }

    public String resolveParentesis(String expression) {
        StringBuilder expressionRec = new StringBuilder(expression);
        int[] indexParentesis = new int[2];
        int indexCuadrado;
        int indexPor;
        int indexEntre;
        int indexMas;
        int indexMenos;
        System.out.println(expressionRec);
        if (!expression.contains("(") && !expression.contains(")")) {
            expression.replaceAll(variableString, variableString);
            return resolveOperaciones(expressionRec.toString());
        }
        do {
            indexParentesis = getTerminoParentesis(expressionRec, indexParentesis);
            String expression2 = expressionRec.substring(indexParentesis[0] + 1, indexParentesis[1]);
            String result = resolveParentesis(expression2);
            expressionRec.replace(indexParentesis[0], indexParentesis[1] + 1, result);
            System.out.println(expressionRec);
        } while (expressionRec.lastIndexOf(")") != -1 && expressionRec.indexOf("(", 0) != -1);

        return resolveOperaciones(expressionRec.toString());

    }

    public int[] getTerminoParentesis(StringBuilder expression, int[] indexParentesis) {
        int cont = 1;
        indexParentesis[0] = expression.indexOf("(");
        try {

            for (int x = indexParentesis[0] + 1; x < expression.length() + 1; x++) {
                if (expression.charAt(x) == ')') {
                    cont--;
                }
                if (expression.charAt(x) == '(') {
                    cont++;
                }
                if (cont == 0) {
                    indexParentesis[1] = x;
                    break;
                }
            }
        } catch (IndexOutOfBoundsException ex) {
            throw ex;
        }
        return indexParentesis;
    }

    public boolean isValidExpression(String s) {
        StringBuilder expression = new StringBuilder(s);
        int cont = 1;
        int i = 0;
        int indexParentesis[] = new int[2];
        int diff = 1;
        try {
            while (expression.indexOf("(") != -1) {
                indexParentesis = getTerminoParentesis(expression, indexParentesis);
                expression.deleteCharAt(indexParentesis[1]);
                expression.deleteCharAt(indexParentesis[0]);
                diff = s.length() - expression.length() + 1;
            }
        } catch (IndexOutOfBoundsException ex) {
            System.out.println("El parentesis en la posición " + (indexParentesis[0] + diff) + " no tiene cierre");
            return false;
        }
        int index = expression.indexOf(")");
        if (index != -1) {
            System.out.println("El parentesis en la posición " + (index + diff) + " no tiene cierre");
            return false;
        }
        return true;
    }

}
