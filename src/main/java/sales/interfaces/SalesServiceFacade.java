package sales.interfaces;

import java.util.Collection;

import sales.domain.model.Customer;
import sales.domain.model.CustomerClassification;
import sales.domain.model.CustomerInquiry;
import sales.domain.model.Inquiry;

public interface SalesServiceFacade {
	
	public void inquireOldCustomer(String customer, String inquiry);
	
	public Collection<Inquiry> findAllByCustomer(String name);
	
	public void createCustomer(String name, String contactPerson, String email, String contactNumber, CustomerClassification classification);

	public void createInquiry(String type);

	public Inquiry findInquiry(String string);

	public void createCustomerClassification(String string);

	public CustomerClassification findCustomerClassification(String name);


}
