package sales.domain.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

@Entity
@Table(name="NOTIFICATION_T")
public class Notification {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	
	@Column(length=10000)
	private String message;
	private Date date;
	@Column(name="CUSTOMER_INQUIRY", length=10000)
	private CustomerInquiry customerInquiry;
	
	protected Notification(){}

	public Notification(String message, Date date, CustomerInquiry customerInquiry) {
		this.message = message;
		this.date = date;
		this.customerInquiry = customerInquiry;
	}

	public long getId() {
		return id;
	}

	public String getMessage() {
		return message;
	}

	public Date getDate() {
		return date;
	}

	public CustomerInquiry getCustomerInquiry() {
		return customerInquiry;
	}
	
}
