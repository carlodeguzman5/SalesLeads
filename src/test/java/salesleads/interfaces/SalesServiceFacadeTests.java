package salesleads.interfaces;

import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import sales.domain.model.Call;
import sales.domain.model.Customer;
import sales.domain.model.CustomerClassification;
import sales.domain.model.Email;
import sales.domain.model.InquiryType;
import sales.domain.model.PersonalVisit;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration
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
		InquiryType training = new InquiryType("Training");
		InquiryType development = new InquiryType("Development");
		entityManager.persist(training);
		entityManager.persist(development);
	}
	
	@Override
	protected void setUpInquiries() {
		Call globeInquiry = new Call("09051234567", "Inquiry for Training", "Is there an available training for JDBC?", entityManager.find(InquiryType.class, "Training"));
		Email wilconInquiry = new Email("adrian@gmail.com", "Inquiry for Software Development", "Are you willing to develop an inventory software?", entityManager.find(InquiryType.class, "Development"));
		PersonalVisit accountantInquiry = new PersonalVisit("Henry Antonio", "Inquiry for Software Development", "Are you willing to develop software for recording purposes?", entityManager.find(InquiryType.class, "Development"));
		entityManager.persist(globeInquiry);
		entityManager.persist(wilconInquiry);
		entityManager.persist(accountantInquiry);
	}

}
