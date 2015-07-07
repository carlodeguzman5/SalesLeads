package sales.domain.model;
import static org.apache.commons.lang3.Validate.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Email_Inquiry")
public class Email extends Inquiry {
	
	@Id
	private long id;
	
	private String emailAddress;
	private String subject;
	private String content;
	
	public Email(String emailAddress, String subject, String content) {
		notEmpty(emailAddress);
		notBlank(emailAddress);
		notEmpty(subject);
		notBlank(subject);
		notEmpty(content);
		notBlank(content);
		this.emailAddress = emailAddress;
		this.subject = subject;
		this.content = content;
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
