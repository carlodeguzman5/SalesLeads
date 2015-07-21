package sales.domain.model;

import java.util.ArrayList;
import java.util.Collection;

public interface EventRepository {

	Event getEvent(CustomerInquiry customerInquiry);
	Event createEvent(String title, String content);
	ArrayList<Event> getAllEventsOf(CustomerInquiry customerInquiry);
	Event getLastEventOf(CustomerInquiry customerInquiry);
	void appendEvent(CustomerInquiry customerInquiry, Event after);
	
}
