package sales.domain.service;

import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

import sales.domain.model.Customer;
import sales.domain.model.CustomerClassification;
import sales.domain.model.CustomerInquiry;
import sales.domain.model.CustomerRepository;
import sales.domain.model.Inquiry;
import sales.domain.model.InquiryRepository;
import sales.interfaces.SalesServiceFacade;

@Service
public class SalesService implements SalesServiceFacade {

	/*private static final String SQL_FIND_INQUIRIES_BY_NAME = "SELECT OBJECT(a)"
			+ " FROM CUSTOMER_INQUIRY a WHERE a.CUSTOMER_NAME = :customer";*/

	private static final String SQL_FIND_INQUIRIES_BY_NAME = "SELECT *"
			+ " FROM CUSTOMER_INQUIRY WHERE CUSTOMER_NAME LIKE ?";

	@Autowired
	protected ApplicationContext context;

	@PersistenceContext
	protected EntityManager entityManager;

	private CustomerRepository customerRepository;
	private InquiryRepository inquiryRepository;

	@Autowired
	public SalesService(CustomerRepository customerRepository, InquiryRepository inquiryRepository) {
		this.customerRepository = customerRepository;
		this.inquiryRepository = inquiryRepository;
	}

	public void inquireOldCustomer(String customerName, String inquiryName) {
		// Customer customer =
		// customerRepository.findByCustomerName(customerName);
		Customer customer = entityManager.find(Customer.class, customerName);
		Inquiry inquiry = new Inquiry(inquiryName);
		entityManager.persist(inquiry);

		CustomerInquiry customerInquiry = new CustomerInquiry(customer, inquiry, today());
		entityManager.persist(customerInquiry);
		
	}

	public Collection</*Customer*/Inquiry> findAllByCustomer(String name) {
		Customer customer = entityManager.find(Customer.class, name);
		return entityManager.createNativeQuery(SQL_FIND_INQUIRIES_BY_NAME, Inquiry.class)
				.setParameter(1, name).getResultList();
		// customerRepository.findByCustomerName(name);
	}
	
	public void createCustomer(String name, String contactPerson, String email, String contactNumber,
			CustomerClassification classification) {		
		entityManager.persist(new Customer(name, contactPerson, email, contactNumber, classification));		
	}
	
	public void createInquiry(String name) {
		entityManager.persist(new Inquiry(name));
		entityManager.flush();
	}

	protected Calendar todayAsCalendar() {
		Calendar now = Calendar.getInstance();
		now.set(Calendar.HOUR_OF_DAY, 0);
		now.clear(Calendar.MINUTE);
		now.clear(Calendar.SECOND);
		now.clear(Calendar.MILLISECOND);
		return now;
	}

	protected Date today() {
		Calendar now = todayAsCalendar();
		return now.getTime();
	}

	public Inquiry findInquiry(String type) {
		return entityManager.find(Inquiry.class, type);
	}
	
	public List<String> getInquiryTypes(){
		Query query = entityManager.createNativeQuery("SELECT e.type FROM INQUIRY e");
		List<String> inquiries = (List<String>) query.getResultList();
		return inquiries;
	}
	
	public void createCustomerClassification(String name) {
		entityManager.persist(new CustomerClassification(name));
	}
	
	public CustomerClassification findCustomerClassification(String name){
		return entityManager.find(CustomerClassification.class, name);
	}

}
