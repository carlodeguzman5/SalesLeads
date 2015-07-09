package sales.domain.model;

import static org.junit.Assert.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceUnit;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import sales.domain.service.SalesService;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration
public class DatabaseIntegrationTests {

	@Autowired
	protected ApplicationContext context;

	protected SalesService service;
	
	@PersistenceUnit
	protected EntityManagerFactory entityManagerFactory;
	protected EntityManager entityManager;
	
	@Before
	public void setUp() throws Exception {
		service = context.getBean(SalesService.class);
		assertNotNull(
				"Please provide a service implementation", service);
		entityManager = entityManagerFactory.createEntityManager();
		entityManager.getTransaction().begin();
		try {
			setUpCustomers();
			entityManager.getTransaction().commit();
		} finally {
			entityManager.close();
		}
	}
	
	private void setUpCustomers() {
		Customer customer = new Customer("Smart", "Manny V. Pangilinan", new CustomerClassification("Telecommunications"));
		Customer customer2 = new Customer("SM", "Henry Sy", new CustomerClassification("Land Development"));
		entityManager.persist(customer);
		entityManager.persist(customer2);
	}
	
	@Test
	public void test(){
		Customer c = entityManager.find(Customer.class, "Smart");
		assertEquals("Telecommunications", c.getClassification());
	}

}
