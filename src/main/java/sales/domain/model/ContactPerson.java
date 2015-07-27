package sales.domain.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class ContactPerson {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	private String name;
	private String contactNumber;
	private String email;
	@ManyToOne(cascade=CascadeType.ALL)
	private Customer customer;
		
	protected ContactPerson(){/*AS NEEDED BY JPA*/}
	public ContactPerson(String name, String email, String contactNumber, Customer customer) {
		this.name = name;
		this.email = email;
		this.contactNumber = contactNumber;
		this.customer = customer;
	}
	public long getId() {
		return id;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}
	public String getName() {
		return name;
	}
	public String getContactNumber() {
		return contactNumber;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	public Customer getCustomer(){
		return customer;
	}
	
	public void setCustomer(Customer customer){
		this.customer = customer;
	}
	

}
