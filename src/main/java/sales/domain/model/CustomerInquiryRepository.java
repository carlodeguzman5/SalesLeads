package sales.domain.model;

import java.util.Date;

public interface CustomerInquiryRepository {
	void createCustomerInquiry(Customer customer, Inquiry inquiry, String subject, String message, Date date);
}
