package sales.domain.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class InquiryType {

	@Id
	private String name;
	
	protected InquiryType(){}
	
	public InquiryType(String name){
		this.name = name;
	}
	
	public String getName(){
		return name;
	}
	
}
