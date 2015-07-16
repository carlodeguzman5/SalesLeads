package sales.domain.model;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="CUSTOMER_CLASSIFICATION")
public class CustomerClassification implements Serializable{

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CustomerClassification other = (CustomerClassification) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}


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
