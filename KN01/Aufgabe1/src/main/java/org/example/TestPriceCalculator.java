package org.example;

import org.example.PriceCalculator;

public class TestPriceCalculator {

    public static boolean testCalculatePrice() {
        boolean test_ok = true;

        // Definiere Testdaten
        double baseprice = 1000.0;
        double specialprice = 200.0;
        double extraprice = 50.0;
        int extras = 4;
        double discount = 10.0;

        // Erwartetes Ergebnis: (1000 / 100 * (100 - 12)) + 200 + (50 / 100 * (100 - 10))
        double expected_result = (baseprice / 100 * (100 - discount)) + specialprice + (extraprice / 100 * (100 - 10));

        // Erzeuge eine Instanz der PriceCalculator-Klasse
        PriceCalculator priceCalculator = new PriceCalculator();

        // Berechne den Preis mithilfe der PriceCalculator-Methode
        double calculated_result = priceCalculator.calculatePrice(baseprice, specialprice, extraprice, extras, discount);

        // Überprüfe, ob das berechnete Ergebnis genau mit dem erwarteten Ergebnis übereinstimmt
        if (calculated_result != expected_result) {
            System.out.println("Test failed: Calculated result doesn't match the expected result.");
            test_ok = false;
        } else {
            System.out.println("Test passed: Calculated result matches the expected result.");
        }

        // Gib den Teststatus zurück
        return test_ok;
    }

}
