package beans.dsl;

import java.util.Arrays;
import java.util.List;

import org.drools.core.event.BeforeActivationFiredEvent;
import org.kie.api.KieServices;
import org.kie.api.definition.rule.Rule;
import org.kie.api.event.rule.DefaultAgendaEventListener;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;

public class TestDSL {


	public static void main(String[] args) {
		try {
			KieServices ks = KieServices.Factory.get();
			KieContainer kContainer = ks.getKieClasspathContainer();
			KieSession kSession = kContainer.newKieSession("KSession_Taller5");
			kSession.addEventListener(new EventListener());
			testFirstCase(kSession);
			testSecondCase(kSession);
			testThirdCase(kSession);
		}catch(Exception ex){
			ex.printStackTrace();
		}

	}

	
	public static void testFirstCase(KieSession session){
		  boolean registered = false;
		  Customer karen = new Customer("KAREN", registered, new Double(1800d));
		  session.insert(karen);
		  session.fireAllRules();
		  System.out.println("1."+karen.getDiscount());
		  System.out.println( karen.getDiscount());
		 }

		/**
		 * Customer: Mac
		 * Expense lesser than 1000
		 * registered = false
		 * 
		 * Discount:0%
		 * 
		 */

		
		public static void testSecondCase(KieSession session){
		  boolean registered = false;
		    Customer mac = new Customer("MAC", registered, new Double(180d));
		    session.insert(mac);
		  session.fireAllRules();
		  System.out.println("2."+mac.getDiscount());
		}

		/**
		 * Customer: John 
		 * Expense greater than 1000
		 * registered = true
		 * 
		 * Discount:15%
		 * 
		 */
		
		public static void testThirdCase(KieSession session){
		  boolean registered = true;
		  Customer john = new Customer("JOHN", registered, new Double(4000d));
		  session.insert(john);
		  session.fireAllRules();
		  System.out.println("3."+john.getDiscount());
		  System.out.println( john.getDiscount());
		}
	
}
