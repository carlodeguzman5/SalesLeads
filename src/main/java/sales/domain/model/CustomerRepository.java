package sales.domain.model;

public interface CustomerRepository {

	Customer findByCustomerName(String name);
	void createCustomer(String name, String contactPerson, String contactNumber, String email, CustomerClassification classification);
}
