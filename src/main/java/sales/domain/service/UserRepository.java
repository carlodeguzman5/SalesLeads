package sales.domain.service;

public interface UserRepository {

	String validateUser(String username, String password);

	void createUser(String username, String password);

}
