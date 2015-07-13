package sales.infrastructure.jpa;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import org.springframework.stereotype.Repository;
import sales.domain.model.Customer;
import sales.domain.model.CustomerClassification;
import sales.domain.model.CustomerRepository;

@Repository
public class JpaCustomerRepository implements CustomerRepository {

	private static final String SQL_FINDBY_NAME = "SELECT a.NAME AS NAME"
			+ " FROM CUSTOMER_T a WHERE a.NAME = :name";

	private EntityManager entityManager;

	@PersistenceContext
	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	public Customer findByCustomerName(String name) {
		Customer customer;
		try {
			Query query = entityManager.createNativeQuery(SQL_FINDBY_NAME, Customer.class);
			query.setParameter("name", name);
			customer = (Customer) query.getSingleResult();
		} catch (RuntimeException e) {
			throw new NoExistingCustomerException("");
		}
		return customer;
	}

	public void createCustomer(String name, String contactPerson, String email, String contactNumber, CustomerClassification classification) {
		Customer customer = new Customer(name, contactPerson, contactNumber, email, classification);
		entityManager.persist(customer);
	}

}
