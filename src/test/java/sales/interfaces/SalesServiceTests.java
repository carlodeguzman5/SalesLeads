package sales.interfaces;

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
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import sales.domain.model.Customer;
import sales.domain.model.CustomerClassification;
import sales.domain.model.Inquiry;
import sales.domain.service.SalesService;
import sales.infrastructure.jpa.NoExistingInquiryException;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration
@Transactional
public class SalesServiceTests {

	@Autowired
	protected ApplicationContext context;
	protected SalesServiceFacade service;

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
		setUpCustomerClassifications();
		setUpCustomers();
		setUpInquiryTypes();
	}
	
	protected void setUpCustomerClassifications() {
		CustomerClassification telCom = new CustomerClassification("Telecommunications");
		CustomerClassification hardware = new CustomerClassification("Hardware");
		CustomerClassification accountancy = new CustomerClassification("Accounting Firm");
		entityManager.persist(telCom);
		entityManager.persist(hardware);
		entityManager.persist(accountancy);
		entityManager.flush();
	}
	
	protected void setUpCustomers() { 
		Customer globe = new Customer("Globe", "Adrian Adame", entityManager.find(CustomerClassification.class, "Telecommunications"));
		Customer wilcon = new Customer("Wilcon", "Adrian Adame", entityManager.find(CustomerClassification.class, "Hardware"));
		Customer accountant = new Customer("R.G. Manabat & Co.", "Henry Antonio", entityManager.find(CustomerClassification.class, "Accounting Firm"));
		entityManager.persist(globe);
		entityManager.persist(wilcon);
		entityManager.persist(accountant);
		entityManager.flush();
	}

	protected void setUpInquiryTypes() {
		Inquiry training = new Inquiry("Training");
		Inquiry development = new Inquiry("Development");
		entityManager.persist(training);
		entityManager.persist(development);
		entityManager.flush();
	}
	
	
	
	@After
	public void tearDown() throws Exception {
		entityManager.getTransaction().rollback();
	}
	
	@Test
	public void customerInquiryInsertTest() throws NoExistingInquiryException{
		
		service.createInquiry("Consulting");
		
		
		service.inquireOldCustomer("Globe", "Training");
		service.inquireOldCustomer("Wilcon", "Consulting");
		
		Customer globe = entityManager.find(Customer.class, "Globe");
		assertEquals("Globe", globe.getName());
		assertEquals(2, service.getAllCustomerInquiries().size());
	}
	
	@Test
	public void findAllCustomerTest(){
		service.createCustomerClassification("Food");
		CustomerClassification cc = service.findCustomerClassification("Food");
		service.createCustomer("McDonalds", "Ronald", "ron@mcdo.com", "86236", cc);
		service.createCustomer("Jollibee", "Bee", "jolly@bee.com", "8700", cc);
		assertEquals(2, service.getAllCustomers().size());
	}
	@Test
	public void findAllInquiriesTest(){
		service.createInquiry("Just");
		service.createInquiry("Another");
		service.createInquiry("Test");
		assertEquals(3, service.getAllInquiries().size());
	}
	
	
}
