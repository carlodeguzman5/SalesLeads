package sales.domain.model;

import static org.apache.commons.lang3.Validate.*;

import javax.persistence.Column;

import javax.persistence.Entity;
import javax.persistence.Id;

import org.omg.CosNaming.NamingContextPackage.NotEmpty;

@Entity
public class SMS extends Inquiry {

	@Id
	private long id;
	
	private String phoneNumber;
	private String subject;
	@Column(length = 10000)
	private String content;
	
	public SMS() {}

	public SMS(String phoneNumber, String subject, String content) {
		notEmpty(phoneNumber);
		notBlank(phoneNumber);
		notEmpty(subject);
		notBlank(subject);
		notEmpty(content);
		notBlank(content);
		this.phoneNumber = phoneNumber;
		this.subject = subject;
		this.content = content;
	}

	public long getId() {
		return id;
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

	@Override
	public String toString() {
		return "SMS [id=" + id + "]";
	}

}
