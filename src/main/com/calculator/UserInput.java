package com.calculator;

import java.util.ArrayList;

public class UserInput {
    
    private ArrayList<Object> filteredInput;
    private String input;

    public UserInput(String input) {
        this.input = input;
        this.filterInput(input);
    }

    public void filterInput(String input) {
        filteredInput = new ArrayList<>();
        String accum = "";
        for(int i=0; i<input.length(); i++) {
            char currentInput = input.charAt(i);
            switch(currentInput) {
                case '0': case '1': case '2':
                case '3': case '4': case '5':
                case '6': case '7': case '8':
                case '9':
                    accum += currentInput;
                    break;
                case '%':
                    /**
                     * by this point the filteredInput array list should have
                     * string char string
                     * */
//                    computePercentage()
                    if(filteredInput.size() > 1 && filteredInput.get(filteredInput.size() - 1) instanceof Character && (Character) filteredInput.get(filteredInput.size() - 1) == '(') {
                        System.out.println("Bracket exists: "+  filteredInput.get(filteredInput.size() - 1) + accum + currentInput);
//                        15 %
                        accum = Double.toString(Double.parseDouble(accum)/100);
                    } else {
                        accum += currentInput;
                    }
                    break;
                case ' ':
                    break;
                default:
                    /* if it's an operand or bracket
                        then add accum to filtered input
                        and make accum empty.*/
                    filteredInput.add(accum);
                    accum = "";
                    filteredInput.add(currentInput); // add operand on it's own
                    break;
            }
        }
        filteredInput.add(accum);
        filteredInput.removeIf(i -> i.equals("")); // remove all empty string in Arraylist
    }

    public ArrayList<Object> getFilteredInput() {
        return filteredInput;
    }

    public void printParsedUserInput(){
        for(Object i: filteredInput) {
            System.out.print(i.toString() + " ");
        }
        System.out.println(" ");
    }


    public void printParsedUserInputAndType(){
        for(Object i: filteredInput) {
            System.out.println(i.toString() + "\t " + i.getClass());
        }
        System.out.println(" ");
    }
}
