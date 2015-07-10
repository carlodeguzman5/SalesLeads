package sales.infrastructure.jpa;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import org.springframework.stereotype.Repository;
import sales.domain.model.Customer;
import sales.domain.model.CustomerRepository;

@Repository
public class JpaCustomerRepository implements CustomerRepository {

	private static final String SQL_FINDBY_NAME = "SELECT a.ID AS ID, a.NAME AS NAME,"
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
			throw new NoExistingCustomerException(e);
		}
		return customer;
	}

}
