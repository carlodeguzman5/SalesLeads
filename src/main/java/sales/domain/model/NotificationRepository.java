package sales.domain.model;

import java.util.List;

public interface NotificationRepository {

	void updateNotification(CustomerInquiry customerInquiry, Event event);

	List<Notification> getNotifications();

}
