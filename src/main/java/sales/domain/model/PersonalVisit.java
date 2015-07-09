package sales.domain.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class PersonalVisit extends Inquiry {

	@Id
	private long id;
	
	private String visitorName;
	private String subject;
//	private String 
	
	public PersonalVisit(){}
	
}
