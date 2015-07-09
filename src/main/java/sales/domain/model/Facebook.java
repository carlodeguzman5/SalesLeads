package sales.domain.model;

import static org.apache.commons.lang3.Validate.notBlank;
import static org.apache.commons.lang3.Validate.notEmpty;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="FACEBOOK_INQUIRY")
public class Facebook extends Inquiry{

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	
	private String facebookId;
	private String subject;
	private String content;
	
	protected Facebook(){/*AS NEEDED BY JPA*/}

	public Facebook(String facebookId, String subject, String content, InquiryType type) {
		notEmpty(facebookId);
		notBlank(facebookId);
		notEmpty(subject);
		notBlank(subject);
		notEmpty(content);
		notBlank(content);
		this.facebookId = facebookId;
		this.subject = subject;
		this.content = content;
		this.inquiryType = type;
	}

	public long getId() {
		return id;
	}

	public String getFacebookId() {
		return facebookId;
	}

	public String getSubject() {
		return subject;
	}

	public String getContent() {
		return content;
	}

	@Override
	public String toString() {
		return "Facebook [id=" + id + ", facebookId=" + facebookId
				+ ", subject=" + subject + ", content=" + content + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((content == null) ? 0 : content.hashCode());
		result = prime * result
				+ ((facebookId == null) ? 0 : facebookId.hashCode());
		result = prime * result + (int) (id ^ (id >>> 32));
		result = prime * result + ((subject == null) ? 0 : subject.hashCode());
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
		Facebook other = (Facebook) obj;
		if (content == null) {
			if (other.content != null)
				return false;
		} else if (!content.equals(other.content))
			return false;
		if (facebookId == null) {
			if (other.facebookId != null)
				return false;
		} else if (!facebookId.equals(other.facebookId))
			return false;
		if (id != other.id)
			return false;
		if (subject == null) {
			if (other.subject != null)
				return false;
		} else if (!subject.equals(other.subject))
			return false;
		return true;
	}
	
}
