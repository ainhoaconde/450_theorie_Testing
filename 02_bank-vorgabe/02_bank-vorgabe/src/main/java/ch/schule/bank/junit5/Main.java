package ch.schule.bank.junit5;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// eine Bank instanzieren
		Bank ubs = new Bank();
		
		ubs.createPromoYouthSavingsAccount();
		ubs.createSalaryAccount(12000);
		
		// Wie kann man verhindern, dass man nur ein Bank Objekt erstellen kann?
		

	}

}
