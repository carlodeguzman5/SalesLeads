package sales.tests.model;

import static org.junit.Assert.*;

import org.junit.*;
import org.omg.IOP.ExceptionDetailMessage;

import sales.main.model.Customer;
import sales.main.model.CustomerClassification;

public class CustomerTests {

	@Test
	public void testClassificationCreation() {
		CustomerClassification telCom = new CustomerClassification(
				"Telecommunications");
		
		Customer customer = new Customer("Globe", "Adrian Adame", telCom);
		
		assertEquals(telCom, customer.getClassification());
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void testNameBlank() {
		CustomerClassification telCom = new CustomerClassification(
				"Telecommunications");
		
		Customer customer = new Customer("", "Adrian Adame", telCom);
		
	}
	
	

}
