package sales.domain.model;

import static org.junit.Assert.*;

import org.junit.*;

public class CustomerTests {

	@Test
	public void testClassificationCreation() {
		CustomerClassification telCom = new CustomerClassification(
				"Telecommunications");
		
		Customer customer = new Customer("Globe", "Adrian Adame", telCom);
		
		assertEquals(telCom.getName(), customer.getClassification());
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void testNameBlank() {
		CustomerClassification telCom = new CustomerClassification(
				"Telecommunications");
		
		Customer customer = new Customer("", "Adrian Adame", telCom);
		
	}
	
	

}
