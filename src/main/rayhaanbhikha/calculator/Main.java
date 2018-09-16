package rayhaanbhikha.calculator;

public class Main {

    public static void main(String[] args) {
        Calculator calculate = new Calculator("30%+5+6*40*15%");
        System.out.println(calculate.getAnswer());
    }
}