package sales.domain.service;

import java.util.Calendar;
import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

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
public class SalesService implements SalesServiceFacade{
	
	@Autowired
	protected ApplicationContext context;
	
	@PersistenceContext
	protected EntityManager entityManager;
	
	private CustomerRepository customerRepository;
	private InquiryRepository inquiryRepository;
	
	@Autowired
	public SalesService(CustomerRepository customerRepository, InquiryRepository inquiryRepository){
		this.customerRepository = customerRepository;
		this.inquiryRepository = inquiryRepository;
	}


	public void inquireOldCustomer(String customerName, String inquiryName) {
		Customer customer = customerRepository.findByCustomerName(customerName);
		
		Inquiry inquiry = new Inquiry(inquiryName);
		entityManager.merge(inquiry);
		
		CustomerInquiry customerInquiry = new CustomerInquiry(customer, inquiry, today());
		entityManager.persist(customerInquiry);
	}


	public void findAllByCustomer(String name) {
		customerRepository.findByCustomerName(name);
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


	public void createCustomer(String name, String contactPerson, String email, String contactNumber,
			CustomerClassification classification) {
		// TODO Auto-generated method stub
		
	}	

}
