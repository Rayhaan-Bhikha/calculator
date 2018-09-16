# Calculator
Calculator written in Java which takes a string and computes an answer by implementing the shunting yard algorithm and using reverse polish notation.

```java
Calculator calculator = new Calculator();
    
calculator calculator = new Calculator(true); // verbose option
```

To obtain the evaluated expression call the following method:

```java
calculate.evaluateExpression(expression); // expression is type String 
```

Example
---

```java
Calculator calculate = new Calculator();

calculate.evaluateExpression("((15/(7-(1+1)))*3)−(2+(1+1))"); // Answer 5.0
```