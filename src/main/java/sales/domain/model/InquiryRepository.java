package sales.domain.model;

import java.util.Collection;
import java.util.List;

import sales.infrastructure.jpa.NoExistingInquiryException;

public interface InquiryRepository {
	
	Inquiry getInquiryByName(String inquiry) throws NoExistingInquiryException;
	void createInquiry(String inquiry);
	Collection<Inquiry> getAllInquiries();
	
}
