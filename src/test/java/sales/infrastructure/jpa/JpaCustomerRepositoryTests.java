package sales.infrastructure.jpa;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

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
	
	@Test//(expected = NoExistingCustomerException.class)
	public void existingCustomerTest(){
		Customer customer = customerRepository.findByCustomerName("Globe");
		assertEquals("Globe", customer.getName());
	}
}
