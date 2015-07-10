package sales.domain.model;

import javax.persistence.Column;

import static org.apache.commons.lang3.Validate.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="PERSONALVISIT_INQUIRY")
public class PersonalVisit extends Inquiry {

	private String visitorName;
	private String subject;
	@Column(length=10000)
	private String content;
	
	protected PersonalVisit(){/*AS NEEDED BY JPA*/}

	public PersonalVisit(String visitorName, String subject, String content, String type) {
		notEmpty(visitorName);
		notBlank(visitorName);
		notEmpty(subject);
		notBlank(subject);
		notEmpty(content);
		notBlank(content);
		this.visitorName = visitorName;
		this.subject = subject;
		this.content = content;
		this.inquiryType = type;
	}
	public String getVisitorName() {
		return visitorName;
	}

	public String getSubject() {
		return subject;
	}

	public String getContent() {
		return content;
	}

	@Override
	public String toString() {
		return "PersonalVisit [visitorName=" + visitorName
				+ ", subject=" + subject + ", content=" + content + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((content == null) ? 0 : content.hashCode());
		result = prime * result + ((subject == null) ? 0 : subject.hashCode());
		result = prime * result
				+ ((visitorName == null) ? 0 : visitorName.hashCode());
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
		PersonalVisit other = (PersonalVisit) obj;
		if (content == null) {
			if (other.content != null)
				return false;
		} else if (!content.equals(other.content))
			return false;
		if (subject == null) {
			if (other.subject != null)
				return false;
		} else if (!subject.equals(other.subject))
			return false;
		if (visitorName == null) {
			if (other.visitorName != null)
				return false;
		} else if (!visitorName.equals(other.visitorName))
			return false;
		return true;
	}
	
}
