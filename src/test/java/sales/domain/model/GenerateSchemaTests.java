package sales.domain.model;

import static org.junit.Assert.*;

import java.math.BigDecimal;
import java.util.Currency;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceUnit;
import javax.persistence.TypedQuery;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import sales.domain.service.SalesService;

@ContextConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
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
	}

	@Test
	public void testGenerateSchema() throws Exception {
		entityManager.getMetamodel().entity(Email.class);
		System.out.println("Please check the resulting schema");
	}
	
	@Test
	public void testCustomerClassification(){
		Customer customer = new Customer("Smart", "Manny V. Pangilinan", new CustomerClassification("Telecommunications"));
		entityManager.persist(customer);
		Customer customer2 = new Customer("SM", "Henry Sy", new CustomerClassification("Land Development"));		
		entityManager.persist(customer2);
		entityManager.flush();
		Customer c = entityManager.find(Customer.class, "Smart");
		assertEquals("Telecommunications", c.getClassification());
	}

	@Test
	public void testEmail() throws Exception {
		InquiryType type = new InquiryType("JDBC");
		Email email = new Email("Adrian@gmail.com", "Inquiry for Training", "Is there an available training for JDBC?", type);
		entityManager.persist(email);
		entityManager.flush();
		Long emailId = email.getId();
		Email retrievedEmailinquiry = entityManager.find(Email.class, emailId);
		assertEquals(email, retrievedEmailinquiry);
		assertEquals(type.getName(), retrievedEmailinquiry.getInquiryType());
	}

	@Test
		public void testSMS() throws Exception{
			SMS sms = new SMS("09123456789", "Inquiry for Training" , "Is there an available training for JDBC?", new InquiryType("Training"));
			entityManager.persist(sms);
			entityManager.flush();
			
			Long smsId = sms.getId();
			SMS retrievedSMS = entityManager.find(SMS.class, smsId);
			assertEquals(sms, retrievedSMS);
			assertEquals("09123456789", retrievedSMS.getPhoneNumber());
		}
	
}