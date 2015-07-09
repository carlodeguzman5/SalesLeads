package sales.domain.model;
import static org.apache.commons.lang3.Validate.notEmpty;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="CUSTOMER_T")
public class Customer {

	@Id
	@Column(name="NAME")
	private String name;
	@Column(name="EMAIL")
	private String email;
	@Column(name="CONTACT_NUMBER")
	private String contactNumber;
	@Column(name="CONTACT_PERSON")
	private String contactPerson;
	@Column(name="CLASSIFICATION")
	private String classification;
	@ManyToMany
	@JoinTable(
			name="CUSTOMER_INQUIRY",
			joinColumns={@JoinColumn(name="customer_id", referencedColumnName="name")},
			inverseJoinColumns={@JoinColumn(name="inquiry_type", referencedColumnName="name")}
	)
	private Set<Inquiry> inquries;

	protected Customer(){/*AS NEEDED BY JPA*/}
	
	public Customer(String name, String contactPerson, CustomerClassification classification) {
		notEmpty(name);
		notEmpty(contactPerson);
		this.name = name;
		this.contactPerson = contactPerson;
		this.classification = classification.getName();
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

	public String getClassification() {
		return classification;
	}
	
	

}
