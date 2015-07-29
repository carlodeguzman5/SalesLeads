package sales.domain.model;

public interface ContactPersonRepository {
	void editContactPerson(String customerName, String editContactPersonName, String contactEmail, String contactNumber, String editEmail, String editContactNumber);
}
