package ch.schule.bank.junit5;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Tests für die BankUtils-Klasse.
 */
public class BankUtilsTests {

    @Test
    public void testFormatBankDate() {
        String formattedDate = BankUtils.formatBankDate(0);
        assertEquals("01.01.1970", formattedDate);

        formattedDate = BankUtils.formatBankDate(360);
        assertEquals("01.01.1971", formattedDate);

        formattedDate = BankUtils.formatBankDate(365);
        assertEquals("06.01.1971", formattedDate);
    }

    @Test
    public void testFormatAmount() {

        String formattedAmount = BankUtils.formatAmount(500000);
        assertFalse(formattedAmount.contains("5.000,00"));

        formattedAmount = BankUtils.formatAmount(123456789);
        assertFalse(formattedAmount.contains("1.234.567,89"));

        formattedAmount = BankUtils.formatAmount(100);
        assertFalse(formattedAmount.contains("1,00"));
    }
}
