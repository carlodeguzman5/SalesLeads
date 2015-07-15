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
import sales.infrastructure.jpa.NoExistingInquiryException;
import sales.interfaces.SalesServiceFacade;

@Service
@Transactional
public class SalesService implements SalesServiceFacade {

	@Autowired
	protected ApplicationContext context;

	private CustomerRepository customerRepository;
	private InquiryRepository inquiryRepository;

	@Autowired
	public SalesService(CustomerRepository customerRepository, InquiryRepository inquiryRepository) {
		this.customerRepository = customerRepository;
		this.inquiryRepository = inquiryRepository;
	}

	public void inquireOldCustomer(String customerName, String inquiryName) throws NoExistingInquiryException {
		Customer customer = customerRepository.findByCustomerName(customerName);
		Inquiry inquiry = inquiryRepository.getInquiryByName(inquiryName);
		customerRepository.inquire(customer, inquiry, today());
	}
	
	public void inquireNewCustomer(){};

	public Collection<CustomerInquiry> getAllCustomerInquiries() {
		return customerRepository.getAllCustomerInquiries();
	}
	
	public void createCustomer(String name, String contactPerson, String email, String contactNumber,
			CustomerClassification classification) {
		customerRepository.createCustomer(name, contactPerson, contactNumber, email, classification);
	}
	
	public void createInquiry(String name) {
		inquiryRepository.createInquiry(name);
	}

	public Inquiry findInquiry(String type) {
		//return entityManager.find(Inquiry.class, type);
		return null;
	}


	public void createCustomerClassification(String name) {
		customerRepository.createCustomerClassification(name);
	}
	
	public CustomerClassification findCustomerClassification(String name){
		return customerRepository.getCustomerClassification(name);
	}
	
	public Customer findCustomer(String name) {
		return customerRepository.getCustomer(name);
	}
	
	public Collection<Customer> getAllCustomers(){
		return customerRepository.getAllCustomers();
	}

	private Date today() {
		Calendar now = todayAsCalendar();
		return now.getTime();
	}
	
	private Calendar todayAsCalendar() {
		Calendar now = Calendar.getInstance();
		now.set(Calendar.HOUR_OF_DAY, 0);
		now.clear(Calendar.MINUTE);
		now.clear(Calendar.SECOND);
		now.clear(Calendar.MILLISECOND);
		return now;
	}

	public Collection<Inquiry> getAllInquiries() {
		return inquiryRepository.getAllInquiries();
	}
	
}
