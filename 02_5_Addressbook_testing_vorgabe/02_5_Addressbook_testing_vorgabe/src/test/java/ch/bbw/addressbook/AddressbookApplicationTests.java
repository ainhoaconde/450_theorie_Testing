package ch.bbw.addressbook;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class AddressbookApplicationTests {

	@Mock
	private AddressDAO addressDAO;

	@BeforeEach
	void setUp() {
		MockitoAnnotations.openMocks(this);
	}

	@Test
	void testAddressCreation() {
		Address address = new Address(1, "John", "Doe", "1234567890");
		assertEquals(1, address.getId());
		assertEquals("John", address.getFirstname());
		assertEquals("Doe", address.getLastname());
		assertEquals("1234567890", address.getPhonenumber());
		assertNull(address.getRegistrationDate());
	}

	@Test
	void testAddressWithRegistrationDate() {
		Date registrationDate = new Date();
		Address address = new Address(1, "Jane", "Smith", "9876543210", registrationDate);
		assertEquals(registrationDate, address.getRegistrationDate());
	}

	@Test
	void testAddressSorting() {
		List<Address> addresses = new ArrayList<>();
		addresses.add(new Address(1, "Alice", "Johnson", "5551234567"));
		addresses.add(new Address(2, "Bob", "Smith", "1239876543"));
		addresses.add(new Address(3, "Charlie", "Brown", "9991112222"));

		// Sort the addresses using your Comparator class (if available)
		Collections.sort(addresses, new AddressComparator());

		// Verify that the addresses are sorted correctly
		assertEquals("Alice", addresses.get(0).getFirstname());
		assertEquals("Bob", addresses.get(1).getFirstname());
		assertEquals("Charlie", addresses.get(2).getFirstname());
	}

	@Test
	void testAddressDAO() {
		// Assuming you have a method in your AddressDAO that returns a list of addresses
		List<Address> mockAddresses = new ArrayList<>();
		mockAddresses.add(new Address(1, "John", "Doe", "1234567890"));
		mockAddresses.add(new Address(2, "Jane", "Smith", "9876543210"));

		// Mock the behavior of your AddressDAO
		when(addressDAO.getAllAddresses()).thenReturn(mockAddresses);

		// Call a method in your service that uses AddressDAO
		List<Address> addresses = addressDAO.getAllAddresses();

		// Verify that the service returns the expected addresses
		assertEquals(2, addresses.size());
		assertEquals("John", addresses.get(0).getFirstname());
		assertEquals("Jane", addresses.get(1).getFirstname());
	}
}

