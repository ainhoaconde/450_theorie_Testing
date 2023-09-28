package ch.bbw.addressbook;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class AddressViewControllerTest {

    @Mock
    private AddressService addressService;

    private AddressViewController addressViewController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        addressService = mock(AddressService.class); // Mock the AddressService
        addressViewController = new AddressViewController();
        addressViewController.setAddressService(addressService); // Set the mock in the controller
    }


    @Test
    void testSaveAddress() {
        // Create a mock Address object
        Address mockAddress = new Address(1, "John", "Doe", "1234567890");

        // Set the input values in the controller
        addressViewController.setFirstname(mockAddress.getFirstname());
        addressViewController.setLastname(mockAddress.getLastname());
        addressViewController.setPhoneNumber(mockAddress.getPhonenumber());

        // Mock the registerAddress method in AddressService
        doNothing().when(addressService).registerAddress(any(Address.class));

        // Call the method under test
        addressViewController.saveAddress();

        // Verify that the registerAddress method is called with the expected Address object
        verify(addressService, times(1)).registerAddress(argThat(address ->
                address.getFirstname().equals(mockAddress.getFirstname()) &&
                        address.getLastname().equals(mockAddress.getLastname()) &&
                        address.getPhonenumber().equals(mockAddress.getPhonenumber())
        ));

        // Verify that the controller's fields are cleared
        assertEquals("", addressViewController.getFirstname());
        assertEquals("", addressViewController.getLastname());
        assertEquals("", addressViewController.getPhoneNumber());
    }

    @Test
    void testGetAddresses() {
        // Create a list of mock addresses
        List<Address> mockAddresses = new ArrayList<>();
        mockAddresses.add(new Address(1, "John", "Doe", "1234567890"));
        mockAddresses.add(new Address(2, "Jane", "Smith", "9876543210"));

        // Mock the getAllAddresses method in AddressService
        when(addressService.getAllAddresses()).thenReturn(mockAddresses);

        // Call the method under test
        List<Address> addresses = addressViewController.getAddresses();

        // Verify that the returned list of addresses matches the mockAddresses
        assertEquals(mockAddresses, addresses);
    }
}
