package test;

import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.kie.api.runtime.StatelessKieSession;
import org.kie.api.runtime.rule.Agenda;

import beans.dsl.Account;
import beans.dsl.Customer;
import junit.framework.TestCase;

public class Taller6Test extends TestCase {

	
	public void testStateless() {
		KieServices ks = KieServices.Factory.get();
		KieContainer kContainer = ks.getKieClasspathContainer();


		StatelessKieSession sess= kContainer.getKieBase("rules6").newStatelessKieSession();
		
		Customer customer2=new Customer();
		customer2.setName("Adam Williams");
		customer2.setEnabled(true);
		customer2.setExpense(50D);
		
		sess.FILL_HERE(customer2);
		
		Customer customer3=new Customer();
		customer3.setName("William");
		customer3.setEnabled(false);
		customer3.setExpense(150D);
		
		
		sess.FILL_HERE(customer3);
		
		
		//NO DISCOUNT
		System.out.println(customer2.getDiscount());
		assertNotNull(customer2.getDiscount());
		
		//DISCOUNT 10%
		System.out.println(customer3.getDiscount());
		assertEquals(customer3.getDiscount(),0.1D);
		
		
		
		
	}
	
	
	public void testStatefull() {
		KieServices ks = KieServices.Factory.get();
		KieContainer kContainer = ks.getKieClasspathContainer();


		KieSession kSession = kContainer.newKieSession("t6Statefull");
		
		
		Customer customer2=new Customer();
		customer2.setName("Adam Williams");
		customer2.setEnabled(true);
		customer2.setExpense(50D);
		
		
		Customer customer3=new Customer();
		customer3.setName("William");
		customer3.setEnabled(false);
		customer3.setExpense(150D);
		
		kSession.FILL_HERE(customer2);
		kSession.FILL_HERE(customer3);
		
		kSession.FILL_HERE();
		
		//NO DISCOUNT
		System.out.println(customer2.getDiscount());
		assertNotNull(customer2.getDiscount());
		
		//DISCOUNT 10%
		System.out.println(customer3.getDiscount());
		assertEquals(customer3.getDiscount(),0.1D);
	
		kSession.dispose();
	}
	
	
}
