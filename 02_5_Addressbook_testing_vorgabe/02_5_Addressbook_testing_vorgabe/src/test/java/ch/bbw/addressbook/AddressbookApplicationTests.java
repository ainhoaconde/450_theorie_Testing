package ch.bbw.addressbook;

import ch.bbw.addressbook.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
@SpringBootTest
class AddressbookApplicationTests {

	// Mock-Implementierung für den AddressDAO
	@MockBean
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
	void testAddressSorting() {
		List<Address> addresses = new ArrayList<>();
		addresses.add(new Address(1, "Alice", "Johnson", "5551234567"));
		addresses.add(new Address(2, "Bob", "Smith", "1239876543"));
		addresses.add(new Address(3, "Charlie", "Brown", "9991112222"));

		// Sort the addresses by lastname
		Collections.sort(addresses, (a1, a2) -> a1.getLastname().compareTo(a2.getLastname()));

		assertEquals("Alice", addresses.get(0).getFirstname());
		assertEquals("Bob", addresses.get(1).getFirstname());
		assertEquals("Charlie", addresses.get(2).getFirstname());
	}

	@Test
	void testAddressDAO() {
		List<Address> mockAddresses = new ArrayList<>();
		mockAddresses.add(new Address(1, "John", "Doe", "1234567890"));
		mockAddresses.add(new Address(2, "Jane", "Smith", "9876543210"));

		when(addressDAO.readAll()).thenReturn(mockAddresses);

		List<Address> addresses = addressDAO.readAll();

		assertEquals(2, addresses.size());
		assertEquals("John", addresses.get(0).getFirstname());
		assertEquals("Jane", addresses.get(1).getFirstname());
	}
}
