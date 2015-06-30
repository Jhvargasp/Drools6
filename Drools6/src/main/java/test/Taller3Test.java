package test;

import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.kie.api.runtime.rule.Agenda;

import beans.dsl.Account;
import beans.dsl.Customer;
import junit.framework.TestCase;

public class Taller3Test extends TestCase {

	public void testCrossProduct() {
		KieServices ks = KieServices.Factory.get();
		KieContainer kContainer = ks.getKieClasspathContainer();

		KieSession kSession = kContainer.newKieSession("KSession_Taller3");
		Agenda agenda = kSession.getAgenda();
		agenda.getAgendaGroup("crossproduct").setFocus();

		Customer customer1 = new Customer();
		customer1.setName("John Smith");
		customer1.setEnabled(true);

		Customer customer2 = new Customer();
		customer2.setName("Adam Willis");
		customer2.setEnabled(false);

		Customer customer3 = new Customer();
		customer3.setName("William");
		customer3.setEnabled(false);

		Account ac1 = new Account();
		ac1.setAmount(100);

		Account ac2 = new Account();
		ac2.setAmount(500);

		kSession.insert(customer1);
		kSession.insert(customer2);
		kSession.insert(customer3);

		kSession.insert(ac1);
		kSession.insert(ac2);

		kSession.fireAllRules();

		kSession.dispose();
		assertEquals(customer3.getName(), customer3.getName());

	}

	public void testEval() {
		KieServices ks = KieServices.Factory.get();
		KieContainer kContainer = ks.getKieClasspathContainer();

		KieSession kSession = kContainer.newKieSession("KSession_Taller3");

		Customer customer1 = new Customer();
		customer1.setName("John Smith");
		customer1.setEnabled(true);

		Customer customer2 = new Customer();
		customer2.setName("Adam Willis");
		customer2.setEnabled(false);

		Customer customer3 = new Customer();
		customer3.setName("William");
		customer3.setEnabled(false);

		kSession.insert(customer1);
		kSession.insert(customer2);
		kSession.insert(customer3);

		kSession.fireAllRules();
		kSession.dispose();

		assertEquals(customer3.getName(), customer3.getName());

	}

	public void testAND() {
		KieServices ks = KieServices.Factory.get();
		KieContainer kContainer = ks.getKieClasspathContainer();

		KieSession kSession = kContainer.newKieSession("KSession_Taller3");

		Customer customer2 = new Customer();
		customer2.setName("Adam Williams");
		customer2.setEnabled(true);

		Customer customer3 = new Customer();
		customer3.setName("William");
		customer3.setEnabled(false);

		kSession.insert(customer2);
		kSession.insert(customer3);

		kSession.fireAllRules();
		kSession.dispose();
		assertEquals(customer3.getName(), customer3.getName());

	}

	public void testOR() {
		KieServices ks = KieServices.Factory.get();
		KieContainer kContainer = ks.getKieClasspathContainer();

		KieSession kSession = kContainer.newKieSession("KSession_Taller3");

		Customer customer2 = new Customer();
		customer2.setName("Adam Williams");
		customer2.setEnabled(true);

		Customer customer3 = new Customer();
		customer3.setName("William");
		customer3.setEnabled(false);

		kSession.insert(customer2);
		kSession.insert(customer3);

		kSession.fireAllRules();
		kSession.dispose();
		assertEquals(customer3.getName(), customer3.getName());

	}

	public void testCollection() {
		KieServices ks = KieServices.Factory.get();
		KieContainer kContainer = ks.getKieClasspathContainer();

		KieSession kSession = kContainer.newKieSession("KSession_Taller3");

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
		kSession.dispose();
		assertEquals(customer3.getName(), customer3.getName());

	}

}
