package sales.main.model;
import static org.apache.commons.lang.Validate.*;

public class Customer {

	private String name;
	private String email;
	private String contactNumber;
	private String contactPerson;
	private CustomerClassification classification;

	public Customer(String name, String contactPerson, CustomerClassification classification) {
		notEmpty(name);
		notEmpty(contactPerson);
		this.name = name;
		this.contactPerson = contactPerson;
		this.classification = classification;
	}
	
	public Customer(String name, String contactPerson, String email, String contactNumber, CustomerClassification classification){
		this(name, contactPerson, classification);
		this.email=email;
		this.contactNumber=contactNumber;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}

	public String getName() {
		return name;
	}

	public String getEmail() {
		return email;
	}

	public String getContactNumber() {
		return contactNumber;
	}

	public String getContactPerson() {
		return contactPerson;
	}

	public CustomerClassification getClassification() {
		return classification;
	}
	
	

}
