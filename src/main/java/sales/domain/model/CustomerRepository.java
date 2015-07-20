package sales.domain.model;

import java.util.ArrayList;
import java.util.Collection;

public interface CustomerRepository {

	Customer findByCustomerName(String name);
	void createCustomer(String name, String contactPerson, String contactNumber, String email, CustomerClassification classification);
	Collection<Customer> getAllCustomers();
	ArrayList<CustomerInquiry> getAllCustomerInquiries();
	void createCustomerClassification(String name);
	Customer getCustomer(String name);
	CustomerClassification getCustomerClassification(String name);
	Collection<CustomerClassification> getAllCustomerClassifications();
}
