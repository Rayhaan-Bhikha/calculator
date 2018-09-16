package com.calculator;


import static org.junit.Assert.*;

import jdk.jfr.Description;
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
        assertEquals("40.15", calculator.getAnswer());
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



}
