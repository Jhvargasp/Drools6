package test;

import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;

import beans.dsl.Account;
import beans.dsl.AccountService;
import beans.dsl.Customer;
import junit.framework.TestCase;

public class Taller2Test extends TestCase {

	public void test() {
		KieServices ks = KieServices.Factory.get();
		KieContainer kContainer = ks.getKieClasspathContainer();


		KieSession kSession = kContainer.newKieSession("KSession2_1");

		AccountService service=new AccountService();
		kSession.setGlobal(FILL_HERE, FILL_HERE);
		
		
		Account account1=new Account();
		account1.setAmount(100);
		
		Customer customer1=new Customer();
		customer1.setName("John Smith");
		customer1.setEnabled(true);
		customer1.getAccounts().add(account1);
		
		Customer customer2=new Customer();
		customer2.setName("Adam Willis");
		customer2.setEnabled(false);
		
		Customer customer3=new Customer();
		customer3.setName("William");
		customer3.setEnabled(false);
		
		kSession.insert(customer1);
		kSession.insert(customer2);
		kSession.insert(customer3);
		
		
		kSession.fireAllRules();
		kSession.dispose();
		assertEquals(customer3.getName(), customer3.getName());
		
	}

}
