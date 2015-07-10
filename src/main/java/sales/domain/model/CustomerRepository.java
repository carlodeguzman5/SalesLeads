package sales.domain.model;

public interface CustomerRepository {

	Customer findByCustomerName(String name);
}
