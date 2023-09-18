package ch.schule.bank.junit5;

import ch.schule.BankUtils;
import ch.schule.Booking;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;


/**
 * Tests für die Klasse Booking.
 *
 * @author Luigi Cavuoti
 * @version 1.1
 */
public class BookingTests {
	/**
	 * Tests fuer die Erzeugung von Buchungen.
	 */
	@Test
	public void testInitialization() {
		int date = 20221119;
		long amount = 1232423;
		Booking booking = new Booking(date, amount);
		assertEquals(date, booking.getDate());
		assertEquals(amount, booking.getAmount());
	}

	/**
	 * Experimente mit print().
	 */
	@Test
	public void testPrint() {
		int date = 20221022;
		long amount = 56564;
		long balance = 100000;

		Booking booking = new Booking(date, amount);
		booking.print(balance);
	}
}