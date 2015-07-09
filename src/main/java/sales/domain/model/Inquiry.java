package sales.domain.model;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class Inquiry implements Serializable{

	@Id
	@OneToOne
	@JoinColumn(name="name")
	protected InquiryType inquiryType;
	
	@ManyToMany
	@JoinTable(
			name="CUSTOMER_INQUIRY",
			joinColumns={@JoinColumn(name="inquiry_type", referencedColumnName="name")},
			inverseJoinColumns={@JoinColumn(name="customer_id", referencedColumnName="name")}
	)
	private Set<Customer> customers;

	public String getInquiryType() {
		return inquiryType.getName();
	}
	
}
