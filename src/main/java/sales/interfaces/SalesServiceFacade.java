package sales.interfaces;

import sales.domain.model.Customer;
import sales.domain.model.Inquiry;

public interface SalesServiceFacade {
	
	public void inquire(String customer, String inquiry);
	
	public void findAllByCustomer(Customer customer);

	

}
