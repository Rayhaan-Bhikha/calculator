package com.calculator;

public class Calculator {

    private UserInput userInput;
    private ShuntingYard sy;
    private ReducePostFix rp;
    private String answer;

    public Calculator(String input) {
        this.userInput = new UserInput(input);
        sy = new ShuntingYard(userInput.getFilteredInput());
        rp = new ReducePostFix(sy.getPostFixInput());
        answer = rp.getFinalAnswer();
    }

    public String getAnswer() {
        return answer;
    }
}
