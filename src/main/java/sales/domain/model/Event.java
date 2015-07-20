package sales.domain.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="EVENT_T")
public class Event {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="EVENT_ID")
	private long id;
	private String title;
	@Column(length=1000)
	private String content;
	
	@JoinColumn(name="EVENT_AFTER", referencedColumnName = "EVENT_ID", nullable = true)
	@OneToOne(optional = true)
	private Event after;

	protected Event(){/*AS NEEDED BY JPA */}
	
	public Event(String title, String content) {
		this.title = title;
		this.content = content;
	}

	public long getId() {
		return id;
	}

	public String getTitle() {
		return title;
	}

	public String getContent() {
		return content;
	}
	
	public Event getAfter() {
		return after;
	}
	
	public void setAfter(Event after) {
		this.after = after;
	}
}
