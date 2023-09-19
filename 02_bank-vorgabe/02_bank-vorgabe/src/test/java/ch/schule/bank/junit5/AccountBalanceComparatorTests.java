package ch.schule.bank.junit5;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Tests für die AccountBalanceComparator-Klasse.
 */
public class AccountBalanceComparatorTests {
    private AccountBalanceComparator comparator;

    @BeforeEach
    public void setUp() {
        // Initialisiere den Comparator vor jedem Test
        comparator = new AccountBalanceComparator();
    }

    @Test
    public void testCompare() {
        // Erzeuge zwei Test-Accounts mit unterschiedlichen Kontoständen
        Account account1 = new Account("A-1001");
        Account account2 = new Account("A-1002");
        account1.deposit(20221001, 10000); // Einzahlung von 10000 Millirappen
        account2.deposit(20221001, 5000); // Einzahlung von 5000 Millirappen

        // Vergleiche die beiden Accounts mithilfe des Comparators
        int result = comparator.compare(account1, account2);

        // Überprüfe, ob das Ergebnis des Vergleichs korrekt ist
        assertFalse(result > 0); // account1 sollte einen höheren Kontostand haben als account2
    }
}
