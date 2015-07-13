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

	private String customerName;
	private String inquiryType;
	//@OneToOne(cascade = CascadeType.ALL)
	//@JoinColumn(name = "CUSTOMER_NAME")
	//private Customer customer;
	//@OneToOne(cascade = CascadeType.ALL)
	//@JoinColumn(name = "INQUIRY_TYPE")
	//private Inquiry inquiry;
	private Date date;
	@Column(length = 10000)
	private String response;
	private double budget;
	private int rating;

	protected CustomerInquiry() { /* USED BY JPA */ }

	public CustomerInquiry(String customerName, String inquiryType, Date date, String response, double budget, int rating) {
		this.customerName = customerName;
		this.inquiryType = inquiryType;
		/*this.customer = customer;
		this.inquiry = inquiry;*/
		this.date = date;
		this.response = response;
		this.budget = budget;
		this.rating = rating;
	}

	public String getResponse() {
		return response;
	}

	public void setResponse(String response) {
		this.response = response;
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

	public String getCustomerName() {
		return customerName;
	}

	public String getInquiryType() {
		return inquiryType;
	}

/*	public Customer getCustomer() {
		return customer;
	}

	public Inquiry getInquiry() {
		return inquiry;
	}*/

	public Date getDate() {
		return date;
	}

	public double getBudget() {
		return budget;
	}

}
