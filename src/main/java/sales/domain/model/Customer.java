package sales.domain.model;
import static org.apache.commons.lang3.Validate.notEmpty;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
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
	@Column(name="CUSTOMER_CLASSIFICATION")
	private CustomerClassification classification;
	
	@OneToMany(cascade=CascadeType.ALL)
	@JoinColumn(name="INQUIRIES_PER_CUSTOMER")
	private Set<CustomerInquiry> inquries;

	protected Customer(){/*AS NEEDED BY JPA*/}
	
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
	
	@ManyToOne
	@JoinColumn(name="classification_fk", insertable=true, updatable=true)
	public CustomerClassification getCustomerClassification() {
		return classification;
	}
	/*
	public Collection getInquiries(){
		return inquries;
	}*/

	@Override
	public String toString() {
		return "Customer [name=" + name + ", email=" + email
				+ ", contactNumber=" + contactNumber + ", contactPerson="
				+ contactPerson + ", classification=" + classification
				+ ", inquries=" + inquries + "]";
	}
	
	

}
