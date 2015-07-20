package sales.infrastructure.jpa;

import java.util.Collection;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import sales.domain.model.CustomerInquiry;
import sales.domain.model.Event;
import sales.domain.model.EventRepository;

@Repository
@Transactional
public class JpaEventRepository implements EventRepository {

	private static final String SQL_EVENT_BY_CUSTOMER_INQUIRY = "SELECT * FROM EVENT_T WHERE EVENT_ID LIKE ?";
	
	@PersistenceContext
	protected EntityManager entityManager;
	
	public Event getEvent(CustomerInquiry customerInquiry) {
		return (Event) entityManager.createNativeQuery(SQL_EVENT_BY_CUSTOMER_INQUIRY, Event.class)
		.setParameter(1, customerInquiry.getTimeline())
		.getSingleResult();
	}
	
	public Event createEvent(String title, String content){
		Event event = new Event(title, content);
		entityManager.persist(event);
		entityManager.flush();
		return event;
	}
	
	public void appendEvent(CustomerInquiry customerInquiry, Event eventAfter){
		Event lastEvent = getLastEventOf(customerInquiry);
		if(lastEvent == null){
			customerInquiry.setTimeline(eventAfter);
			entityManager.persist(customerInquiry);
		}
		else{
			lastEvent.setAfter(eventAfter);
			entityManager.persist(lastEvent);
		}
		entityManager.flush();
	}

	public Collection<Event> getAllEventsAfter(Event event) {
		// TODO Auto-generated method stub
		return null;
	}

	public Event getLastEventOf(CustomerInquiry customerInquiry) {
		
		/*try{
			startEvent = (Event) entityManager.createNativeQuery(SQL_EVENT_BY_CUSTOMER_INQUIRY)
			.setParameter(1, customerInquiry.getTimeline())
			.getSingleResult();
		}catch(RuntimeException e){
			return null;
		}*/
		
		Event startEvent = customerInquiry.getTimeline();
		if(startEvent == null){
			return null;
		}
			
		Event tempEvent = startEvent;
		
		while(tempEvent.getAfter() != null){
			tempEvent = tempEvent.getAfter();
		}

		return tempEvent;
	}

}
