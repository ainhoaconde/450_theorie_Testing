package org.example;

public class PriceCalculator {

    public static double calculatePrice(double baseprice, double specialprice, double extraprice, int extras, double discount) {
        double addon_discount = 0.0;

        if (extras >= 3) {
            addon_discount = 10;
        } else if (extras >= 5) {
            addon_discount = 15;
        }

        addon_discount = Math.max(addon_discount, discount);

        double result = (baseprice / 100 * (100 - discount)) + specialprice + (extraprice / 100 * (100 - addon_discount));

        return result;
    }
}


