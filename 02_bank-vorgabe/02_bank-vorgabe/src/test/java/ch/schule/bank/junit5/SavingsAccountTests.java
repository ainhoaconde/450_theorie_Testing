package ch.schule.bank.junit5;

import ch.schule.bank.junit5.SavingsAccount;

/**
 * Tests f�r die Klasse SavingsAccount.
 *
 * @author Roger H. J&ouml;rg
 * @version 1.0
 */

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


/**
 * Tests für die Klasse SavingsAccount.
 *
 * @author XXX
 * @version 1.0
 */
public class SavingsAccountTests
{
	@Test
	public void testInitialBalance()
	{
		SavingsAccount account = new SavingsAccount("1");
		assertEquals(1000, account.getBalance(), 1000);	}
	@Test
	public void testDeposit()
	{
		SavingsAccount account = new SavingsAccount("2");
		account.deposit(20230917,500);
		assertEquals(500, account.getBalance(), 500);
	}
	@Test
	public void testWithdraw()
	{
		SavingsAccount account = new SavingsAccount("3");
		account.withdraw(20200123,300);
		assertEquals(300, account.getBalance(), 300);
	}
	@Test
	public void testWithdrawInsufficientFunds()
	{
		SavingsAccount account = new SavingsAccount("4");
		boolean result = account.withdraw(20230911,500);
		assertFalse(result);
		assertEquals(500, account.getBalance(), 500);
	}
	@Test
	public void testWithdrawWithinCreditLimit() {
		SalaryAccount account = new SalaryAccount("1",4000);
		int date = 20221001; // Ein beliebiges Datum
		long initialBalance = account.getBalance();
		long amountToWithdraw = 0;// Betrag innerhalb des Kreditlimits

		boolean result = account.withdraw(date, amountToWithdraw);

		// Überprüfe, ob die Abhebung erfolgreich war (true zurückgegeben wurde)
		assertFalse(result);

		// Überprüfe, ob der Kontostand nach der Abhebung korrekt aktualisiert wurde
		assertEquals(initialBalance - amountToWithdraw, account.getBalance());
	}

}

