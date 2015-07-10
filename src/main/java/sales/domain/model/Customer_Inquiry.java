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
@IdClass(CustomerInquiryId.class)
@Table(name="CUSTOMER_INQUIRY")
public class Customer_Inquiry{

	@Id
	private String customerName;
	
	@Id
	private String inquiryType;
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="CUSTOMER_NAME")
	private Customer customer;
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="INQUIRY_TYPE")
	private Inquiry inquiry;
	private Date date;
	@Column(length=10000)
	private String response;
	private double budget;
	private int rating;
	
	
	protected Customer_Inquiry(){ /* USED BY JPA */ }
	
	public Customer_Inquiry(Customer customer, Inquiry inquiry) {
		this.customer = customer;
		this.inquiry = inquiry;
	}

	public String getId() {
		return customerName + " " + inquiryType;
	}

	public String getCustomerName() {
		return customer.getName();
	}

	public String getInquiryType() {
		return inquiry.getInquiryType();
	}

	public Date getDate() {
		return date;
	}

	public String getResponse() {
		return response;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public void setResponse(String response) {
		this.response = response;
	}

	public double getBudget() {
		return budget;
	}

	public void setBudget(double budget) {
		this.budget = budget;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}
	
}
