package sales.domain.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class CustomerClassification {

	@Id
	private String name;
		
	public CustomerClassification(String name){
		this.name = name;
	}
	
	public String getName(){
		return name;
	}
}
