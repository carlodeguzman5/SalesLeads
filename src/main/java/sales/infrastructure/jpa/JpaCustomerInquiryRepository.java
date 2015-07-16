package sales.infrastructure.jpa;

import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import sales.domain.model.Customer;
import sales.domain.model.CustomerInquiry;
import sales.domain.model.CustomerInquiryRepository;
import sales.domain.model.Inquiry;

@Repository
@Transactional
public class JpaCustomerInquiryRepository implements CustomerInquiryRepository {

	@PersistenceContext
	protected EntityManager entityManager;
	
	
	public void createCustomerInquiry(Customer customer, Inquiry inquiry, String subject, String message, Date date) {
		CustomerInquiry ci = new CustomerInquiry(customer, inquiry, subject, message, date);
		entityManager.persist(ci);
		entityManager.flush();
	}

}
