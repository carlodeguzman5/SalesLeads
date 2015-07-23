package sales.interfaces;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

import sales.domain.model.Customer;
import sales.domain.model.CustomerClassification;
import sales.domain.model.CustomerInquiry;
import sales.domain.model.Event;
import sales.domain.model.Inquiry;
import sales.infrastructure.jpa.NoExistingInquiryException;

public interface SalesServiceFacade {
	
	public ArrayList<CustomerInquiry> getAllCustomerInquiries();
	
	public void createCustomer(String name, String contactPerson, String email, String contactNumber, CustomerClassification classification);

	public void createInquiry(String type);

	public Inquiry findInquiry(String string) throws NoExistingInquiryException;

	public void createCustomerClassification(String string);

	public CustomerClassification findCustomerClassification(String name);
	
	public Customer findCustomer(String name);

	public Collection<Customer> getAllCustomers();
	
	public Collection<Inquiry> getAllInquiries();
	
	public void createCustomerInquiry(Customer customer, Inquiry inquiry, String subject, String message);

	public Event createEvent(String title, String content, Date date);
	
	public void appendEvent(CustomerInquiry customerInquiry, Event event);
	
	public Event getLastEventOf(CustomerInquiry customerInquiry);
	
	public void updateCustomer(String customerName, String contactNumber, String contactPerson, String email, String customerClassification);

	public Collection<Event> getAllEventsOf(CustomerInquiry customerInquiry);
	
	public CustomerInquiry getCustomerInquiry(String companyName, String inquiryName, String subject,
			String content);
	
	public String getStatus(CustomerInquiry customerInquiry);

}
