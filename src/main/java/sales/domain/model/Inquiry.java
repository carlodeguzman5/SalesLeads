package sales.domain.model;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="INQUIRY")
// @Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class Inquiry implements Serializable {

	@Id
	private String type;
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "CUSTOMER_PER_INQUIRY")
	private Set<CustomerInquiry> customers;
	
	protected Inquiry() {/* AS NEEDED BY JPA */}

	public Inquiry(String type) {
		this.type = type;
	}
	
	public String getType(){
		return type;
	}
}
