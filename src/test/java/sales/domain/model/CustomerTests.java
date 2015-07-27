package sales.domain.model;

import static org.junit.Assert.*;

import org.junit.*;

public class CustomerTests {

	@Test
	public void testClassificationCreation() {
		CustomerClassification telCom = new CustomerClassification(
				"Telecommunications");
		
		//ContactPerson contactPerson = new ContactPerson("Adrian Adame","adrian@gmail.com","09123456789");
		Customer customer = new Customer("Globe", telCom);
		
		
		assertEquals(telCom.getName(), customer.getCustomerClassification().getName());
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void testNameBlank() {
		CustomerClassification telCom = new CustomerClassification(
				"Telecommunications");
		
		Customer customer = new Customer("", telCom);
		
	}
	
	

}
