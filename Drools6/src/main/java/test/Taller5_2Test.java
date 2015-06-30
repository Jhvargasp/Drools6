package test;

import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;

import beans.dsl.Account;
import beans.dsl.Customer;
import junit.framework.TestCase;

public class Taller5_2Test extends TestCase {

	static KieSession session;

	@Override
	protected void setUp() throws Exception {
		KieServices ks = KieServices.Factory.get();
		KieContainer kContainer = ks.getKieClasspathContainer();

		session = kContainer.newKieSession("KSession_Taller5_2");
	}

	public static void testFirstCase() {
		boolean registered = false;
		Customer karen = new Customer("KAREN", registered, new Double(1800d));
		session.insert(karen);
		session.fireAllRules();
		System.out.println(karen.getDiscount());
		assertNotNull(karen.getDiscount());
	}

	/**
	 * Customer: Mac Expense lesser than 1000 registered = false
	 * 
	 * Discount:0%
	 * 
	 */

	public static void testSecondCase() {
		boolean registered = false;
		Customer mac = new Customer("MAC", registered, new Double(180d));
		session.insert(mac);
		session.fireAllRules();
		System.out.println(mac.getDiscount());
		assertNull(mac.getDiscount());
	}
	
	/**
	 * Customer: Mac Expense lesser than 1000 registered = false
	 * 
	 * Discount:0%
	 * 
	 */

	public static void testThirdCase() {
		boolean registered = true;
		Customer mac = new Customer("MAC2", registered, new Double(2200d));
		session.insert(mac);
		session.fireAllRules();
		System.out.println(mac.getDiscount());
		assertNotNull(mac.getDiscount());
		
	}

	@Override
	protected void finalize() throws Throwable {
		session.dispose();
	}
}
