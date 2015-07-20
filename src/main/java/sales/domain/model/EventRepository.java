package sales.domain.model;

import java.util.Collection;

public interface EventRepository {

	Event getEvent(CustomerInquiry customerInquiry);
	Event createEvent(String title, String content);
	Collection<Event> getAllEventsAfter(Event event);
	Event getLastEventOf(CustomerInquiry customerInquiry);
	void appendEvent(CustomerInquiry customerInquiry, Event after);
	
}
