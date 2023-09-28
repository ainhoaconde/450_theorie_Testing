package ch.bbw.addressbook;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class AddressServiceTests {

    private AddressService addressService;
    private AddressDAO mockAddressDAO;

    @BeforeEach
    void setUp() {
        // Create a mock implementation of AddressDAO
        mockAddressDAO = mock(AddressDAO.class);

        // Create an instance of AddressService with the mock AddressDAO
        addressService = new AddressService(mockAddressDAO);
    }

    @Test
    void testGetAllAddresses() {
        // Mock implementation for mockAddressDAO.readAll()
        List<Address> mockAddresses = new ArrayList<>();
        mockAddresses.add(new Address(1, "John", "Doe", "1234567890"));
        mockAddresses.add(new Address(2, "Jane", "Smith", "9876543210"));

        when(mockAddressDAO.readAll()).thenReturn(mockAddresses);

        // Call the method under test
        List<Address> addresses = addressService.getAllAddresses();

        // Assertions
        assertEquals(2, addresses.size());
        assertEquals("John", addresses.get(0).getFirstname());
        assertEquals("Jane", addresses.get(1).getFirstname());
    }

    @Test
    void testRegisterAddress() {
        // Create an Address object
        Address address = new Address(1, "John", "Doe", "1234567890");
        Date currentDate = new Date();

        // Call the method under test
        addressService.registerAddress(address);

        // Assertions
        assertEquals(currentDate, address.getRegistrationDate());

        // Verify that the create method in mockAddressDAO is called once
        verify(mockAddressDAO, times(1)).create(address);
    }

    @Test
    void testQuery() {
        // Mock implementation for mockAddressDAO.isAvailable()
        when(mockAddressDAO.isAvailable()).thenReturn(true);

        // Call the method under test
        boolean result = addressService.query("query");

        // Assertion
        assertTrue(result);
    }

    @Test
    void testToString() {
        // Mock implementation for mockAddressDAO.getUniqueId()
        when(mockAddressDAO.getUniqueId()).thenReturn(123);

        // Call the method under test
        String result = addressService.toString();

        // Assertion
        assertEquals("Using database with id: 123", result);
    }
}

