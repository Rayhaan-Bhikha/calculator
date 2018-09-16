package rayhaanbhikha.calculator;

public class Main {

    public static void main(String[] args) {
        Calculator calculate = new Calculator(true);
        System.out.println(calculate.evaluateExpression("30%+5+6*40*15%"));
    }
}