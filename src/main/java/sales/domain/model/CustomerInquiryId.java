package sales.domain.model;

import java.io.Serializable;

public class CustomerInquiryId  implements Serializable{

	private String customerName;
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((customerName == null) ? 0 : customerName.hashCode());
		result = prime * result + ((inquiryType == null) ? 0 : inquiryType.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CustomerInquiryId other = (CustomerInquiryId) obj;
		if (customerName == null) {
			if (other.customerName != null)
				return false;
		} else if (!customerName.equals(other.customerName))
			return false;
		if (inquiryType == null) {
			if (other.inquiryType != null)
				return false;
		} else if (!inquiryType.equals(other.inquiryType))
			return false;
		return true;
	}
	private String inquiryType;
	
}
