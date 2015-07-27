package sales.domain.model;
import static org.apache.commons.lang3.Validate.notEmpty;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="CUSTOMER_T")
public class Customer implements Serializable{

	@Id
	@Column(name="NAME")
	private String name;

	@OneToMany(cascade=CascadeType.ALL)
	private Set<ContactPerson> contactPersons;
	
	@Column(name="CUSTOMER_CLASSIFICATION",length=1000)
	private CustomerClassification classification;
	
	@OneToMany(cascade=CascadeType.ALL)
	@JoinColumn(name="INQUIRIES_PER_CUSTOMER")
	private Set<CustomerInquiry> inquries;

	protected Customer(){/*AS NEEDED BY JPA*/}
	
	public Customer(String name, CustomerClassification classification) {
		notEmpty(name);
		this.name = name;
		this.classification = classification;
	}

	public CustomerClassification getClassification() {
		return classification;
	}

	public void setClassification(CustomerClassification classification) {
		this.classification = classification;
	}
	
	public String getName() {
		return name;
	}
	
	public Set<CustomerInquiry> getInquries() {
		return inquries;
	}

	public void setInquries(Set<CustomerInquiry> inquries) {
		this.inquries = inquries;
	}

	@ManyToOne
	@JoinColumn(name="classification_fk", insertable=true, updatable=true)
	public CustomerClassification getCustomerClassification() {
		return classification;
	}
	
	public Set<ContactPerson> getContactPersons(){
		return contactPersons;
	}
}
