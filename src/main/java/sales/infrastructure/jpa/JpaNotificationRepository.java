package sales.infrastructure.jpa;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.apache.commons.lang3.time.DateUtils;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import sales.domain.model.CustomerInquiry;
import sales.domain.model.Event;
import sales.domain.model.Notification;
import sales.domain.model.NotificationRepository;

@Repository
@Transactional
public class JpaNotificationRepository implements NotificationRepository {

	private EntityManager entityManager;

	@PersistenceContext
	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}
	
	private static final String JPQL_GET_NOTIFICATION = "SELECT a FROM Notification AS a WHERE a.customerInquiry = :customerInquiry";	
	private static final String JPQL_GETALL_NOTIFICATION = "SELECT a FROM Notification a ORDER BY a.date DESC";
	
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
	
	public void updateNotification(CustomerInquiry customerInquiry, Event event) {
		try{
			TypedQuery<Notification> query = entityManager.createQuery(JPQL_GET_NOTIFICATION, Notification.class)
					.setParameter("customerInquiry", customerInquiry);
			
			Notification pastNotification = query.getSingleResult();
			entityManager.remove(pastNotification);
			entityManager.flush();
			System.out.println("does not exist");
		}
		catch(Exception e){System.out.println("does exist");}
		
		String customerName = customerInquiry.getCustomer().getName();
		String dateOfLastEvent = new SimpleDateFormat("dd/MM/yyyy").format(event.getDate());
		System.out.println(event.getDate());
		String message = "Last transaction with " + customerName + " was " + dateOfLastEvent;
		
        Date original = event.getDate();
        Calendar cal = Calendar.getInstance();
        cal.setTimeInMillis(original.getTime());
        cal.add(Calendar.HOUR, customerInquiry.getNotificationSpan());
        Date notifyOn = new Date(cal.getTime().getTime());
		
		Notification notification = new Notification(message, notifyOn, customerInquiry);
		entityManager.persist(notification);
		entityManager.flush();
	}

	public List<Notification> getNotifications() {
		List<Notification> notifs = new ArrayList<Notification>();
		System.out.println("getting notifs..");
		
		try{
			TypedQuery<Notification> query = entityManager.createQuery(JPQL_GETALL_NOTIFICATION, Notification.class);	
			List<Notification> allNotification = query.getResultList();
			
			for(Notification n : allNotification){
				System.out.println("notif" + n.getDate() + " " + today());
				if(n.getDate().before(today()) || DateUtils.isSameDay(n.getDate(), today())){
					System.out.println("Id: " + n.getId());
					notifs.add(n);
				}
			}
		}
		catch(Exception e){System.out.println("does exist");}
		
		return notifs;
	}

}
