package com.calculator;

import java.util.ArrayList;
import java.util.Collections;

public class ShuntingYard {

    private ArrayList<Object> input;
    private ArrayList<Character> operatorStack = new ArrayList<>(); // can only be operands which have been explicitly set to type character
    private ArrayList<Object> outputStack = new ArrayList<>();
    private ArrayList<Object> postFixInput = new ArrayList<>();

    public ShuntingYard(ArrayList<Object> input) {
        this.input = input;
        implementAlgo();
    }

    public void implementAlgo() {
        for(Object i : input) {
            if(i instanceof Character) {
                /**
                 * if input is a character then it is either an
                 * operand or '(' / ')'
                 * in which case we need to figure out if we are going to put it to operator stack
                 * but before doing so we have to make the necessary checks.
                 * */
                decideWhatToDoWithOperator((Character) i);
            } else {
                /**
                 *
                 * if input is a string then it has to be a number
                 * and should be added to output stack.
                 * */
                outputStack.add(i);
            }
        }

        Collections.reverse(operatorStack);
        postFixInput.addAll(outputStack);
        postFixInput.addAll(operatorStack);
    }

    public boolean decideWhatToDoWithOperator(Character i) {

        // if operand is left bracket just add to operator stack.
        if(i == '(') {
            operatorStack.add(i);
            return true;
        }

        if(i == ')') {
            while(getTopOfOperatorStack() != '(') {
                outputStack.add(getTopOfOperatorStack());
                operatorStack.remove(operatorStack.size() - 1);
            }
            operatorStack.remove(operatorStack.size() - 1);
            return true;
        }

        Operand currentOperand = Operand.getOperand(i); // current operator in loop.
        if(operatorStack.isEmpty()) { // check if operator stack is empty
            operatorStack.add(i);
            return true;
        }

        // if operator on top of stack is left bracket just add.
        if(getTopOfOperatorStack() == '(') {
            operatorStack.add(i);
            return true;
        }
        Operand operandTopOfStack = Operand.getOperand(getTopOfOperatorStack()); // operator on top of operator stack

        /**
         * 1)
         *      if operand precedence is higher than the precedence of current operator on top of stack
         *
         *      or
         *
         *      operand is '(' i.e. left opening bracket // now covered with the one above
         *
         *
         *      or
         *
         *      operator precedence is equal but operand assoc is 'R'
         *
         *      then just add to operator stack.
         *
         * */

        if(currentOperand.getPred() > operandTopOfStack.getPred() ||
                (currentOperand.getPred() == operandTopOfStack.getPred() && currentOperand.getAssoc() == 'R'))
        {
            operatorStack.add(i);
            return true;
        }


        /**
         *
         * 2)
         *      if operator precedence is lower than the precedence of the operator currently on top of the operator stack
         *
         *      or
         *
         *      operator precedence is equal but assoc of current operand is 'L'
         *
         *      remove operator from top of stack and add to outputstack.
         *
         * */

        if(currentOperand.getPred() < operandTopOfStack.getPred() ||
                (currentOperand.getPred() == operandTopOfStack.getPred() && currentOperand.getAssoc() == 'L')){

            outputStack.add(getTopOfOperatorStack()); // add element on top of operator stack to output stack
            operatorStack.remove(operatorStack.size() - 1); // remove element from top of stack.
            operatorStack.add(i);
            return true;
        }


        /**
         * 3)
         *
         *      if operand is ')' i.e. right closing bracket
         *
         *      then recursivley add every operator on the stack starting from the top until you come across '('
         *
         *      then remove this final operand and stop.
         *
         * */


        /**
         *  at this point add the remaing operator stack to the end of the output stack.
         *
         *
         * */
        return true;
    }

    public ArrayList<Object> getPostFixInput() {
        return postFixInput;
    }

    private Character getTopOfOperatorStack() {
        return operatorStack.get(operatorStack.size()-1);
    }

    public String toString() {
        String output = "";
        for(Object i: input){
            output += i.toString() + " ";
        }
        return output;
    }

    public void printOperatorStack() {
        for(Character i: operatorStack) {
            System.out.print(i.toString() + " ");
        }
    }

    public void printOutputStack() {
        for(Object i: outputStack) {
            System.out.print(i.toString() + " ");
        }
    }

    public void printPostFixInput() {
        for(Object i: postFixInput) {
            System.out.print(i.toString() + " ");
        }
    }

    public void printPostFixInputAndType() {
        for(Object i: postFixInput) {
            System.out.println(i.toString() + "\t " + i.getClass());
        }
    }
}
