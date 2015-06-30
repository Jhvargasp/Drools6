package test;

import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;

import beans.dsl.Account;
import beans.dsl.Customer;
import junit.framework.TestCase;

public class Taller5_1Test extends TestCase {
	
	static KieSession session ;
	@Override
	protected void setUp() throws Exception {
		KieServices ks = KieServices.Factory.get();
		KieContainer kContainer = ks.getKieClasspathContainer();


		session = kContainer.newKieSession("KSession_Taller5");
	}
	
	public static void testFirstCase(){
		  boolean registered = false;
		  Customer karen = new Customer("KAREN", registered, new Double(1800d));
		  session.insert(karen);
		  session.fireAllRules();
		  assertNotNull(karen.getDiscount());
		 }

		/**
		 * Customer: Mac
		 * Expense lesser than 1000
		 * registered = false
		 * 
		 * Discount:0%
		 * 
		 */

		
		public static void testSecondCase(){
		  boolean registered = false;
		    Customer mac = new Customer("MAC", registered, new Double(180d));
		    session.insert(mac);
		  session.fireAllRules();
		  assertNull(mac.getDiscount());
		}

		/**
		 * Customer: John 
		 * Expense greater than 1000
		 * registered = true
		 * 
		 * Discount:15%
		 * 
		 */
		
		public  void testThirdCase(){
		  boolean registered = true;
		  Customer john = new Customer("JOHN", registered, new Double(4000d));
		  session.insert(john);
		  session.fireAllRules();
		 assertNotNull(john.getDiscount());
		  
		}
	
	
		@Override
		protected void finalize() throws Throwable {
			session.dispose();
		}
}
