package sales.infrastructure.jpa;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import sales.domain.model.ContactPerson;
import sales.domain.model.ContactPersonRepository;
import sales.domain.model.Customer;

@Repository
@Transactional
public class JpaContactPersonRepository implements ContactPersonRepository {

	private static final String JPQL_GET_CONTACT_PERSON = "SELECT a FROM ContactPerson a WHERE " 
			+ "a.name = :name "
			+ "AND a.contactNumber = :contactNumber "
			+ "AND a.email = :contactEmail";
	
	@PersistenceContext
	protected EntityManager entityManager;
	
	public void editContactPerson(String customerName,
			String editContactPersonName, String contactEmail,
			String contactNumber, String editEmail, String editContactNumber) {
		//Customer customer = entityManager.find(Customer.class, customerName);
		//System.out.println(editContactPersonName + contactEmail + "contactNumber: " + contactNumber);
		ContactPerson person = entityManager.createQuery(JPQL_GET_CONTACT_PERSON, ContactPerson.class)
				.setParameter("name", editContactPersonName)
				.setParameter("contactNumber", contactNumber)
				.setParameter("contactEmail", contactEmail)
				.getSingleResult();
		
		person.setContactNumber(editContactNumber);
		person.setEmail(editEmail);
		
		entityManager.persist(person);
		entityManager.flush();
	}

}
