package sales.infrastructure.jpa;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import sales.domain.model.Inquiry;
import sales.domain.model.InquiryRepository;

@Repository
@Transactional
public class JpaInquiryRepository implements InquiryRepository {
	

	private EntityManager entityManager;

	@PersistenceContext
	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}
	
	public Inquiry getInquiryByName(String inquiry) throws NoExistingInquiryException {
		try{
			return entityManager.find(Inquiry.class, inquiry);
		}catch(RuntimeException e){
			throw new NoExistingInquiryException(e);
			
		}
	}

	public void createInquiry(String inquiry) {
		entityManager.persist(new Inquiry(inquiry));
		entityManager.flush();
	}
	
	
	public List<String> getAllInquiries(){
		Collection<Inquiry> inquiries = entityManager.createNativeQuery("SELECT * FROM INQUIRY", Inquiry.class).getResultList();
		
		List<String> inquiryTypes = new ArrayList();
		
		for(Inquiry inquiry : inquiries){
			inquiryTypes.add(inquiry.getType());
		}
		
		return inquiryTypes;
	}

}
