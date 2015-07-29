package sales.domain.model;

import java.util.ArrayList;
import java.util.Collection;

public interface CustomerRepository {

	Customer findByCustomerName(String name);
	Customer createCustomer(String name, String contactPerson, String contactNumber, String email, CustomerClassification classification);
	Collection<Customer> getAllCustomers();
	ArrayList<CustomerInquiry> getAllCustomerInquiries();
	void createCustomerClassification(String name);
	Customer getCustomer(String name);
	CustomerClassification getCustomerClassification(String name);
	Collection<CustomerClassification> getAllCustomerClassifications();
//	void updateCustomer(String customerName, String contactNumber, String contactPerson, String email, String customerClassification);
	Collection<ContactPerson> getAllContactPersons(Customer customer);
	void addContactPersonToCustomer(Customer customer, String name, String email, String contactNumber);
	void updateCustomer(String name, String email, String contactNumber);
}
