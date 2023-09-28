package ch.bbw.addressbook;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.MockitoAnnotations;

import java.util.List;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

class AddressDAO_MemoryTest {

    private AddressDAO_Memory addressDAO;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        addressDAO = new AddressDAO_Memory();
    }

    @Test
    void testCreateAndRead() {
        Address address = new Address(1, "John", "Doe", "1234567890");
        addressDAO.create(address);

        Address retrievedAddress = addressDAO.read(1);

        assertEquals(address, retrievedAddress);
    }

    @Test
    void testReadAll() {
        Address address1 = new Address(1, "John", "Doe", "1234567890");
        Address address2 = new Address(2, "Jane", "Smith", "9876543210");

        addressDAO.create(address1);
        addressDAO.create(address2);

        List<Address> addresses = addressDAO.readAll();

        assertEquals(2, addresses.size());
        assertTrue(addresses.contains(address1));
        assertTrue(addresses.contains(address2));
    }

    @Test
    void testUpdate() {
        Address address = new Address(1, "John", "Doe", "1234567890");
        addressDAO.create(address);

        Address updatedAddress = new Address(1, "Updated", "Name", "5555555555");
        addressDAO.update(updatedAddress);

        Address retrievedAddress = addressDAO.read(1);

        assertEquals(updatedAddress, retrievedAddress);
    }

    @Test
    void testDelete() {
        Address address = new Address(1, "John", "Doe", "1234567890");
        addressDAO.create(address);

        addressDAO.delete(1);

        assertThrows(IndexOutOfBoundsException.class, () -> addressDAO.read(1));
    }

    @Test
    void testIsAvailable() {
        assertFalse(addressDAO.isAvailable());
    }

    @Test
    void testGetUniqueId() {
        assertEquals(0, addressDAO.getUniqueId());
    }
}
