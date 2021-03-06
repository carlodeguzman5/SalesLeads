package sales.interfaces;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import sales.domain.model.ContactPerson;
import sales.domain.model.Customer;
import sales.domain.model.CustomerClassification;
import sales.domain.model.CustomerInquiry;
import sales.domain.model.Event;
import sales.domain.model.Inquiry;
import sales.domain.model.Notification;
import sales.infrastructure.jpa.NoExistingInquiryException;

public interface SalesService {
	
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
	
	public void addContactPersonToCustomer(Customer customer, String name, String email, String contactNumber);

	public String validateUser(String username, String password);

	public List<Notification> getNotifications();

	public void createUser(String username, String password);

	public List<CustomerInquiry> getLeadsByStatus(String string);

	public Collection<ContactPerson> getContactPersonsOf(Customer customer);

	public Collection<CustomerClassification> getAllCustomerClassifications();

	public void updateNotification(CustomerInquiry customerInquiry);

	public void customizeNotification(CustomerInquiry customerInquiry, String amount, String unit);

	public void updateLeadStatus(CustomerInquiry customerInquiry, String status);

	public Collection<CustomerInquiry> getInquiriesByCustomer(String company);

	public void updateCustomer(String editContactPersonName, String editEmail,
			String editContactNumber);

	public void editContactPerson(String customerName,
			String editContactPersonName, String contactEmail,
			String contactNumber, String editEmail, String editContactNumber);

	public Collection<Inquiry> getAllInquiriesbyCount();

}
