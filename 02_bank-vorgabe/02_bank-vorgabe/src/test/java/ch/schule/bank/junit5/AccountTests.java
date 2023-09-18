package ch.schule.bank.junit5;

import ch.schule.Account;
import ch.schule.Booking;
import ch.schule.SalaryAccount;
import ch.schule.SavingsAccount;
import org.junit.jupiter.api.Test;


import java.util.TreeMap;

import static org.junit.jupiter.api.Assertions.*;


/**
 * Tests für die Klasse Account.
 *
 * @author ainhoa
 * @version 1.0
 */
public class AccountTests {
    /**
     * Tested die Initialisierung eines Kontos.
     */
    @Test
    public void testInit() {
        Account account = new SavingsAccount("1");
        assertNotNull(account);
        assertEquals("1", account.getId());
        assertEquals(0, account.getBalance());
    }

    /**
     * Testet das Einzahlen auf ein Konto.
     */
    @Test
    public void testDeposit() {
        Account account = new SavingsAccount("2");
        boolean result = account.deposit(20230917, 50000); // Beispiel-Datum und Betrag
        assertTrue(result);
        assertEquals(50000, account.getBalance());
    }

    /**
     * Testet das Abheben von einem Konto.
     */
    @Test
    public void testWithdraw() {
        Account account = new SalaryAccount("3", -1000);
        boolean depositResult = account.deposit(20230917, 50000); // Beispiel-Datum und Betrag
        assertTrue(depositResult);
        assertEquals(50000, account.getBalance());
        boolean withdrawResult = account.withdraw(20230918, 30000); // Beispiel-Datum und Betrag
        assertTrue(withdrawResult);
        assertEquals(20000, account.getBalance());
    }

    /**
     * Tests the reference from SavingsAccount
     */
    /*
    @Test
    public void testReferences() {
        SavingsAccount savingsAccount = new SavingsAccount("4");
        Booking booking = savingsAccount.getBooking();

        assertNotNull(booking, "Booking should not be null");
    }
*/

    /**
     * teste the canTransact Flag
     */
    @Test
    public void testCanTransact() {
        Account account = new SalaryAccount("5", -1000);
        assertTrue(account.canTransact(20230917));
        account.deposit(20230917, 50000);
        assertTrue(account.canTransact(20230918));
        account.withdraw(20230919, 30000);
        assertTrue(account.canTransact(20230920));
    }

    /**
     * Experimente mit print().
     */
    @Test
    public void testPrint() {
        Account account = new SavingsAccount("6");
        account.deposit(20230917, 50000);
        account.withdraw(20230918, 30000);
        account.print();
    }

    /**
     * Experimente mit print(year,month).
     */
    @Test
    public void testMonthlyPrint() {
        Account account = new SalaryAccount("P-1007", -1000);
        account.deposit(20230917, 50000);
    }

}
