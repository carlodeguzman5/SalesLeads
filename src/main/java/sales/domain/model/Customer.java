package sales.domain.model;
import static org.apache.commons.lang3.Validate.notEmpty;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="CUSTOMER_T")
public class Customer {

	@Id
	private long id;
	@Column(name="NAME")
	private String name;
	@Column(name="EMAIL")
	private String email;
	@Column(name="CONTACT_NUMBER")
	private String contactNumber;
	@Column(name="CONTACT_PERSON")
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
