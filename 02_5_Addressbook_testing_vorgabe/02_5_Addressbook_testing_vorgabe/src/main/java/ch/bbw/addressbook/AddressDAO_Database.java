package ch.bbw.addressbook;

import org.springframework.stereotype.Repository;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Repository
public class AddressDAO_Database implements AddressDAO {

	private Connection connection; // TODO: to be replaced by connection pool

	@PostConstruct
	void init() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://localhost/AddressBook","root","");
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	@PreDestroy
	void destroy() {
		try {
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}


	@Override
	public boolean isAvailable() {
		// software test
		return false;
	}

	@Override
	public int getUniqueId() {
		return 4007;
	}

	// CRUD Commands: Create Read Update Delete
	/* (non-Javadoc)
	 * @see ch.bbw.addressbook.AddressDAOInterface#create(ch.bbw.addressbook.Address)
	 */
//	@Override
	public void create(Address address) {
		try {
			PreparedStatement stmt = connection.prepareStatement("INSERT INTO address (firstname, lastname, phonenumber, registrationDate) VALUES (?, ?, ?, ?)");
			stmt.setString(1, address.getFirstname());
			stmt.setString(2, address.getLastname());
			stmt.setString(3, address.getPhonenumber());
			stmt.setDate(4, new java.sql.Date(address.getRegistrationDate().getTime())); // Convert Java Date to SQL Date

			int rowsInserted = stmt.executeUpdate();
			if (rowsInserted != 1) {
				throw new IllegalStateException("Create operation inserted " + rowsInserted + " rows instead of 1.");
			}

			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public Address read(int id) {
		try {
			PreparedStatement stmt = connection.prepareStatement("SELECT * FROM address WHERE id = ?");
			stmt.setInt(1, id);
			ResultSet result = stmt.executeQuery();

			if (result.next()) {
				return new Address(
						result.getInt("id"),
						result.getString("firstname"),
						result.getString("lastname"),
						result.getString("phonenumber"),
						result.getDate("registrationDate")
				);
			}
			return null;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}


	/* (non-Javadoc)
	 * @see ch.bbw.addressbook.AddressDAOInterface#readAll()
	 */
//	@Override
	public List<Address> readAll() {
		List<Address> list = new ArrayList<>();
		try {
			Statement stmt = connection.createStatement();
			ResultSet entries = stmt.executeQuery("SELECT * FROM address");
			while (entries.next()) {
				list.add(new Address(
						entries.getInt("id"), entries.getString("firstname"),
						entries.getString("lastname"), entries.getString("phonenumber"),
						entries.getDate("registrationDate")));
			}
			entries.close();
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	/* (non-Javadoc)
	 * @see ch.bbw.addressbook.AddressDAOInterface#update(ch.bbw.addressbook.Address)
	 */
//	@Override
	public void update(Address address) {
		try {
			PreparedStatement stmt = connection.prepareStatement("UPDATE address SET firstname=?, lastname=?, phonenumber=?, registrationDate=? WHERE id=?");
			stmt.setString(1, address.getFirstname());
			stmt.setString(2, address.getLastname());
			stmt.setString(3, address.getPhonenumber());
			stmt.setDate(4, new java.sql.Date(address.getRegistrationDate().getTime())); // Convert Java Date to SQL Date
			stmt.setInt(5, address.getId());

			int rowsUpdated = stmt.executeUpdate();
			if (rowsUpdated != 1) {
				throw new IllegalStateException("Update operation affected " + rowsUpdated + " rows instead of 1.");
			}

			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void delete(int id) {
		try {
			PreparedStatement stmt = connection.prepareStatement("DELETE FROM address WHERE id=?");
			stmt.setInt(1, id);

			int rowsDeleted = stmt.executeUpdate();
			if (rowsDeleted != 1) {
				throw new IllegalStateException("Delete operation affected " + rowsDeleted + " rows instead of 1.");
			}

			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}


}
