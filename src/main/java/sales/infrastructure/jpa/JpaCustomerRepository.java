package sales.infrastructure.jpa;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import sales.domain.model.ContactPerson;
import sales.domain.model.Customer;
import sales.domain.model.CustomerClassification;
import sales.domain.model.CustomerInquiry;
import sales.domain.model.CustomerRepository;
import sales.domain.model.Inquiry;

@Repository
@Transactional
public class JpaCustomerRepository implements CustomerRepository {

	private static final String SQL_FIND_ALL_CUSTOMERS = "SELECT * FROM CUSTOMER_T";
	
	private static final String SQL_FIND_ALL_CUSTOMER_INQUIRIES= "SELECT *"
			+ " FROM CUSTOMER_INQUIRY ORDER BY DATE DESC";
	
	private static final String SQL_FIND_ALL_CUSTOMER_CLASSIFICATIONS= "SELECT *"
			+ " FROM CUSTOMER_CLASSIFICATION";
	
	private static final String JPQL_FIND_ALL_CONTACT_PERSONS= "SELECT a"
			+ " FROM ContactPerson AS a WHERE"
			+ " a.customer = :customer";
	
	@PersistenceContext
	protected EntityManager entityManager;

	public Customer findByCustomerName(String name) {
		Customer customer;
		customer = entityManager.find(Customer.class, name);
		if(customer == null){
			throw new NoExistingCustomerException();
		}
		
		return customer;
	}

	public Customer createCustomer(String name, String contactPerson, String email, String contactNumber, CustomerClassification classification) {
		Customer customer = new Customer(name, classification);
		entityManager.persist(customer);
		entityManager.flush();
		ContactPerson contact = new ContactPerson(contactPerson, email, contactNumber, customer);
		entityManager.persist(contact);
		entityManager.flush();	
		
		return customer;
	}

	public Collection<Customer> getAllCustomers() {
		return entityManager.createNativeQuery(SQL_FIND_ALL_CUSTOMERS, Customer.class).getResultList();
	}

	public ArrayList<CustomerInquiry> getAllCustomerInquiries() {
		return (ArrayList<CustomerInquiry>) entityManager.createNativeQuery(SQL_FIND_ALL_CUSTOMER_INQUIRIES, CustomerInquiry.class).getResultList();
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

	public Collection<CustomerClassification> getAllCustomerClassifications() {
		return entityManager.createNativeQuery(SQL_FIND_ALL_CUSTOMER_CLASSIFICATIONS, CustomerClassification.class).getResultList();
	}

	public void updateCustomer(String customerName, String contactNumber, String contactPerson, String email,
			String customerClassification) {
		 Customer customer = entityManager.find(Customer.class, customerName);
		 
		 customer.setClassification(new CustomerClassification(customerClassification));
		 entityManager.merge(customer);
	}

	public Collection<ContactPerson> getAllContactPersons(Customer customer) {
		return entityManager.createQuery(JPQL_FIND_ALL_CONTACT_PERSONS).setParameter("customer", customer).getResultList();
	}

	public void addContactPersonToCustomer(Customer customer, String name, String email, String contactNumber) {
		ContactPerson contactPerson = new ContactPerson(name, email, contactNumber, customer);
		entityManager.persist(contactPerson);
		entityManager.merge(customer);
		
		
	}
	
}
