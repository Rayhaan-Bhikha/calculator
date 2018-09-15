package com.calculator;


import static org.junit.Assert.*;

import jdk.jfr.Description;
import org.junit.Test;

public class CalculatorTest {

    @Description("Testing: without percentage")
    @Test
    public void evaluateExpression1(){
        String input = "3+4*2/(1-5)^2^3";
        Calculator calculator = new Calculator(input);
        assertEquals(calculator.getAnswer(), "3.0001220703125");
    }


    @Description("Testing: without percentage")
    @Test
    public void evaluateExpression2(){
        String input = "(15%)+100";
        Calculator calculator = new Calculator(input);
        assertEquals(calculator.getAnswer(), "100.15");
    }


}
