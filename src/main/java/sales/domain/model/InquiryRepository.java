package sales.domain.model;

import sales.infrastructure.jpa.NoExistingInquiryException;

public interface InquiryRepository {
	
	Inquiry getInquiryByName(String inquiry) throws NoExistingInquiryException;
	void createInquiry(String inquiry);
	
}
