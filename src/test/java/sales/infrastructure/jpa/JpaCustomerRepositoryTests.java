package sales.infrastructure.jpa;

import static org.junit.Assert.assertEquals;

import java.util.Collection;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import sales.domain.model.ContactPerson;
import sales.domain.model.Customer;
import sales.domain.model.CustomerClassification;
import sales.domain.model.CustomerRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:sales/interfaces/GenerateSchemaTests-context.xml"})
@Transactional
public class JpaCustomerRepositoryTests {
	
	@Autowired
	private CustomerRepository customerRepository;
	
	@Before
	public void setUp(){
		
		
		CustomerClassification classification = new CustomerClassification("Telecommunications");
		customerRepository.createCustomer("Globe", "John Smith", "09123456789", "john@globe.com", classification);
	}
	@After
	public void tearDown(){

	}
	
	@Test(expected = NoExistingCustomerException.class)
	public void nonExistingCustomerTest(){
		Customer customer = customerRepository.findByCustomerName("Bootstrap");
		customer.getName();
	}
	
	@Test
	public void existingCustomerTest(){
		Customer customer = customerRepository.findByCustomerName("Globe");
		assertEquals("Globe", customer.getName());
	}
	
	@Test
	public void addContactPersonToCustomerTest(){
		CustomerClassification classification = new CustomerClassification("Testing Telecom");
		Customer customer = customerRepository.createCustomer("Smart", "MVP", "MVP@Smart.com", "09123456789", classification);
		Collection<ContactPerson> persons = customerRepository.getAllContactPersons(customer);
		for(ContactPerson cp : persons){
			assertEquals("MVP", cp.getName());
			assertEquals("09123456789", cp.getContactNumber());
			assertEquals("MVP@Smart.com", cp.getEmail());
		}
		
	}
	
	
}
