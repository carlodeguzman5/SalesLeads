package sales.infrastructure.jpa;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import sales.domain.service.UserRepository;
import sales.user.User;

@Repository
public class JpaUserRepository implements UserRepository {

	@PersistenceContext
	protected EntityManager entityManager;
	
	public String validateUser(String username, String password) {
		User user = entityManager.find(User.class, username);
		if(user==null){
			return "Username does not exist!";
		}
		else if(password.equals(user.getPassword())){
			return "valid";
		}
		return "Wrong password.";
	}

}
