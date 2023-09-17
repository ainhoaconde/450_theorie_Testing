package org.example;

public class Main {

    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        double sum = calculator.add(10.0, 5.0);
        System.out.println("+ result: " + sum);
        double difference = calculator.subtract(10.0, 5.0);
        System.out.println("- result: " + difference);
        double product = calculator.multiply(10.0, 5.0);
        System.out.println("* result: " + product);
        try {
            double quotient = calculator.divide(10.0, 5.0);
            System.out.println(": result: " + quotient);
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
