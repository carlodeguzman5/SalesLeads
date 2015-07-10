package sales.domain.service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import sales.domain.model.Customer;
import sales.domain.model.Customer_Inquiry;
import sales.domain.model.Inquiry;
import sales.interfaces.SalesServiceFacade;

@Service
public class SalesService implements SalesServiceFacade{
	
	@Autowired
	protected ApplicationContext context;
	
	@PersistenceContext
	protected EntityManager entityManager;


	public void inquire(Customer customer, Inquiry inquiry) {
		Customer_Inquiry ci = new  Customer_Inquiry(customer, inquiry);
		entityManager.persist(ci);
	}


	public void findAllByCustomer(Customer customer, Inquiry inquiry) {
		// TODO Auto-generated method stub
		
	}
	

}
