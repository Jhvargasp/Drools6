package test;

import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.kie.api.runtime.StatelessKieSession;
import org.kie.api.runtime.rule.Agenda;

import beans.dsl.Account;
import beans.dsl.Customer;
import beans.dsl.EventListener;
import junit.framework.TestCase;

public class Taller7Test extends TestCase {

	
	
	
	public void testStatefull() {
		KieServices ks = KieServices.Factory.get();
		KieContainer kContainer = ks.getKieClasspathContainer();


		KieSession kSession = kContainer.newKieSession("t7Statefull");
		
		//call an instance of beans.dsl.EventListener
		//you can edit this class for show info required
		kSession.addEventListener(FILL_HERE);

		
		Customer customer2=new Customer();
		customer2.setName("Adam Williams");
		customer2.setEnabled(true);
		customer2.setExpense(50D);
		
		
		
		kSession.insert(customer2);
		
		kSession.fireAllRules();
		
		//NO DISCOUNT
		System.out.println(customer2.getDiscount());
		assertNotNull(customer2.getDiscount());
		
		
	
		kSession.dispose();
	}
	
	
}
