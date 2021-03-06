package sales.domain.service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

import sales.domain.model.ContactPerson;
import sales.domain.model.ContactPersonRepository;
import sales.domain.model.Customer;
import sales.domain.model.CustomerClassification;
import sales.domain.model.CustomerInquiry;
import sales.domain.model.CustomerInquiryRepository;
import sales.domain.model.CustomerRepository;
import sales.domain.model.Event;
import sales.domain.model.EventRepository;
import sales.domain.model.Inquiry;
import sales.domain.model.InquiryRepository;
import sales.domain.model.Notification;
import sales.domain.model.NotificationRepository;
import sales.infrastructure.jpa.NoExistingInquiryException;
import sales.interfaces.SalesService;

@Service
@Transactional
public class SalesServiceImpl implements SalesService {

	@Autowired
	protected ApplicationContext context;

	private CustomerRepository customerRepository;
	private InquiryRepository inquiryRepository;
	private CustomerInquiryRepository customerInquiryRepository;
	private EventRepository eventRepository;
	private UserRepository userRepository;
	private NotificationRepository notificationRepository;
	private ContactPersonRepository contactPersonRepository;

	@Autowired
	public SalesServiceImpl(CustomerRepository customerRepository, InquiryRepository inquiryRepository, CustomerInquiryRepository customerInquiryRepository, UserRepository userRepository, EventRepository eventRepository, NotificationRepository notificationRepository, ContactPersonRepository contactPersonRepository) {
		this.customerRepository = customerRepository;
		this.inquiryRepository = inquiryRepository;
		this.customerInquiryRepository = customerInquiryRepository;
		this.eventRepository = eventRepository;
		this.userRepository = userRepository;
		this.notificationRepository = notificationRepository;
		this.contactPersonRepository = contactPersonRepository;
	}

	public ArrayList<CustomerInquiry> getAllCustomerInquiries() {
		return customerRepository.getAllCustomerInquiries();
	}
	
	public void createCustomer(String name, String contactPerson, String email, String contactNumber,
			CustomerClassification classification) {
		customerRepository.createCustomer(name, contactPerson, contactNumber, email, classification);
	}
	
	public void createInquiry(String name) {
		inquiryRepository.createInquiry(name);
	}

	public Inquiry findInquiry(String type) throws NoExistingInquiryException {
		return inquiryRepository.getInquiryByName(type);
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
	
	
	private Date now(){
		Calendar calendar = Calendar.getInstance();
		Date now = calendar.getTime();
		Date currentTimestamp = new java.sql.Timestamp(now.getTime());
		return currentTimestamp;
	}

	public Collection<Inquiry> getAllInquiries() {
		return inquiryRepository.getAllInquiries();
	}

	public Collection<CustomerClassification> getAllCustomerClassifications() {
		return customerRepository.getAllCustomerClassifications();
	}
	
	public void createCustomerInquiry(Customer customer, Inquiry inquiry, String subject, String message){
		customerInquiryRepository.createCustomerInquiry(customer, inquiry, subject, message, now());
	}

	public Event createEvent(String title, String content, Date date) {
		return eventRepository.createEvent(title, content, date);
	}

	public void appendEvent(CustomerInquiry customerInquiry, Event event) {
		eventRepository.appendEvent(customerInquiry, event);
	}

	public Event getLastEventOf(CustomerInquiry customerInquiry) {
		return eventRepository.getLastEventOf(customerInquiry);
	}

	public String validateUser(String username, String password) {
		return userRepository.validateUser(username, password);
	}

	public void createUser(String username, String password) {
		userRepository.createUser(username, password);
	}

	public ArrayList<Event> getAllEventsOf(CustomerInquiry customerInquiry) {
		return eventRepository.getAllEventsOf(customerInquiry);
	}

	public CustomerInquiry getCustomerInquiry(String companyName, String inquiryName, String subject, String content) {
		return customerInquiryRepository.getCustomerInquiry(companyName,  inquiryName,  subject,  content);
	}

	/*public void updateCustomer(String customerName, String contactNumber,
			String contactPerson, String email, String customerClassification) {*/
	public void updateCustomer(String name, String email, String contactNumber) {
		//customerRepository.updateCustomer(customerName, contactNumber, contactPerson, email, customerClassification);
		customerRepository.updateCustomer(name, email,contactNumber);
	}

	public void customizeNotification(CustomerInquiry customerInquiry,
			String amount, String unit) {
		customerInquiryRepository.customizeNotification(customerInquiry, amount, unit);
	}

	public void updateNotification(CustomerInquiry customerInquiry) {
		notificationRepository.updateNotification(customerInquiry, getLastEventOf(customerInquiry));
	}

	public List<Notification> getNotifications() {
		return notificationRepository.getNotifications();
	}

	public List<CustomerInquiry> getLeadsByStatus(String status) {
		return customerInquiryRepository.getLeadsByStatus(status);
	}

	public void updateLeadStatus(CustomerInquiry customerInquiry, String status) {
		customerInquiryRepository.updateLeadStatus(customerInquiry, status);
	}

	public Collection<CustomerInquiry> getInquiriesByCustomer(String company) {
		return customerInquiryRepository.getInquiriesByCustomer(company);
	}

	public Collection<ContactPerson> getContactPersonsOf(Customer customer) {
		return customerRepository.getAllContactPersons(customer);
	}

	public void addContactPersonToCustomer(Customer customer, String name, String email, String contactNumber) {
		customerRepository.addContactPersonToCustomer(customer, name, email, contactNumber);
		
	}

	public void updateCustomer(String customerName, String contactNumber,
			String contactPerson, String email, String customerClassification) {
		customerRepository.updateCustomer(customerName, contactNumber, contactPerson, email, customerClassification);
	}

	public void editContactPerson(String customerName,
			String editContactPersonName, String contactEmail,
			String contactNumber, String editEmail, String editContactNumber) {
		contactPersonRepository.editContactPerson(customerName, editContactPersonName, contactEmail, contactNumber, editEmail, editContactNumber);
	}

	public Collection<Inquiry> getAllInquiriesbyCount() {
		return inquiryRepository.getAllInquiriesbyCount();
	}
	
}
