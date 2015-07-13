package sales.interfaces;

import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import sales.domain.model.Customer;
import sales.domain.model.CustomerClassification;
import sales.domain.model.Inquiry;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:sales/interfaces/SalesServiceTests-context.xml"})
public class SalesServiceFacadeTests extends AbstractSalesServiceFacadeTests{
	
	@Override
	protected void setUpCustomerClassifications() {
		CustomerClassification telCom = new CustomerClassification("Telecommunications");
		CustomerClassification hardware = new CustomerClassification("Hardware");
		CustomerClassification accountancy = new CustomerClassification("Accounting Firm");
		entityManager.persist(telCom);
		entityManager.persist(hardware);
		entityManager.persist(accountancy);
	}
	
	@Override
	protected void setUpCustomers() { 
		Customer globe = new Customer("Globe", "Adrian Adame", entityManager.find(CustomerClassification.class, "Telecommunications"));
		Customer wilcon = new Customer("Wilcon", "Adrian Adame", entityManager.find(CustomerClassification.class, "Hardware"));
		Customer accountant = new Customer("R.G. Manabat & Co.", "Henry Antonio", entityManager.find(CustomerClassification.class, "Accounting Firm"));
		entityManager.persist(globe);
		entityManager.persist(wilcon);
		entityManager.persist(accountant);
	}

	@Override
	protected void setUpInquiryTypes() {
		Inquiry training = new Inquiry("Training");
		Inquiry development = new Inquiry("Development");
		entityManager.persist(training);
		entityManager.persist(development);
	}
	
	@Override
	protected void setUpInquiries() {
		Inquiry training = new Inquiry("Training");//"carlo@gmail.com", "Inquiry for Training", "Is there an available training for JDBC?", "Training");
		Inquiry development = new Inquiry("Development");//adrian@gmail.com", "Inquiry for Software Development", "Are you willing to develop an inventory software?", "Development");
		// Inquiry accountantInquiry = new Inquiry("kd@gmail.com", "Inquiry for Software Development", "Are you willing to develop software for recording purposes?", "Development");
		entityManager.persist(training);
		entityManager.persist(development);
	}

}
