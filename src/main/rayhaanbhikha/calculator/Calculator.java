package rayhaanbhikha.calculator;

public class Calculator {

    private Boolean verbose = false;
    private UserInput userInput;
    private ShuntingYard sy;
    private ReducePostFix rp;

    public Calculator(){}

    public Calculator(Boolean verbose) {
        this.verbose = verbose;
    }

    public String evaluateExpression(String input) {
        userInput = new UserInput(input);
        sy = new ShuntingYard(userInput.getFilteredInput());

        if(verbose) {
            userInput.printParsedUserInput();
            sy.printPostFixInput();
        }


        rp = new ReducePostFix(sy.getPostFixInput());

        return rp.getFinalAnswer();
    }
}
