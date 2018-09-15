package com.pluralsight.calculator;

public enum Operand {
    POWER(4, 'R', '^'),
    MULTIPLY(3,'L', '*'),
    DIVIDE(3,'L', '/'),
    ADD(2,'L', '+'),
    SUBTRACT(2,'L', '-');

    private final int pred;
    private final char assoc;
    private final char mappedChar;

    Operand(int pred, char assoc, char mappedChar){
        this.pred = pred;
        this.assoc = assoc;
        this.mappedChar = mappedChar;
    }

    public int getPred() {
        return pred;
    }

    public char getAssoc() {
        return assoc;
    }

    public char getMappedChar() {
        return mappedChar;
    }

    public static Operand getOperand(Character operand) {
        Operand op;
        switch(operand) {
            case '+':
                 op = ADD;
                 break;
            case '-':
                op = SUBTRACT;
                break;
            case '/':
                op = DIVIDE;
                break;
            case '*':
                op = MULTIPLY;
                break;
            case '^':
                op = POWER;
                break;
            default:
                op=null;
                break;
        }
        return op;
    }

    public void printInfo() {
        System.out.println("ASSOC -> " + this.getMappedChar() + " " + this.getPred() + " " + getAssoc());
    }
}
