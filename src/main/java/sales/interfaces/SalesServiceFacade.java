package sales.interfaces;

import sales.domain.model.Customer;
import sales.domain.model.CustomerClassification;
import sales.domain.model.Inquiry;

public interface SalesServiceFacade {
	
	public void inquireOldCustomer(String customer, String inquiry);
	
	public void findAllByCustomer(String name);
	
	public void createCustomer(String name, String contactPerson, String email, String contactNumber, CustomerClassification classification);

	

}
