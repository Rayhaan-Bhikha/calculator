package rayhaanbhikha.calculator;


import static org.junit.Assert.*;
import org.junit.Test;

public class CalculatorTest {

    @Test
    public void evaluateExpression1(){
        String input = "3+4*2/(1-5)^2^3";
        Calculator calculator = new Calculator(input);
        assertEquals("3.0001220703125", calculator.getAnswer());
    }

    @Test
    public void evaluateExpression2(){
        String input = "(15%)+100";
        Calculator calculator = new Calculator(input);
        assertEquals("100.15", calculator.getAnswer());
    }

    @Test
    public void evaluateExpression3(){
        String input = "45 + (15%)";
        Calculator calculator = new Calculator(input);
        assertEquals("45.15", calculator.getAnswer());
    }

    @Test
    public void evaluateExpression4(){
        String input = "50+6*40/15%";
        Calculator calculator = new Calculator(input);
        assertEquals("1650.0", calculator.getAnswer());
    }

    @Test
    public void evaluateExpression5(){
        String input = "50+6*40*(20+15%)";
        Calculator calculator = new Calculator(input);
        assertEquals("5570.0", calculator.getAnswer());
    }

    @Test
    public void evaluateExpression6(){
        String input = "45 + (15% + 20)";
        Calculator calculator = new Calculator(input);
        assertEquals("65.15", calculator.getAnswer());
    }

    @Test
    public void evaluateExpression7(){
        String input = "((((1*(2+3))-3)+4)*5)";
        Calculator calculator = new Calculator(input);
        assertEquals("30.0", calculator.getAnswer());
    }

    @Test
    public void evaluateExpression8(){
        String input = "((15/(7-(1+1)))*3+15%)−(2+(1+1))";
        Calculator calculator = new Calculator(input);
        assertEquals("6.35", calculator.getAnswer());
    }

    @Test
    public void evaluateExpression9(){
        String input = "30%+5+6*40*15%";
        Calculator calculator = new Calculator(input);
        assertEquals("41.3", calculator.getAnswer());
    }

    @Test
    public void evaluateExpression10(){
        String input = "((15/(7-(5^7)))*3*15%)−(2+(1+1))";
        Calculator calculator = new Calculator(input);
        assertEquals("-4.000086407742134", calculator.getAnswer());
    }




}
