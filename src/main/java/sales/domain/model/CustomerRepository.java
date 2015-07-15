package sales.domain.model;

import java.util.Collection;
import java.util.Date;
import java.util.List;

public interface CustomerRepository {

	Customer findByCustomerName(String name);
	void createCustomer(String name, String contactPerson, String contactNumber, String email, CustomerClassification classification);
	void inquire(Customer customer, Inquiry inquiry, Date date);
	Collection<Customer> getAllCustomers();
	Collection<CustomerInquiry> getAllCustomerInquiries();
	void createCustomerClassification(String name);
	Customer getCustomer(String name);
	CustomerClassification getCustomerClassification(String name);
}
