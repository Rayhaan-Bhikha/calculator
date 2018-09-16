package rayhaanbhikha.calculator;

public class Calculator {

    public Calculator() {}

    public String evaluateExpression(String input) {

        UserInput userInput = new UserInput(input);

        ShuntingYard sy = new ShuntingYard(userInput.getFilteredInput());

        ReducePostFix rp = new ReducePostFix(sy.getPostFixInput());

        return rp.getFinalAnswer();
    }
}
