package sales.domain.model;

import java.io.Serializable;
import java.util.Date;

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
public class Event implements Serializable{
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
	private Date date;

	protected Event(){/*AS NEEDED BY JPA */}
	
	public Event(String title, String content, Date date) {
		this.title = title;
		this.content = content;
		this.date = date;
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
	
	public Date getDate() {
		return date;
	}
	
	public void setAfter(Event after) {
		this.after = after;
	}

	@Override
	public String toString() {
		return "Event [id=" + id + ", title=" + title + ", content=" + content
				+ ", after=" + after + ", date=" + date + "]";
	}
}
