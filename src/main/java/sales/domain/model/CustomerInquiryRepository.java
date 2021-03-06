package sales.domain.model;

import java.util.Collection;
import java.util.Date;
import java.util.List;

public interface CustomerInquiryRepository {
	void createCustomerInquiry(Customer customer, Inquiry inquiry, String subject, String message, Date date);

	CustomerInquiry getCustomerInquiry(String companyName, String inquiryName, String subject,
			String content);

	void customizeNotification(CustomerInquiry customerInquiry, String amount,
			String unit);

	void updateLeadStatus(CustomerInquiry customerInquiry, String status);

	List<CustomerInquiry> getLeadsByStatus(String status);

	Collection<CustomerInquiry> getInquiriesByCustomer(String company);
}
