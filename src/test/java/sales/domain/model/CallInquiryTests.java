package sales.domain.model;

import org.junit.Test;

public class CallInquiryTests {

	@Test (expected = IllegalArgumentException.class)
	public void testPhoneNumberBlank() {
		Call call = new Call("", "Inquiry for Training", "Is there an available training for JDBC?", "Training" );
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void testSubjectBlank() {
		Call call = new Call("09123456789", " " , "Is there an available training for JDBC?", "Training");
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void testContentBlank() {
		Call call = new Call("09123456789", "Inquiry for Training", "", "Training");
	}

}
