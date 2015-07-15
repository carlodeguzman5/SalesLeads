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
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
// @IdClass(CustomerInquiryId.class)
@Table(name = "CUSTOMER_INQUIRY")
public class CustomerInquiry {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "CUSTOMER_NAME")
	private Customer customer;
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "INQUIRY_TYPE")
	private Inquiry inquiry;
	private Date date;
	private String subject;
	@Column(length = 10000)
	private String message;
	private double budget;
	private int rating;

	protected CustomerInquiry() { /* USED BY JPA */ }

	public CustomerInquiry(Customer customer, Inquiry inquiry, Date date) {
		this.customer = customer;
		this.inquiry = inquiry;
		this.date = date;
	}
	
	public CustomerInquiry(Customer customer, Inquiry inquiry, String subject, String message){
		this();
		this.subject = subject;
		this.message = message;
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

}
