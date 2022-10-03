/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Funcionalidad;

import java.util.Dictionary;

/**
 *
 * @author divah_000
 */
public class Expression {

    String exp;
    String expRec;
    Integer[] variableInt;
    String[] variableString;

    public Expression(String exp, Integer[] variableInt, String[] variableString) {
        this.exp = exp;
        this.variableInt = variableInt;
        this.variableString = variableString;
    }

    public int getValorNumerico(String prev) {
//        try {
//            //int x = Integer.parseInt(prev) * this.variableInt;
//            return x;
//        } catch (Exception ex) {
//            throw new Error("No es numero");
//        }
        return 0;
//        try {
//            //int x = Integer.parseInt(prev) * this.variableInt;
//            return x;
//        } catch (Exception ex) {
//            throw new Error("No es numero");
//        }

    }

    public String resolverExpresion() {

        return resolveParentesis(exp);
    }

    public String doMath(float n1, float n2, char op) {
        
        switch (op) {
            case '^':
                return String.valueOf(Math.pow(n1, n2));
            case '*':
                return String.valueOf(n2 * n1);

            case '/':
                if(n2==0){
                    throw new Error("Math error");
                }
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
        for (int i = 0; i < variableString.length; i++) {
            expression = expression.replaceAll(variableString[i], variableInt[i].toString());
        }
        StringBuilder expression2 = new StringBuilder(expression);

        for (int i = 0; i < operaciones.length(); i++) {
            float n1 = 0, n2 = 0;
            int rango1 = 0, rango2 = 0;
            char charAt = operaciones.charAt(i);
            int index = expression2.indexOf(String.valueOf(charAt));
            try {
                float isNumber = Float.parseFloat(expression2.toString());

                break;

            } catch (Exception ex) {

            }
            if (index != -1) {

                if (expression2.charAt(index) == '-') {
                    if (expression2.charAt(index + 1) == '-') {
                        expression2.replace(index, index + 2, "+");
                    }
                }
                index = (index == 0) ? expression2.indexOf("-", 1) : index;
                boolean toContinue = false;
                int nextInitial = index + 1;
                for (int x = index + 1; x <= expression2.length(); x++) {
                    if (x < expression2.length() - 1 && toContinue == false && expression2.charAt(x) == '-' && x == nextInitial) {
                        toContinue = true;
                        x = x + 2;
                    }
                    if ((x == expression2.length() || operaciones.indexOf(expression2.charAt(x)) != -1)) {
                        rango2 = (x == expression2.length()) ? x + 1 : x;
                        n2 = Float.parseFloat(expression2.substring(index + 1, x));
                        break;
                    }
                }
                for (int x = index - 1; x >= 0; x--) {
                    if (operaciones.indexOf(expression2.charAt(x)) != -1 || x == 0) {
//                        (x==0 || expression2.charAt(x-1))=='(')
                        rango1 = (x == 0) ? x : x + 1;

                        if (expression2.charAt(x) == '-' && x!=0) {
                            n1 = Float.parseFloat(expression2.substring(x, index));
                            rango1--;
                            
                        } else {
                            n1 = Float.parseFloat(expression2.substring(x, index));
                        }

                        break;
                    }
                }

                String result = doMath(n1, n2, expression2.charAt(index));
                if (n1 < 0 && n2 < 0) {
                    expression2.replace(rango1, rango1+1, "+");
                    rango1++;
                }
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
        String operaciones = "^*/+-";
        for (int i = 0; i < variableString.length; i++) {
            expression = expression.replaceAll(variableString[i], variableInt[i].toString());
        }
//        expression.replaceAll(variableString, variableString);

        System.out.println(expressionRec);
        if (!expression.contains("(") && !expression.contains(")")) {
            String result = resolveOperaciones(expressionRec.toString());
            if (result.equals("NaN")) {
                System.out.println("Math Error");
                throw new Error("Math Error");
            }
            return result;
        }
        do {
            indexParentesis = getTerminoParentesis(expressionRec, indexParentesis);
            String expression2 = expressionRec.substring(indexParentesis[0] + 1, indexParentesis[1]);
            String result = resolveParentesis(expression2);
            if (indexParentesis[0] > 0) {
                if (operaciones.indexOf(expressionRec.charAt(indexParentesis[0] - 1)) == -1 && Float.parseFloat(result) >= 0) {
                    System.out.println("Se esperaba un operador en la posicion " + (indexParentesis[0]));
                    throw new Error("Se esperaba un operador en la posicion " + (indexParentesis[0]));
                }
            }
            if (result.equals("NaN")) {
                System.out.println("Math Error");
                throw new Error("Math Error");
            }

//            if (indexParentesis[0] > 0) {
//                if (expression2.charAt(indexParentesis[0] - 1) == '-' && result.charAt(0) == '-') {
//                    result = result.replace("-", "");
//                }
//            }

            expressionRec.replace(indexParentesis[0], indexParentesis[1] + 1, result);
            String myStrong = expressionRec.toString();
            myStrong.replaceAll("---", "+");
            expressionRec = new StringBuilder(myStrong);
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

    public void isValidSignos(String s) {
        String operaciones = "^*/+-";
        int cont = 0;
        for (int i = 0; i < s.length(); i++) {
            if (operaciones.indexOf(s.charAt(i)) != -1) {
                cont++;
            }
            if (s.charAt(i) == '-' && cont >= 1) {
                cont--;
            }
            if (cont == 2) {
                throw new Error("Se esperaba un numero o variable en la posición " + (i));
            }
        }
    }

    public boolean isValidExpression(String s) {
        StringBuilder expression = new StringBuilder(s);
        int cont = 1;
        int contSignos = 0;
        int i = 0;
        int indexParentesis[] = new int[2];
        int diff = 1;
        try {
            isValidSignos(s);
            while (expression.indexOf("(") != -1) {
                indexParentesis = getTerminoParentesis(expression, indexParentesis);
                expression.deleteCharAt(indexParentesis[1]);
                expression.deleteCharAt(indexParentesis[0]);
                diff = s.length() - expression.length() + 1;
            }
        } catch (IndexOutOfBoundsException ex) {
            System.out.println("El parentesis en la posición " + (indexParentesis[0] + diff) + " no tiene cierre");
            throw ex;
        } catch (Error er) {
//            System.out.println(er.getMessage());
            throw er;

        }
        int index = expression.indexOf(")");
        if (index != -1) {
            System.out.println("El parentesis en la posición " + (index + diff) + " no tiene cierre");
            return false;
        }
        return true;
    }

}
