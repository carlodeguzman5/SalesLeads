package sales.domain.model;

public class Email extends Inquiry {
	private String emailAddress;
	private String subject;
	private String content;
	
	public Email(String emailAddress, String subject, String content) {
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
