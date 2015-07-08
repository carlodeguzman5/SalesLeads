package sales.domain.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="CUSTOMER_CLASSIFICATION")
public class CustomerClassification {

	@Id
	private String name;
	
	public CustomerClassification() {}
		
	public CustomerClassification(String name){
		this.name = name;
	}
	
	public String getName(){
		return name;
	}
}
