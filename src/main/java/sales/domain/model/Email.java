package sales.domain.model;
import static org.apache.commons.lang3.Validate.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="EMAIL_INQUIRY")
public class Email extends Inquiry {
	
	@Column(name="EMAIL_ADDRESS")
	private String emailAddress;
	@Column(name="SUBJECT")
	private String subject;
	@Column(name="CONTENT", length=10000)
	private String content;
	
	protected Email(){/*AS NEEDED BY JPA*/}
	
	public Email(String emailAddress, String subject, String content, String type) {
		notEmpty(emailAddress);
		notBlank(emailAddress);
		notEmpty(subject);
		notBlank(subject);
		notEmpty(content);
		notBlank(content);
		this.emailAddress = emailAddress;
		this.subject = subject;
		this.content = content;
		this.inquiryType = type;
	}
	
	public String getEmailAddress() {
		return emailAddress;
	}

	public String getSubject() {
		return subject;
	}

	public String getContent() {
		return content;
	}
	
	
	
}
