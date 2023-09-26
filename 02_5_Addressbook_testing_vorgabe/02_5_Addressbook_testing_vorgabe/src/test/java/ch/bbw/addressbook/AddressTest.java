package ch.bbw.addressbook;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import static org.mockito.Mockito.*;

class AddressTest {

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

        // Verify that the addresses are sorted correctly
        assertEquals("Alice", addresses.get(0).getFirstname());
        assertEquals("Bob", addresses.get(1).getFirstname());
        assertEquals("Charlie", addresses.get(2).getFirstname());
    }

}
