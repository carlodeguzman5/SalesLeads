package sales.interfaces;

import sales.domain.model.Customer;
import sales.domain.model.Inquiry;

public interface SalesServiceFacade {
	
	public void inquire(Customer customer, Inquiry inquiry);
	
	public void findAllByCustomer(Customer customer, Inquiry inquiry);

	

}
