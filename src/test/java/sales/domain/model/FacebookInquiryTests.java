package sales.domain.model;

import org.junit.Test;

public class FacebookInquiryTests {

	@Test (expected = IllegalArgumentException.class)
	public void testFbIdBlank() {
		Facebook fb = new Facebook("", "Inquiry for Training", "Is there an available training for JDBC?", new InquiryType("JDBC") );
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void testSubjectBlank() {
		Facebook fb = new Facebook("adrianadame", " " , "Is there an available training for JDBC?", new InquiryType("JDBC"));
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void testContentBlank() {
		Facebook fb = new Facebook("adrianadame", "Inquiry for Training", "", new InquiryType("JDBC"));
	}
	
}
