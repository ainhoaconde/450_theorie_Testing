package org.example;


import static org.example.TestPriceCalculator.testCalculatePrice;

public class Main {

    public static void main(String[] args) {
        boolean test_result = testCalculatePrice();
        if (test_result) {
            System.out.println("All tests passed.");
        } else {
            System.out.println("Some tests failed.");
        }
    }
}
