package com.calculator;

public class Main {

    public static void main(String[] args) {
        String testInput = "((((1*(2+3))-3)+4)*5)";
        String testInput1 = "3+4*2/(1-5)^2^3";
        String testInput2 = "((15/(7−(1+1)))*3+15%)−(2+(1+1))";
        String testInput3 = "30%+5+6*40*15%";
        String testInput4 = "((15/(7−(1+1)))*3*15%)−(2+(1+1))";

        Calculator calculate = new Calculator(testInput2);
        System.out.println(calculate.getAnswer());


    }








}
