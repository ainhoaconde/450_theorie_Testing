import org.example.Calculator;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

public class CalculatorTest {

    @Test
    public void testAdd() {
        // Create an instance of Calculator
        Calculator calculator = new Calculator();

        // Perform the addition operation
        double result = calculator.add(5.0, 3.0);

        // Assert that the result is equal to 8.0 with a delta of 0.001 for floating-point comparisons
        assertEquals(8.0, result, 0.001);
    }

    @Test
    public void testSubtract() {
        // Create an instance of Calculator
        Calculator calculator = new Calculator();

        // Perform the subtraction operation
        double result = calculator.subtract(5.0, 3.0);

        // Assert that the result is equal to 2.0 with a delta of 0.001 for floating-point comparisons
        assertEquals(2.0, result, 0.001);
    }

    @Test
    public void testMultiply() {
        // Create an instance of Calculator
        Calculator calculator = new Calculator();

        // Perform the multiplication operation
        double result = calculator.multiply(5.0, 3.0);

        // Assert that the result is equal to 15.0 with a delta of 0.001 for floating-point comparisons
        assertEquals(15.0, result, 0.001);
    }

    @Test
    public void testDivide() {
        // Create an instance of Calculator
        Calculator calculator = new Calculator();

        // Perform the division operation
        double result = calculator.divide(10.0, 2.0);

        // Assert that the result is equal to 5.0 with a delta of 0.001 for floating-point comparisons
        assertEquals(5.0, result, 0.001);
    }

    @Test
    public void testDivideByZero() {
        // Create an instance of Calculator
        Calculator calculator = new Calculator();

        try {
            // Attempt to divide by zero, expecting an IllegalArgumentException
            double result = calculator.divide(5.0, 0.0);

            // If no exception is thrown, fail the test with a message
            fail("Expected IllegalArgumentException, but no exception was thrown.");
        } catch (IllegalArgumentException e) {
            // Expected exception, no further action needed
        }
    }
}
