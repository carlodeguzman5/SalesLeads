package sales.domain.model;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

@Entity
public class CustomerClassification implements Serializable{

	@Id
	private String name;
	@OneToMany
	@JoinColumn(name="classification_fk")
	private Set<Customer> customers;
	
	public CustomerClassification() {/* AS NEEDED BY JPA */}
		
	public CustomerClassification(String name){
		this.name = name;
	}
	
	public String getName(){
		return name;
	}
	
	
	public Set<Customer> getCustomers(){
		return customers;
	}
}
