package sales.infrastructure.jpa;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.net.ssl.SSLEngineResult.Status;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.swing.plaf.synth.SynthSeparatorUI;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import sales.domain.model.Customer;
import sales.domain.model.CustomerInquiry;
import sales.domain.model.CustomerInquiryRepository;
import sales.domain.model.Inquiry;
import sales.domain.model.Notification;

@Repository
@Transactional
public class JpaCustomerInquiryRepository implements CustomerInquiryRepository {
	
	private static final String JPQL_GET_CUSTOMER_INQUIRY = "SELECT a FROM CustomerInquiry AS a WHERE a.customer = :customer "
			+ "AND a.inquiry = :inquiry "
			+ "AND a.subject = :subject ";
			//+ "AND a.message = :message";

	private static final String JPQL_GET_ALL_CUSTOMER_INQUIRIES = "SELECT a FROM CustomerInquiry a";
	
	private static final String JPQL_GET_LEADS_BY_STATUS = "SELECT a FROM CustomerInquiry AS a WHERE a.status = :status";
	
	@PersistenceContext
	protected EntityManager entityManager;
	
	
	public void createCustomerInquiry(Customer customer, Inquiry inquiry, String subject, String message, Date date) {
		CustomerInquiry ci = new CustomerInquiry(customer, inquiry, subject, message, date);
		entityManager.persist(ci);
		entityManager.flush();
	}


	public CustomerInquiry getCustomerInquiry(String companyName, String inquiryName,
			String subject, String content) {
		System.out.println(content + "============");
	    Customer customer = entityManager.find(Customer.class, companyName);
		Inquiry inquiry = entityManager.find(Inquiry.class, inquiryName);
	
		
		TypedQuery<CustomerInquiry> query = entityManager.createQuery(JPQL_GET_CUSTOMER_INQUIRY, CustomerInquiry.class)
				.setParameter("customer", customer)
				.setParameter("inquiry", inquiry)
				.setParameter("subject", subject);
				//.setParameter("message", content);	
		
		return query.getSingleResult();
				
	}
	
	public void customizeNotification(CustomerInquiry customerInquiry, String amount, String unit) {
		int span = Integer.valueOf(amount);
		if(unit.equalsIgnoreCase("days")){
			span = Integer.valueOf(amount) * 24;
		}
		System.out.println("<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<" + customerInquiry.getCustomer().getName() + ">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
		CustomerInquiry ci = getCustomerInquiry(customerInquiry.getCustomer().getName(), customerInquiry.getInquiry().getType(), customerInquiry.getSubject(), customerInquiry.getResponse());
		ci.setNotificationSpan(span);
		entityManager.persist(ci);
		entityManager.flush();
	}

	public void updateLeadStatus(CustomerInquiry customerInquiry, String status) {
		customerInquiry.setStatus(CustomerInquiry.Status.valueOf(status));
		entityManager.merge(customerInquiry);
		entityManager.flush();
		
	}


	public List<CustomerInquiry> getLeadsByStatus(String status) {
		return entityManager.createQuery(JPQL_GET_LEADS_BY_STATUS).setParameter("status", CustomerInquiry.Status.valueOf(status)).getResultList();
	}


	public Collection<CustomerInquiry> getInquiriesByCustomer(String company) {
		TypedQuery<CustomerInquiry> query = entityManager.createQuery(JPQL_GET_ALL_CUSTOMER_INQUIRIES, CustomerInquiry.class);	
		Collection<CustomerInquiry> allCustomerInquiries = query.getResultList();
		List<CustomerInquiry> customerInquiries = new ArrayList<CustomerInquiry>();
		
		for(CustomerInquiry ci : allCustomerInquiries){
			if(ci.getCustomer().getName().equals(company)){
				customerInquiries.add(ci);
			}
		}
		Collections.reverse(customerInquiries);
		return customerInquiries;
	}

}
