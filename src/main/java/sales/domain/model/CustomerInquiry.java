package sales.domain.model;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
// @IdClass(CustomerInquiryId.class)
@Table(name = "CUSTOMER_INQUIRY")
public class CustomerInquiry implements Serializable{

	public enum Status{
		CLOSED, ONGOING, PENDING
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@Lob
	@Column(name="customer", length = 10000)
	private Customer customer;
	@Lob
	@Column(name="inquiry", length = 10000)
	private Inquiry inquiry;
	private Date date;
	private String subject;
	@Column(length = 10000)
	private String message;
	@JoinColumn(name="TIMELINE", referencedColumnName = "EVENT_ID", nullable = true)
	@OneToOne(optional=true)
	private Event timeline;
	private double budget;
	private int rating;
	@Enumerated(EnumType.STRING)
	private Status status;
	private int notificationSpan;

	protected CustomerInquiry() { /* USED BY JPA */ }
	
	public CustomerInquiry(Customer customer, Inquiry inquiry, String subject, String message, Date date){
		this.subject = subject;
		this.message = message;
		this.customer = customer;
		this.inquiry = inquiry;
		this.date = date;
		this.status = Status.ONGOING;
		this.notificationSpan = 24;
	}

	public String getResponse() {
		return message;
	}

	public void setResponse(String response) {
		this.message = response;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

	public long getId() {
		return id;
	}

	public Customer getCustomer() {
		return customer;
	}

	public Inquiry getInquiry() {
		return inquiry;
	}

	public Date getDate() {
		return date;
	}

	public double getBudget() {
		return budget;
	}

	public String getSubject() {
		return subject;
	}

	public String getMessage() {
		return message;
	}

	public Event getTimeline() {
		return timeline;
	}
	
	public void setTimeline(Event timeline) {
		this.timeline = timeline;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public int getNotificationSpan() {
		return notificationSpan;
	}

	public void setNotificationSpan(int notificationSpan) {
		this.notificationSpan = notificationSpan;
	}

	@Override
	public String toString() {
		return "CustomerInquiry [id=" + id + ", customer=" + customer
				+ ", inquiry=" + inquiry + ", date=" + date + ", subject="
				+ subject + ", message=" + message + ", timeline=" + timeline
				+ ", budget=" + budget + ", rating=" + rating + ", status="
				+ status + ", notificationSpan=" + notificationSpan + "]";
	}
	
}