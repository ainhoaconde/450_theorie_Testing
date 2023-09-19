package ch.schule.bank.junit5;

import ch.schule.bank.junit5.PromoYouthSavingsAccount;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Tests für das Promo-Jugend-Sparkonto.
 *
 * @author ainhoa
 * @version 1.0
 */
public class PromoYouthSavingsAccountTests
{
	/**
	 * Der Test.
	 */
	@Test
	public void test()
	{
		PromoYouthSavingsAccount account = new PromoYouthSavingsAccount("1");
		account.deposit(20221221, 100);
		account.withdraw(20221221, 50);

		double balance = account.getBalance();
		assertEquals(51.0, balance, 0.01);
	}
	@Test
	public void testDeposit() {
		PromoYouthSavingsAccount account = new PromoYouthSavingsAccount("PYSA-123");

		// Einzahlung von 100 CHF sollte 1% Bonus (1 CHF) haben
		boolean result = account.deposit(20230917, 10000); // 100 CHF in Rappen
		assertTrue(result);
		assertEquals(10100, account.getBalance()); // 100 CHF + 1 CHF Bonus

		// Einzahlung von 500 CHF sollte 5% Bonus (25 CHF) haben
		result = account.deposit(20230918, 50000); // 500 CHF in Rappen
		assertTrue(result);
		assertEquals(60600, account.getBalance()); // 500 CHF + 25 CHF Bonus
	}

	@Test
	public void testNegativeDeposit() {
		PromoYouthSavingsAccount account = new PromoYouthSavingsAccount("PYSA-456");

		// Eine negative Einzahlung sollte fehlschlagen
		boolean result = account.deposit(20230919, -100); // Negativer Betrag
		assertFalse(result);
		assertEquals(0, account.getBalance()); // Das Konto sollte unverändert sein
	}
}
