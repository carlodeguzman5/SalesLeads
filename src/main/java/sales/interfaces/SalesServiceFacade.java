package sales.interfaces;

import java.util.Collection;
import java.util.Date;

import sales.domain.model.Customer;
import sales.domain.model.CustomerClassification;
import sales.domain.model.CustomerInquiry;
import sales.domain.model.Inquiry;
import sales.infrastructure.jpa.NoExistingInquiryException;

public interface SalesServiceFacade {
	
	public Collection<CustomerInquiry> getAllCustomerInquiries();
	
	public void createCustomer(String name, String contactPerson, String email, String contactNumber, CustomerClassification classification);

	public void createInquiry(String type);

	public Inquiry findInquiry(String string) throws NoExistingInquiryException;

	public void createCustomerClassification(String string);

	public CustomerClassification findCustomerClassification(String name);
	
	public Customer findCustomer(String name);

	public Collection<Customer> getAllCustomers();
	
	public Collection<Inquiry> getAllInquiries();
	
	public void createCustomerInquiry(Customer customer, Inquiry inquiry, String subject, String message);


}
