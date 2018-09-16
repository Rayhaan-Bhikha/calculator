package rayhaanbhikha.calculator;

public class Main {

    public static void main(String[] args) {
        Calculator calculate = new Calculator();
        System.out.println("Answer: " + calculate.evaluateExpression("((15/(7-(1+1)))*3)−(2+(1+1))"));
    }
}