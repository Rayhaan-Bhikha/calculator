package rayhaanbhikha.calculator;

public class Main {

    public static void main(String[] args) {
        Calculator calculate = new Calculator(true);
        System.out.println("Answer: " + calculate.evaluateExpression("(15+10)%"));
    }
}