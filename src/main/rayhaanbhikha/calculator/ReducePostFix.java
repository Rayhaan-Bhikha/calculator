package rayhaanbhikha.calculator;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ReducePostFix {
    private ArrayList<Object> input;
    private String finalAnswer;
    private Boolean verbose;
    private int counter = 1;

    public ReducePostFix(ArrayList<Object> input) {
        this(input, false);
    }

    public ReducePostFix(ArrayList<Object> input, Boolean verbose) {
        this.input = input;
        this.verbose = verbose;
        reducePostFix();
    }

    public String getFinalAnswer() {
        return finalAnswer;
    }

    private void reducePostFix(){
        if(input.size() == 1) {
            if(checkIfPercentage((String) input.get(0)) != null) {
                finalAnswer = Double.toString(Double.parseDouble(checkIfPercentage((String) input.get(0)))/100);
            } else {
                finalAnswer = (String) input.get(0);
            }
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
                if(verbose) {
                    printList(counter);
                    counter++;
                }
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

    public String calculateWithoutPercentage(double numOne, double numTwo, char operand) {
        double result = 0.00;
        switch(operand) {
            case '+':
                result = numOne + numTwo;
                break;
            case '-': case 8722:// instead of - as it doesn't work for some reason
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


    public String calculateWithPercentage(double numOne, double numTwo, Character operand) {
        double result = 0.00;
        switch(operand) {
            case '+':
                result = numOne + ((numTwo/100)* numOne);
                break;
            case '-': case 8722:// instead of - as it doesn't work for some reason
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

    public void printList(int index) {
        System.out.print(index + ": ");
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
            return m.group(1); // represents the number group 0 = '15%' and group 2 = '%';
        }
        return null;
    }
}
