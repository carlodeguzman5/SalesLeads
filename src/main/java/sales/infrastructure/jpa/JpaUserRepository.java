package sales.infrastructure.jpa;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import sales.domain.service.UserRepository;
import sales.domain.model.User;

@Repository
public class JpaUserRepository implements UserRepository {

	@PersistenceContext
	protected EntityManager entityManager;
	
	public String validateUser(String username, String password){
		User user;
		try{
			System.out.println(username);
			entityManager.find(User.class, username);			
		}
		catch(NullPointerException e){
			System.out.println("null");
			return "Username does not exist!";
		}
		
		user = entityManager.find(User.class, username);
		
		if(password.equals(user.getPassword())){
			return "valid";
		}
		return "Wrong password.";
	}

}
