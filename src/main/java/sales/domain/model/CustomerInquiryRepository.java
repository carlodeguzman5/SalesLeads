package sales.domain.model;

public interface CustomerInquiryRepository {
	void createCustomerInquiry(Customer customer, Inquiry inquiry, String subject, String message);
}
