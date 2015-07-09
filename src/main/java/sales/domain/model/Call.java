package sales.domain.model;

import static org.apache.commons.lang3.Validate.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="CALL_INQUIRY")
public class Call extends Inquiry {

	private String phoneNumber;
	private String subject;
	@Column(length = 10000)
	private String content;
	
	protected Call() {}

	public Call(String phoneNumber, String subject, String content, InquiryType type) {
		notEmpty(phoneNumber);
		notBlank(phoneNumber);
		notEmpty(subject);
		notBlank(subject);
		notEmpty(content);
		notBlank(content);
		this.phoneNumber = phoneNumber;
		this.subject = subject;
		this.content = content;
		this.inquiryType = type;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public String getSubject() {
		return subject;
	}

	public String getContent() {
		return content;
	}

}
