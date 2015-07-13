package sales.infrastructure.jpa;

import static org.junit.Assert.*;

import javax.transaction.Transactional;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

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
	}
	
	@Test(expected = NoExistingCustomerException.class)
	public void nonExistingCustomerTest(){
		customerRepository.findByCustomerName("Bootstrap");
	}
	
	@Test
	public void existingCustomerTest(){
		Customer customer = customerRepository.findByCustomerName("Globe");
		assertEquals("Globe", customer.getName());
	}
}
