package rayhaanbhikha.calculator;


import static org.junit.Assert.*;
import org.junit.Test;

public class CalculatorTest {

    private Calculator calculator = new Calculator(true);

    @Test
    public void evaluateExpression(){
        String input = "(10)%";
        assertEquals("0.1", calculator.evaluateExpression(input));
    }

    @Test
    public void evaluateExpression0(){
        String input = "(15+10)%";
        assertEquals("0.25", calculator.evaluateExpression(input));
    }

    @Test
    public void evaluateExpression1(){
        String input = "3+4*2/(1-5)^2^3";
        assertEquals("3.0001220703125", calculator.evaluateExpression(input));
    }

    @Test
    public void evaluateExpression2(){
        String input = "(15%)+100";
        assertEquals("100.15", calculator.evaluateExpression(input));
    }

    @Test
    public void evaluateExpression3(){
        String input = "45 + (15%)";
        assertEquals("45.15", calculator.evaluateExpression(input));
    }

    @Test
    public void evaluateExpression4(){
        String input = "50+6*40/15%";
        assertEquals("1650.0", calculator.evaluateExpression(input));
    }

    @Test
    public void evaluateExpression5(){
        String input = "50+6*40*(20+15%)";
        assertEquals("5570.0", calculator.evaluateExpression(input));
    }

    @Test
    public void evaluateExpression6(){
        String input = "45 + (15% + 20)";
        assertEquals("65.15", calculator.evaluateExpression(input));
    }

    @Test
    public void evaluateExpression7(){
        String input = "((((1*(2+3))-3)+4)*5)";
        assertEquals("30.0", calculator.evaluateExpression(input));
    }

    @Test
    public void evaluateExpression8(){
        String input = "((15/(7-(1+1)))*3+15%)−(2+(1+1))";
        assertEquals("6.35", calculator.evaluateExpression(input));
    }

    @Test
    public void evaluateExpression9(){
        String input = "30%+5+6*40*15%";
        assertEquals("41.3", calculator.evaluateExpression(input));
    }

    @Test
    public void evaluateExpression10(){
        String input = "((15/(7-(5^7)))*3*15%)−(2+(1+1))";
        assertEquals("-4.000086407742134", calculator.evaluateExpression(input));
    }




}
