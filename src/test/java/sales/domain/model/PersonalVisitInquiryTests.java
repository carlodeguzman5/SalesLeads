package sales.domain.model;

import static org.junit.Assert.*;

import org.junit.Test;

public class PersonalVisitInquiryTests {

	@Test (expected = IllegalArgumentException.class)
	public void testVisitorNameBlank() {
		PersonalVisit visit = new PersonalVisit("", "Inquiry for Training", "Is there an available training for JDBC?", new InquiryType("JDBC") );
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void testSubjectBlank() {
		PersonalVisit visit = new PersonalVisit("adrian@gmail.com", " " , "Is there an available training for JDBC?", new InquiryType("JDBC"));
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void testContentBlank() {
		PersonalVisit visit = new PersonalVisit("adrian@gmail.com", "Inquiry for Training", "", new InquiryType("JDBC"));
	}

}
