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
    @Test
    public void testGetValorNumerico() {
        System.out.println("getValorNumerico");
        String prev = "";
        Expression instance = new Expression("", 2, "");
        int expResult = 4;
        int result = instance.getValorNumerico("2");
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }

    @Test
    public void testIsValidExpressionWithoutParentesis() {
        System.out.println("testIsValidExpressionWithoutParentesis");
        String prev = "";
        Expression instance = new Expression("", 2, "");
        boolean expResult = true;
        boolean result = instance.isValidExpression("2x+59");
        assertEquals(expResult, result);
    }

   
    public void testIsValidExpressionWithParentesisClosed() {
        System.out.println("testIsValidExpressionWithParentesisClosed");
        String expe = "2*x+1*3*x";
        //String expe = "4.0+6.0";

        //"((2x+90*(3x*x))+(3x+99))*(1/3x)+((1*5x)/(5x+9))"
        Expression instance = new Expression(expe, 2, "x");
        instance.resolveOperaciones(expe);
        boolean expResult = true;
        boolean result = instance.isValidExpression("((2x+90*(3x*x))+(3x+99))*(1/3x)+((1*5x)/(5x+9))");
        assertEquals(expResult, result);
    }
    
    
    
    
    
    
    public void testResolveOperacionesWithoutParentesis(){
        System.out.println("testResolveOperaciones");
        String expression = "2*x+1*3*x";
        Expression instance = new Expression(expression,2,"x");
        String result = instance.resolverExpresion();
        String expResult = "10.0";
        assertEquals(expResult,result);
    }
    
    //@Test
    public void testResolveOperacionesWithParentesisNested(){
        System.out.println("testResolveOperacionesWithParentesisNested");
        String expression = "((2*x+5*x+9*x)*(9*x+90))^2";
        Expression instance = new Expression(expression,4,"x");
        String result = instance.resolverExpresion();
        String expResult ="65028096.0";
        assertEquals(expResult,result);//Escribe con notación cientifica :c
    }
    
    @Test
    public void testResolveOperacionesWithParentesisNestedSmallNumber(){
        System.out.println("testResolveOperacionesWithParentesisNested");
        String expression = "((2*x+1)-(3*x+2))^2";
        Expression instance = new Expression(expression,2,"x");
        String result = instance.resolverExpresion();
        String expResult ="9.0";
        assertEquals(expResult,result);
    }
    
    @Test
    public void testResolveOperacionesWithParentesisNestedNegative(){
        System.out.println("testResolveOperacionesWithParentesisNestedNegative");
        String expression = "((-2*x+1)-(3*x+2))^2";
        Expression instance = new Expression(expression,2,"x");
        String result = instance.resolverExpresion();
        String expResult ="121.0";
        assertEquals(expResult,result);
    }
    
    
    public void testResolveOperacionesWithParentesis(){
        System.out.println("testResolveOperaciones");
        String expression = "(2*x)+(1*3*x)";
        Expression instance = new Expression(expression,2,"x");
        String result = instance.resolverExpresion();
        String expResult = "10.0";
        assertEquals(expResult,result);
    }
    
    

    @Test
    public void testIsValidExpressionWithParentesisMissingClose() {
        System.out.println("testIsValidExpressionWithParentesisMissingClose");
        String prev = "";
        Expression instance = new Expression("(2x+3)+(5x-9)", 2, "");
        boolean expResult = false;
        boolean result = instance.isValidExpression("((2x-1)*(x+2)/((5x+9)*22)/5x");
        assertEquals(expResult, result);
    }
    

    @Test
    public void testIsValidExpressionWithParentesisMissingOpen() {
        System.out.println("testIsValidExpressionWithParentesisMissingOpen");
        String prev = "";
        Expression instance = new Expression("(2x+3)+(5x-9)", 2, "");
        boolean expResult = false;
        boolean result = instance.isValidExpression("(2x+5)+(2x^2))");
        assertEquals(expResult, result);
    }

    @Test
    public void testIsValidExpressionWithParentesisInverted() {
        System.out.println("testIsValidExpressionWithParentesisInverted");
        String prev = "";
        Expression instance = new Expression(")2x+3(+)5x-9(", 2, "");
        boolean expResult = false;
        boolean result = instance.isValidExpression(")2x+3(+)5x-9(");
        assertEquals(expResult, result);
    }

}
