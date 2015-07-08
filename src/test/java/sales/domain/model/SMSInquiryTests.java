package sales.domain.model;

import org.junit.Test;

public class SMSInquiryTests {

	@Test (expected = IllegalArgumentException.class)
	public void testPhoneNumberBlank() {
		SMS sms = new SMS("", "Inquiry for Training", "Is there an available training for JDBC?");
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void testSubjectBlank() {
		SMS sms = new SMS("09123456789", " " , "Is there an available training for JDBC?");
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void testContentBlank() {
		SMS sms = new SMS("09123456789", "Inquiry for Training", "");
	}
	
}
