package test;

import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.kie.api.runtime.rule.Agenda;

import beans.dsl.Account;
import beans.dsl.Customer;
import junit.framework.TestCase;

public class Taller4Test extends TestCase {

	public void testUpdate() {
		KieServices ks = KieServices.Factory.get();
		KieContainer kContainer = ks.getKieClasspathContainer();

		KieSession kSession = kContainer.newKieSession("KSession_Taller4");

		Agenda agenda = kSession.getAgenda();
		agenda.getAgendaGroup("agendaUpdate").setFocus();

		Customer customer2 = new Customer();
		customer2.setName("Adam Williams");
		customer2.setEnabled(true);
		customer2.setExpense(50D);

		Customer customer3 = new Customer();
		customer3.setName("William");
		customer3.setEnabled(false);
		customer3.setExpense(150D);

		kSession.insert(customer2);
		kSession.insert(customer3);

		kSession.fireAllRules();

		// NO DISCOUNT
		System.out.println(customer2.getDiscount());
		assertNull(customer2.getDiscount());

		// DISCOUNT 10%
		System.out.println(customer3.getDiscount());
		assertEquals(customer3.getDiscount(), 0.1D);

		kSession.dispose();

	}

	public void testAgendaGroupOne() {
		KieServices ks = KieServices.Factory.get();
		KieContainer kContainer = ks.getKieClasspathContainer();

		KieSession kSession = kContainer.newKieSession("KSession_Taller4");

		Agenda agenda = kSession.getAgenda();
		agenda.getAgendaGroup("one").setFocus();

		Customer customer2 = new Customer();
		customer2.setName("Adam Williams");
		customer2.setEnabled(true);

		Account ac1 = new Account();
		ac1.setAmount(100);
		customer2.getAccounts().add(ac1);

		Account ac2 = new Account();
		ac2.setAmount(500);
		customer2.getAccounts().add(ac2);

		Customer customer3 = new Customer();
		customer3.setName("William");
		customer3.setEnabled(false);

		kSession.insert(customer2);
		kSession.insert(customer3);

		kSession.insert(ac2);

		kSession.fireAllRules();

		assertNotNull(customer3);
		kSession.dispose();

	}

	public void testAgendaGroupTwo() {
		KieServices ks = KieServices.Factory.get();
		KieContainer kContainer = ks.getKieClasspathContainer();

		KieSession kSession = kContainer.newKieSession("KSession_Taller4");

		Agenda agenda = kSession.getAgenda();
		agenda.getAgendaGroup("two").setFocus();

		Customer customer2 = new Customer();
		customer2.setName("Adam Williams");
		customer2.setEnabled(true);

		Account ac1 = new Account();
		ac1.setAmount(100);
		customer2.getAccounts().add(ac1);

		Account ac2 = new Account();
		ac2.setAmount(500);
		customer2.getAccounts().add(ac2);

		Customer customer3 = new Customer();
		customer3.setName("William");
		customer3.setEnabled(false);

		kSession.insert(customer2);
		kSession.insert(customer3);

		kSession.insert(ac2);

		kSession.fireAllRules();

		assertNotNull(customer3);
		kSession.dispose();

	}

}
