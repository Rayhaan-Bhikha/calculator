package com.pluralsight.calculator;

import java.util.ArrayList;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
//        String testInput = "((((1*(2+3))-3)+4)*5)";
//        String testInput1 = "3+4*2/(1-5)^2^3";
        String testInput2 = "((15/(7−(1+1)))*3)−(2+(1+1))";
        UserInput input = new UserInput(testInput2);

        ShuntingYard sy = new ShuntingYard(input.getFilteredInput());
        ReducePostFix rp = new ReducePostFix(sy.getPostFixInput());
        System.out.println("ANSWER IS: " + rp.getFinalAnswer());
    }








}
