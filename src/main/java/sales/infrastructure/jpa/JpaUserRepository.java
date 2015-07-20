package sales.infrastructure.jpa;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import sales.domain.service.UserRepository;
import sales.domain.model.User;

@Repository
@Transactional
public class JpaUserRepository implements UserRepository {

	@PersistenceContext
	protected EntityManager entityManager;
	
	public String validateUser(String username, String password){
		User user;
		try{
			user = entityManager.find(User.class, username);
			
			if(password.equals(user.getPassword())){
				return "valid";
			}
			return "Wrong password.";
		}
		catch(Exception e){
			return "Username does not exist!";
		}
	}

	public void createUser(String username, String password) {
		entityManager.persist(new User(username, password));
		entityManager.flush();
	}

}
