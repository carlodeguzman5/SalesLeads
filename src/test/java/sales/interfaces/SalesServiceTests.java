package sales.interfaces;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

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
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import sales.domain.model.Customer;
import sales.domain.model.CustomerClassification;
import sales.domain.model.CustomerInquiry;
import sales.domain.model.Event;
import sales.domain.model.Inquiry;
import sales.domain.service.SalesServiceImpl;
import sales.infrastructure.jpa.NoExistingInquiryException;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration
@Transactional
public class SalesServiceTests {

	@Autowired
	protected ApplicationContext context;
	protected SalesService service;

	@PersistenceUnit
	protected EntityManagerFactory entityManagerFactory;
	protected EntityManager entityManager;

	@Before
	public void setUp() throws Exception {
		service = context.getBean(SalesServiceImpl.class);
		assertNotNull(
				"Please provide a service implementation", service);
		entityManager = entityManagerFactory.createEntityManager();
		entityManager.getTransaction().begin();
		setUpCustomerClassifications();
		setUpCustomers();
		setUpInquiryTypes();
		setUpCustomerInquiries();
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
		Customer globe = new Customer("Globe", entityManager.find(CustomerClassification.class, "Telecommunications"));
		Customer wilcon = new Customer("Wilcon", entityManager.find(CustomerClassification.class, "Hardware"));
		Customer accountant = new Customer("R.G. Manabat & Co.", entityManager.find(CustomerClassification.class, "Accounting Firm"));
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
	
	protected void setUpCustomerInquiries(){
		Customer customer = entityManager.find(Customer.class, "Wilcon");
		Inquiry inquiry = entityManager.find(Inquiry.class, "Development");
		service.createCustomerInquiry(customer, inquiry, "Dev Inquiry", "Inventory system cost");
	}
	
	
	@After
	public void tearDown() throws Exception {
		entityManager.getTransaction().rollback();
	}
	
	@Test
	public void customerInquiryInsertTest() throws NoExistingInquiryException{
		
		entityManager.persist(new Inquiry("Consulting"));
		Inquiry inquiry = entityManager.find(Inquiry.class, "Consulting");
		
		entityManager.persist(new CustomerClassification("Bank"));
		CustomerClassification customerClassification = entityManager.find(CustomerClassification.class, "Bank");
		
		service.createCustomer("Smart", "MVP", "manny@smart.com", "09197896543", customerClassification);
		Customer customer = service.findCustomer("Smart");
		
		service.createCustomerInquiry(customer, inquiry, "Test 1", "Test Message 1");
		service.createCustomerInquiry(customer, inquiry, "Test 2", "Test Message 2");
		
		assertEquals(3, service.getAllCustomerInquiries().size());
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
	
	@Test
	public void createEventTest(){
		Event event1 = service.createEvent("Meeting", "Discussed Project", new Date());
		Event event2 = service.createEvent("Email", "Inquired about costing", new Date());
		Event event3 = service.createEvent("Phone Call", "Setting a meeting", new Date());
		
		
		ArrayList<CustomerInquiry> customerInquiries = service.getAllCustomerInquiries();
		CustomerInquiry customerInquiry = customerInquiries.get(0);
		
		service.appendEvent(customerInquiry, event1);
		service.appendEvent(customerInquiry, event2);
		service.appendEvent(customerInquiry, event3);
		
		Event expectedLastEvent = service.getLastEventOf(customerInquiry);
		
		assertEquals("Phone Call", expectedLastEvent.getTitle());
		
	}
	
	
}
