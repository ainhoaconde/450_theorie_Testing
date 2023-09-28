package ch.bbw.addressbook;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class AddressDAO_Memory implements AddressDAO {
		
	private List<Address> addresses = new ArrayList<>();

	@Override
	public boolean isAvailable() {
		return false;
	}

	@Override
	public int getUniqueId() {
		return 0;
	}

	// CRUD Commands: Create Read Update Delete
	public void create(Address address) {
		address.setId(addresses.size()+1);
		addresses.add(address);
	}
	
	public Address read(int id) {
		return addresses.get(id-1);
	}
	public List<Address> readAll() {
		return addresses;
	}

	public void update(Address address) {
		for (int i = 0; i < addresses.size(); i++) {
			if (addresses.get(i).getId() == address.getId()) {
				addresses.set(i, address);
				return;
			}
		}
		throw new IllegalArgumentException("Address not found for ID: " + address.getId());
	}

	public void delete(int id) {
		for (int i = 0; i < addresses.size(); i++) {
			if (addresses.get(i).getId() == id) {
				addresses.remove(i);
				return;
			}
		}
		throw new IllegalArgumentException("Address not found for ID: " + id);
	}

}
