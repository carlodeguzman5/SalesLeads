package sales.domain.model;

public abstract class Inquiry {

	protected InquiryType inquiryType;

	public String getInquiryType() {
		return inquiryType.getName();
	}
	
}
