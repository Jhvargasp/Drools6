package beans.dsl;

import java.util.ArrayList;
import java.util.List;

public class Customer {

	private String name;
	private boolean registered;
	private Double expense;
	private Double discount;
	private boolean enabled;

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	public List<Account> getAccounts() {
		if (accounts == null)
			accounts = new ArrayList<Account>();
		return accounts;
	}

	public void setAccounts(List<Account> accounts) {
		this.accounts = accounts;
	}

	private List<Account> accounts;

	public String toString() {
		return name + ", " + registered + ", " + expense + ", " + discount;
	}

	public Customer() {

	}

	public Customer(String name, boolean registered, Double expense) {
		this.name = name;
		this.registered = registered;
		this.expense = expense;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean isRegistered() {
		return registered;
	}

	public void setRegistered(boolean registered) {
		this.registered = registered;
	}

	public Double getExpense() {
		return expense;
	}

	public void setExpense(Double expense) {
		this.expense = expense;
	}

	public Double getDiscount() {
		return discount;
	}

	public void setDiscount(Double discount) {
		this.discount = discount;
	}

	public void setDiscount(int discount) {
		this.discount = new Double(discount);
	}

}