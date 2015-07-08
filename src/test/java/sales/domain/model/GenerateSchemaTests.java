package sales.domain.model;

import static org.junit.Assert.*;

import java.math.BigDecimal;
import java.util.Currency;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

@ContextConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
public class GenerateSchemaTests {

	@PersistenceContext
	private EntityManager entityManager;

	@Before
	public void setUp() throws Exception {
		assertNotNull(entityManager);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testGenerateSchema() throws Exception {
		entityManager.getMetamodel().entity(Email.class);
		System.out.println("Please check the resulting schema");
	}

	@Test
	public void testProduct() throws Exception {
		Email email = new Email("Adrian@gmail.com", "Inquiry for Training", "Is there an available training for JDBC?");
		entityManager.persist(email);
		entityManager.flush();
		Long productIdOfA = email.getId();
		Email retrievedEmailinquiry = entityManager.find(Email.class, productIdOfA);
		assertEquals(email, retrievedEmailinquiry);
	}

//	@Test
//	public void testProductPrices() throws Exception {
//		entityManager.persist(
//				new Product("A", new Money(USD, new BigDecimal(9.95))));
//		entityManager.persist(
//				new Product("B", new Money(USD, new BigDecimal(19.50))));
//		entityManager.persist(
//				new Product("A", new Money(JPY, new BigDecimal(99500))));
//		entityManager.flush();
//		TypedQuery<Product> query = entityManager.createQuery(
//				"SELECT p FROM Product p WHERE p.price.currency = 'USD'", Product.class);
//		List<Product> productsWithUsDollarPrices = query.getResultList();
//		assertThat(productsWithUsDollarPrices, hasSize(2));
//		for (Product product : productsWithUsDollarPrices) {
//			System.out.println(product);
//		}
//	}

}