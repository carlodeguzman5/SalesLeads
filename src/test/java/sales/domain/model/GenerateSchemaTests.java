package sales.domain.model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import sales.domain.service.SalesService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration
@Transactional
public class GenerateSchemaTests {

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
	}

	@After
	public void tearDown() throws Exception {
		entityManager.getTransaction().commit();
	}

	@Test
	public void testGenerateSchema() throws Exception {
		entityManager.getMetamodel().entity(Inquiry.class);
		System.out.println("Please check the resulting schema");
	}

	@Test
	public void testCustomerClassification(){
		Customer customer = new Customer("Smart", "Manny V. Pangilinan", new CustomerClassification("Telecommunications"));
		entityManager.persist(customer);
		Customer customer2 = new Customer("SM", "Henry Sy", new CustomerClassification("Land Development"));		
		entityManager.persist(customer2);
		Customer c = entityManager.find(Customer.class, "Smart");
		assertEquals("Telecommunications", c.getCustomerClassification().getName());
	}
}