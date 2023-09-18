package ch.schule.bank.junit5;

import ch.schule.PromoYouthSavingsAccount;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

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
}
