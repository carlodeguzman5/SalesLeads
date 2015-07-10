package salesleads.interfaces;

import static org.junit.Assert.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;

import org.junit.After;
import org.junit.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;
import org.springframework.test.context.transaction.TransactionConfiguration;

import sales.interfaces.SalesServiceFacade;

@DirtiesContext(classMode=ClassMode.AFTER_EACH_TEST_METHOD)
@TransactionConfiguration(defaultRollback=true)
public abstract class AbstractSalesServiceFacadeTests {

	@Autowired
	protected ApplicationContext context;
	
	protected SalesServiceFacade service;

	@PersistenceUnit
	protected EntityManagerFactory entityManagerFactory;
	protected EntityManager entityManager;
	
	@Before
	public void setUp() throws Exception {
		service = context.getBean(SalesServiceFacade.class);
		assertNotNull(
				"Please provide a service implementation", service);
		entityManager = entityManagerFactory.createEntityManager();
		entityManager.getTransaction().begin();
		try {
			setUpCustomerClassifications();
			setUpCustomers();
			setUpInquiryTypes();
			setUpInquiries();
			entityManager.getTransaction().commit();
		} finally {
			entityManager.close();
		}
	}

	protected abstract void setUpCustomers();
	protected abstract void setUpCustomerClassifications();
	protected abstract void setUpInquiries();
	protected abstract void setUpInquiryTypes();
	
	@After
	public void tearDown() throws Exception {
	}
	
}