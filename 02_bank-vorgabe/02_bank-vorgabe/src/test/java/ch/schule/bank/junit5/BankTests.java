package ch.schule.bank.junit5;

import ch.schule.Bank;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


/**
 * Tests f�r die Klasse 'Bank'.
 *
 * @author ainhoa
 * @version 1.0
 */
public class BankTests {
    private Bank bank;

    @BeforeEach
    public void setUp() {
        bank = new Bank();
    }
    /**
     * Tests to create new Accounts
     */
    @Test
    public void testCreate() {
        String savingsAccount = bank.createSavingsAccount();
        assertNotNull(savingsAccount);
        assertTrue(bank.getBalance(savingsAccount) == 0);
        String promoYouthSavingsAccount = bank.createPromoYouthSavingsAccount();
        assertNotNull(promoYouthSavingsAccount);
        assertTrue(bank.getBalance(promoYouthSavingsAccount) == 0);
        String salaryAccount = bank.createSalaryAccount(-5000);
        assertNotNull(salaryAccount);
        assertTrue(bank.getBalance(salaryAccount) == 0);
        String invalidSalaryAccount = bank.createSalaryAccount(5000);
        assertNull(invalidSalaryAccount);
    }
    /**
     * Testet das Einzahlen auf ein Konto.
     */
    @Test
    public void testDeposit() {
        String account = bank.createSavingsAccount();
        assertTrue(bank.deposit(account, 20230917, 10000));
        assertEquals(10000, bank.getBalance(account));
        assertFalse(bank.deposit("invalidAccount", 20230917, 5000));
    }

    /**
     * Testet das Abheben von einem Konto.
     */
    @Test
    public void testWithdraw() {
        String account = bank.createSavingsAccount();
        assertTrue(bank.deposit(account, 20230917, 10000));

        assertTrue(bank.withdraw(account, 20230918, 5000));
        assertEquals(5000, bank.getBalance(account));

        assertFalse(bank.withdraw(account, 20230919, 10000));
        assertEquals(5000, bank.getBalance(account));

        assertFalse(bank.withdraw("invalidAccount", 20230920, 1000));
    }

    /**
     * Experimente mit print().
     */
    @Test
    public void testPrint() {
        String accountId = bank.createSavingsAccount();
        bank.deposit(accountId, 20230917, 10000);
        bank.print(accountId);
    }

    /**
     * Experimente mit print(year, month).
     */
    @Test
    public void testMonthlyPrint() {

        String accountId = bank.createSavingsAccount();
        bank.deposit(accountId, 20230917, 10000);
        bank.print(accountId, 2023, 9);
    }

    /**
     * Testet den Gesamtkontostand der Bank.
     */
    @Test
    public void testBalance() {
        Bank bank = new Bank();
        String accountId1 = bank.createSavingsAccount();
        String accountId2 = bank.createPromoYouthSavingsAccount();
        String accountId3 = bank.createSalaryAccount(-1000);

        bank.deposit(accountId1, 20230917, 10000);
        bank.deposit(accountId2, 20230917, 15000);
        bank.deposit(accountId3, 20230917, 5000);

        long totalBalance = bank.getBalance();
        assertEquals(-30150, totalBalance);
    }
    /**
     * Tested die Ausgabe der "top 5" konten.
     */
    @Test
    public void testTop5() {
    bank.deposit("1",20230917,500000);
    bank.deposit("2",20230916,504218);
    bank.deposit("3",20230717,45467);
    bank.deposit("4",20230217,65487);
    bank.deposit("4",20230317,4531);
    bank.deposit("5",20230910,45493);
    bank.deposit("6",20230916,24632231);
    bank.deposit("7",20221114,242552);
    bank.deposit("8",20230917,415522);

    bank.printTop5();
    }

    /**
     * Tested die Ausgabe der "top 5" konten.
     */
    @Test
    public void testBottom5() {
        bank.deposit("1",20230917,500000);
        bank.deposit("2",20230916,504218);
        bank.deposit("3",20230717,45467);
        bank.deposit("4",20230217,65487);
        bank.deposit("4",20230317,4531);
        bank.deposit("5",20230910,45493);
        bank.deposit("6",20230916,24632231);
        bank.deposit("7",20221114,242552);
        bank.deposit("8",20230917,415522);

        bank.printBottom5();
    }

}
