package sales.domain.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
// @IdClass(CustomerInquiryId.class)
@Table(name = "CUSTOMER_INQUIRY")
public class CustomerInquiry {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
//	@OneToOne(cascade = CascadeType.ALL)
//	@JoinColumn(name = "CUSTOMER_NAME")
	@Lob
	@Column(name="customer", length = 10000)
	private Customer customer;
//	@OneToOne(cascade = CascadeType.ALL)
//	@JoinColumn(name = "INQUIRY_TYPE")
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

	protected CustomerInquiry() { /* USED BY JPA */ }
	
	public CustomerInquiry(Customer customer, Inquiry inquiry, String subject, String message, Date date){
		this.subject = subject;
		this.message = message;
		this.customer = customer;
		this.inquiry = inquiry;
		this.date = date;
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
	
}
