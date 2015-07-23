package sales.domain.model;

import java.util.Date;

public interface CustomerInquiryRepository {
	void createCustomerInquiry(Customer customer, Inquiry inquiry, String subject, String message, Date date);

	CustomerInquiry getCustomerInquiry(String companyName, String inquiryName, String subject,
			String content);

	void customizeNotification(CustomerInquiry customerInquiry, String amount,
			String unit);
}
