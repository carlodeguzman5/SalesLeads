package sales.domain.model;
import org.junit.Test;


public class EmailInquiryTests {

	@Test (expected = IllegalArgumentException.class)
	public void testEmailAddressBlank() {
		Email email = new Email("", "Inquiry for Training", "Is there an available training for JDBC?");
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void testSubjectBlank() {
		Email email = new Email("adrian@gmail.com", " " , "Is there an available training for JDBC?");
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void testContentBlank() {
		Email email = new Email("adrian@gmail.com", "Inquiry for Training", "");
	}
	
}
