package com.calculator;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ReducePostFix {
    private ArrayList<Object> input;
    private String finalAnswer;

    public ReducePostFix(ArrayList<Object> input) {
        this.input = input;
        reducePostFix();
    }

    public String getFinalAnswer() {
        return finalAnswer;
    }

    private void reducePostFix(){
        if(input.size() == 1) {
            finalAnswer = (String) input.get(0);
            return;
        }
        for(int i=0; i<input.size(); i++){
            // ge the first operand.
            if(input.get(i) instanceof Character) {
                // then there should be at least two numbers before this item in the array list.
                String item1 = (String) input.get(i-2);
                String item2 = (String) input.get(i-1);
                char operand = (Character) input.get(i);
                input.set(i-2, computeValue(item1, item2, operand));
                input.remove(i-1);
                input.remove(i-1);
                printList();
                reducePostFix();
                break;
            }
        }
    }

    private String computeValue(String num1, String num2, char operand) {
        double numOne;
        String percentageValue1 = checkIfPercentage(num1);
        String percentageValue2 = checkIfPercentage(num2);
        if( percentageValue1 != null) {
            numOne = Double.parseDouble(percentageValue1)/100;
        } else {
            numOne = Double.parseDouble(num1);
        }

        if( percentageValue2 != null) {
            double numTwo = Double.parseDouble(percentageValue2);
            return calculateWithPercentage(numOne, numTwo, operand);
        } else {
            double numTwo = Double.parseDouble(num2);
            return calculateWithoutPercentage(numOne, numTwo, operand);
        }
    }

    private String calculateWithoutPercentage(double numOne, double numTwo, char operand) {
        double result = 0.00;
        switch(operand) {
            case '+':
                result = numOne + numTwo;
                break;
            case 8722: // instead of - as it doesn't work for some reason
                result = numOne - numTwo;
                break;
            case '/':
                result = numOne / numTwo;
                break;
            case '*':
                result = numOne * numTwo;
                break;
            case '^':
                result = Math.pow(numOne, numTwo);
                break;
        }
        return Double.toString(result);
    }


    private String calculateWithPercentage(double numOne, double numTwo, char operand) {
        double result = 0.00;
        if(operand == '-') {
            System.out.println("hello");
        }
        switch(operand) {
            case '+':
                result = numOne + ((numTwo/100)* numOne);
                break;
            case 8722: // instead of - as it doesn't work for some reason
                result = numOne - ((numTwo/100)* numOne);
                break;
            case '*':
                result = (numTwo/100) * numOne;
                break;
            case '/':
                result = (100/numTwo) * numOne;
                break;
        }
        return Double.toString(result);
    }

    public void printList() {
        for(Object i: input) {
            System.out.print(i.toString() + " ");
        }
        System.out.println(" ");
    }

    private String checkIfPercentage(String number){
        String pattern = "([0-9]+)([%])";

        Pattern r = Pattern.compile(pattern);

        Matcher m = r.matcher(number);

        if(m.find()){
//            System.out.println(m.groupCount());
//            System.out.println(m.group(0));
            System.out.println(m.group(1));
            return m.group(1);
        }
        return null;
    }
}
