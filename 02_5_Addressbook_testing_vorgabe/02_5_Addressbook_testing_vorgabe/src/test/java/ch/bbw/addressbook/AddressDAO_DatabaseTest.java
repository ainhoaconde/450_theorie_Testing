package ch.bbw.addressbook;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class AddressDAO_DatabaseTest {

    private AddressDAO_Database addressDAO;

    @BeforeEach
    void setUp() {
        addressDAO = new AddressDAO_Database();
        addressDAO.init(); // Initialisieren Sie die Datenbankverbindung
    }

    @AfterEach
    void tearDown() {
        addressDAO.destroy(); // Schließen Sie die Datenbankverbindung
    }

    @Test
    void testCreateAndRead() {
        Address address = new Address(0, "John", "Doe", "1234567890");
        addressDAO.create(address);

        Address retrievedAddress = addressDAO.read(address.getId());

        assertNotNull(retrievedAddress);
        assertEquals(address.getId(), retrievedAddress.getId());
        assertEquals(address.getFirstname(), retrievedAddress.getFirstname());
        assertEquals(address.getLastname(), retrievedAddress.getLastname());
        assertEquals(address.getPhonenumber(), retrievedAddress.getPhonenumber());
    }

    @Test
    void testReadAll() {
        // Vorhandene Adressen aus der Datenbank lesen
        List<Address> existingAddresses = addressDAO.readAll();

        // Hier fügen Sie einige Adressen hinzu
        Address address1 = new Address(0, "John", "Doe", "1234567890");
        Address address2 = new Address(0, "Jane", "Smith", "9876543210");

        addressDAO.create(address1);
        addressDAO.create(address2);

        // Nachdem Sie einige Adressen hinzugefügt haben, überprüfen Sie, ob die Anzahl der gelesenen Adressen
        // mit der Anzahl der hinzugefügten Adressen übereinstimmt.
        List<Address> updatedAddresses = addressDAO.readAll();

        assertEquals(existingAddresses.size() + 2, updatedAddresses.size()); // Da zwei Adressen hinzugefügt wurden
    }


    @Test
    void testUpdate() {
        Address address = new Address(0, "Jane", "Smith", "9876543210");
        addressDAO.create(address);

        // Änderungen an der Adresse vornehmen
        address.setFirstname("UpdatedFirstName");
        address.setLastname("UpdatedLastName");
        address.setPhonenumber("UpdatedPhoneNumber");

        // Adresse aktualisieren
        addressDAO.update(address);

        // Die Adresse aus der Datenbank erneut abrufen und sicherstellen, dass sie aktualisiert wurde
        Address updatedAddress = addressDAO.read(address.getId());

        assertNotNull(updatedAddress);
        assertEquals("UpdatedFirstName", updatedAddress.getFirstname());
        assertEquals("UpdatedLastName", updatedAddress.getLastname());
        assertEquals("UpdatedPhoneNumber", updatedAddress.getPhonenumber());
    }

    @Test
    void testCreate() {
        // Erstellen Sie eine Testadresse
        Address address = new Address(0, "John", "Doe", "555-123-4567");
        address.setRegistrationDate(new Date()); // Setzen Sie ein gültiges Datum

        // Versuchen Sie, die Adresse in die Datenbank einzufügen
        addressDAO.create(address);

        // Lesen Sie die Adresse aus der Datenbank, um sicherzustellen, dass sie erfolgreich eingefügt wurde
        Address retrievedAddress = addressDAO.read(address.getId());

        // Überprüfen Sie, ob die zurückgegebene Adresse nicht null ist
        assertNotNull(retrievedAddress);

        // Überprüfen Sie, ob die zurückgegebene Adresse die gleichen Werte wie die erstellte Adresse hat
        assertEquals(address.getFirstname(), retrievedAddress.getFirstname());
        assertEquals(address.getLastname(), retrievedAddress.getLastname());
        assertEquals(address.getPhonenumber(), retrievedAddress.getPhonenumber());
        assertEquals(address.getRegistrationDate(), retrievedAddress.getRegistrationDate());
    }
}
