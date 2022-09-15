/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package Package1;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author divah_000
 */
public class ExpressionTest {

    public ExpressionTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of getValorNumerico method, of class Expression.
     */
//    @Test
//    public void testGetValorNumerico() {
//        System.out.println("getValorNumerico");
//        String prev = "";
//        Expression instance = new Expression("", 2, "");
//        int expResult = 4;
//        int result = instance.getValorNumerico("2");
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//    }
//
//    @Test
//    public void testIsValidExpressionWithoutParentesis() {
//        System.out.println("testIsValidExpressionWithoutParentesis");
//        String prev = "";
//        Expression instance = new Expression("", 2, "");
//        boolean expResult = true;
//        boolean result = instance.isValidExpression("2x+59");
//        assertEquals(expResult, result);
//    }
//
//   
//    public void testIsValidExpressionWithParentesisClosed() {
//        System.out.println("testIsValidExpressionWithParentesisClosed");
//        String expe = "2*x+1*3*x";
//        //String expe = "4.0+6.0";
//
//        //"((2x+90*(3x*x))+(3x+99))*(1/3x)+((1*5x)/(5x+9))"
//        Expression instance = new Expression(expe, 2, "x");
//        instance.resolveOperaciones(expe);
//        boolean expResult = true;
//        boolean result = instance.isValidExpression("((2x+90*(3x*x))+(3x+99))*(1/3x)+((1*5x)/(5x+9))");
//        assertEquals(expResult, result);
//    }
//    
//    
//    
//    
//    
//    
//    public void testResolveOperacionesWithoutParentesis(){
//        System.out.println("testResolveOperaciones");
//        String expression = "2*x+1*3*x";
//        Expression instance = new Expression(expression,2,"x");
//        String result = instance.resolverExpresion();
//        String expResult = "10.0";
//        assertEquals(expResult,result);
//    }
//    
//    //@Test
//    public void testResolveOperacionesWithParentesisNested(){
//        System.out.println("testResolveOperacionesWithParentesisNested");
//        String expression = "((2*x+5*x+9*x)*(9*x+90))^2";
//        Expression instance = new Expression(expression,4,"x");
//        String result = instance.resolverExpresion();
//        String expResult ="65028096.0";
//        assertEquals(expResult,result);//Escribe con notación cientifica :c
//    }
//    
//    @Test
//    public void testResolveOperacionesWithParentesisNestedSmallNumber(){
//        System.out.println("testResolveOperacionesWithParentesisNested");
//        String expression = "((2*x+1)-(3*x+2))^2";
//        Expression instance = new Expression(expression,2,"x");
//        String result = instance.resolverExpresion();
//        String expResult ="9.0";
//        assertEquals(expResult,result);
//    }
    @Test
    public void testResolveOperaciones1() {
        System.out.println("testResolveOperaciones1");
        String expression = "70-6*(1+9)-30/3";
        Expression instance = new Expression(expression, new Integer[]{}, new String[]{});
        String result = instance.resolverExpresion();
        String expResult = "0.0";
        assertEquals(expResult, result);
    }

    @Test
    public void testResolveOperaciones2() {
        System.out.println("testResolveOperaciones2");
        String expression = "3-9*(-15-2)/9-3";
        Expression instance = new Expression(expression, new Integer[]{}, new String[]{});
        String result = instance.resolverExpresion();
        String expResult = "17.0";
        assertEquals(expResult, result);
    }

    @Test
    public void testResolveOperaciones3() {
        System.out.println("testResolveOperaciones3");
        String expression = "(1-(1-2))*6+18";
        Expression instance = new Expression(expression, new Integer[]{}, new String[]{});
        String result = instance.resolverExpresion();
        String expResult = "30.0";
        assertEquals(expResult, result);
    }

    @Test
    public void testResolveOperaciones4() {
        System.out.println("testResolveOperaciones4");
        String expression = "A+B+C/A+B+C";
        Integer[] variablesInt = new Integer[]{3, 1, 2};
        String[] variablesString = new String[]{"A", "B", "C"};
        Expression instance = new Expression(expression, variablesInt, variablesString);
        String result = instance.resolverExpresion();
        String expResult = "7.66666";
        assertEquals(expResult, result);
    }

    @Test
    public void testResolveOperaciones5() {
        System.out.println("testResolveOperaciones5");
        String expression = "A-A*(A+A)-1";
        Integer[] variablesInt = new Integer[]{100};
        String[] variablesString = new String[]{"A"};
        Expression instance = new Expression(expression, variablesInt, variablesString);
        String result = instance.resolverExpresion();
        String expResult = "-19901.0";
        assertEquals(expResult, result);
    }

    @Test
    public void testResolveOperaciones6() {
        System.out.println("testResolveOperaciones6");
        String expression = "A/B+C";
        Integer[] variablesInt = new Integer[]{0, 0, 0};
        String[] variablesString = new String[]{"A", "B", "C"};
        Expression instance = new Expression(expression, variablesInt, variablesString);
        String result = instance.resolverExpresion();
        String expResult = "7.66666";
        assertEquals(expResult, result);
    }

    @Test
    public void testResolveOperaciones7() {
        System.out.println("testResolveOperaciones7");
        String expression = "A*/B";
        Integer[] variablesInt = new Integer[]{1, 2};
        String[] variablesString = new String[]{"A", "B"};
        Expression instance = new Expression(expression, variablesInt, variablesString);
        instance.isValidExpression(expression);
        String result = instance.resolverExpresion();
        String expResult = "7.66666";
        assertEquals(expResult, result);
    }

    @Test
    public void testResolveOperaciones8() {
        System.out.println("testResolveOperaciones8");
        String expression = "A-13(18-1)";
        Integer[] variablesInt = new Integer[]{10};
        String[] variablesString = new String[]{"A"};
        Expression instance = new Expression(expression, variablesInt, variablesString);
        String result = instance.resolverExpresion();
        String expResult = "-19901.0";
        assertEquals(expResult, result);
    }

//    
//    public void testResolveOperacionesWithParentesis(){
//        System.out.println("testResolveOperaciones");
//        String expression = "(2*x)+(1*3*x)";
//        Expression instance = new Expression(expression,2,"x");
//        String result = instance.resolverExpresion();
//        String expResult = "10.0";
//        assertEquals(expResult,result);
//    }
//    @Test
//    public void testIsValidExpressionWithParentesisMissingClose() {
//        System.out.println("testIsValidExpressionWithParentesisMissingClose");
//        String prev = "";
//        Expression instance = new Expression("(2x+3)+(5x-9)", 2, "");
//        boolean expResult = false;
//        boolean result = instance.isValidExpression("((2x-1)*(x+2)/((5x+9)*22)/5x");
//        assertEquals(expResult, result);
//    }
//    
//
//    @Test
//    public void testIsValidExpressionWithParentesisMissingOpen() {
//        System.out.println("testIsValidExpressionWithParentesisMissingOpen");
//        String prev = "";
//        Expression instance = new Expression("(2x+3)+(5x-9)", 2, "");
//        boolean expResult = false;
//        boolean result = instance.isValidExpression("(2x+5)+(2x^2))");
//        assertEquals(expResult, result);
//    }
//
//    @Test
//    public void testIsValidExpressionWithParentesisInverted() {
//        System.out.println("testIsValidExpressionWithParentesisInverted");
//        String prev = "";
//        Expression instance = new Expression(")2x+3(+)5x-9(", 2, "");
//        boolean expResult = false;
//        boolean result = instance.isValidExpression(")2x+3(+)5x-9(");
//        assertEquals(expResult, result);
//    }
}
