package sales.infrastructure.jpa;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Date;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import sales.domain.model.Customer;
import sales.domain.model.CustomerClassification;
import sales.domain.model.CustomerInquiry;
import sales.domain.model.CustomerInquiryRepository;
import sales.domain.model.CustomerRepository;
import sales.domain.model.Event;
import sales.domain.model.EventRepository;
import sales.domain.model.Inquiry;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:sales/interfaces/GenerateSchemaTests-context.xml"})
@Transactional
public class JpaEventRepositoryTests {

	@Autowired
	private EventRepository eventRepository;
	@Autowired
	private CustomerInquiryRepository customerInquiryRepository;
	@Autowired
	private CustomerRepository customerRepository;
	
	@Before
	public void setUp(){
		

	}
	@After
	public void tearDown(){

	}
	
	@Test
	public void getInitialEventInTimelineTest(){
		CustomerClassification classification = new CustomerClassification("Food");
		Customer customer = new Customer("McDo", classification);
		Inquiry inquiry = new Inquiry("Development");
		customerInquiryRepository.createCustomerInquiry(customer, inquiry, "Subject", "Message", new Date());
		CustomerInquiry customerInquiry = customerRepository.getAllCustomerInquiries().get(0);
		Event timeline = eventRepository.createEvent("Meeting","Talked about food", new Date());
		customerInquiry.setTimeline(timeline);
		Event event = eventRepository.getEvent(customerInquiry);
		
		assertEquals("Meeting", event.getTitle());
		assertEquals("Talked about food", event.getContent());
	}
	
	@Test
	public void getLastEvent(){
		CustomerClassification classification = new CustomerClassification("Food");
		Customer customer = new Customer("McDo", classification);
		Inquiry inquiry = new Inquiry("Development");
		customerInquiryRepository.createCustomerInquiry(customer, inquiry, "Subject", "Message", new Date());
		CustomerInquiry customerInquiry = customerRepository.getAllCustomerInquiries().get(0);
		Event timeline = eventRepository.createEvent("Meeting","Talked about food", new Date());
		
		eventRepository.appendEvent(customerInquiry, timeline);
		
		Event appendedEvent = eventRepository.createEvent("Email", "Inquiries about price", new Date());
		eventRepository.appendEvent(customerInquiry, appendedEvent);
		
		Event appendedEvent2 = eventRepository.createEvent("Project End", "Project has been dropped", new Date());
		eventRepository.appendEvent(customerInquiry, appendedEvent2);
		
		Event lastEvent = eventRepository.getLastEventOf(customerInquiry);
		
		assertEquals("Project End", lastEvent.getTitle());
	}
	
}
