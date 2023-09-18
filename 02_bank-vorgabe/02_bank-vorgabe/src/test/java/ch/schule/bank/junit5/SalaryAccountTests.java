package ch.schule.bank.junit5;

import ch.schule.SalaryAccount;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Tests der Klasse SalaryAccount.
 *
 * @author Ainhoa
 * @version 1.1
 */
public class SalaryAccountTests
{
	/**
	 * Testet die Einzahlungsfunktion eines SalaryAccounts.
	 */
	@Test
	public void testDeposit()
	{
		SalaryAccount account = new SalaryAccount("1",100);


		account.deposit(20211114,1000);


		assertEquals(1000.0, account.getBalance(), 0.01);
	}

	/**
	 * Testet die Abhebungsfunktion eines SalaryAccounts.
	 */
	@Test
	public void testWithdraw()
	{
		SalaryAccount account = new SalaryAccount("2",100);


		account.deposit(20211114,1000);


		account.withdraw(20211114,500);


		assertEquals(500.0, account.getBalance(), 0.01);
	}
}
