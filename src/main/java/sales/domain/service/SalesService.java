package sales.domain.service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class SalesService {
	@Autowired
	protected ApplicationContext context;
	
	
	@PersistenceContext
	protected EntityManager entityManager;
	
	
}
