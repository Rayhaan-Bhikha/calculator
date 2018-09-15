package com.pluralsight.calculator;

import java.util.ArrayList;

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
        double numOne = Double.parseDouble(num1);
        double numTwo = Double.parseDouble(num2);
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

    public void printList() {
        for(Object i: input) {
            System.out.print(i.toString() + " ");
        }
        System.out.println(" ");
    }
}
