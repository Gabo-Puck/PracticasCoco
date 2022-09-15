/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package expressions;

import Package1.Expression;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author divah_000
 */
public class Expressions {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        boolean continuar = false;
        System.out.println("Escriba sus variables, separando cada variable con un espacio e indicando el valor con dos puntos");
        Scanner in = new Scanner(System.in);
        String variablesInput = in.nextLine();
        String[] variables = variablesInput.split(" ");
        System.out.println("Escriba su expresion");
        String expresion = in.nextLine();
        List<String> variablesString = new ArrayList();
        List<Integer> variablesInt = new ArrayList();
        if (variables.length > 0) {
            for (int i = 0; i < variables.length; i++) {
                if(variables[0].equals("")){
                    break;
                }
                variablesString.add(variables[i].split(":")[0]);
                variablesInt.add(Integer.parseInt(variables[i].split(":")[1]));
            }
        }

        try {
            Expression expressionObj = new Expression(expresion, (Integer[])variablesInt.toArray(new Integer[0]), variablesString.toArray(new String[0]));
            expressionObj.isValidExpression(expresion);
            String resultado = expressionObj.resolverExpresion();
            System.out.println("Resultado: ".concat(resultado));
        } catch (Error er) {
            System.out.println(er.getMessage());
        } catch(IndexOutOfBoundsException err){
            
        }

    }

}
