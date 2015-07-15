package sales.infrastructure.jpa;

import java.util.Calendar;
import java.util.Collection;
import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import sales.domain.model.Customer;
import sales.domain.model.CustomerClassification;
import sales.domain.model.CustomerInquiry;
import sales.domain.model.CustomerRepository;
import sales.domain.model.Inquiry;

@Repository
@Transactional
public class JpaCustomerRepository implements CustomerRepository {

	private static final String SQL_FIND_ALL_CUSTOMERS = "SELECT * FROM CUSTOMER_T";
	
	private static final String SQL_FIND_ALL_INQUIRIES= "SELECT *"
			+ " FROM CUSTOMER_INQUIRY";
	
	@PersistenceContext
	protected EntityManager entityManager;

	public Customer findByCustomerName(String name) {
		Customer customer;
		try {
			customer = entityManager.find(Customer.class, name);
		} catch (RuntimeException e) {
			throw new NoExistingCustomerException("");
		}
		return customer;
	}

	public void createCustomer(String name, String contactPerson, String email, String contactNumber, CustomerClassification classification) {
		Customer customer = new Customer(name, contactPerson, contactNumber, email, classification);
		entityManager.persist(customer);
		entityManager.flush();
		
	}

	public void inquire(Customer customer, Inquiry inquiry, Date date) {
		CustomerInquiry customerInquiry = new CustomerInquiry(customer, inquiry, date);
		entityManager.persist(customerInquiry);
		entityManager.flush();
		
	}

	public Collection<Customer> getAllCustomers() {
		return entityManager.createNativeQuery(SQL_FIND_ALL_CUSTOMERS, Customer.class).getResultList();
	}

	public Collection<CustomerInquiry> getAllCustomerInquiries() {
		return entityManager.createNativeQuery(SQL_FIND_ALL_INQUIRIES, CustomerInquiry.class).getResultList();
	}

	public void createCustomerClassification(String name) {
		entityManager.persist(new CustomerClassification(name));
		entityManager.flush();
		
	}

	public Customer getCustomer(String name) {
		return entityManager.find(Customer.class, name);
	}

	public CustomerClassification getCustomerClassification(String name) {
		return entityManager.find(CustomerClassification.class, name);
	}
	
	
	
	
}
