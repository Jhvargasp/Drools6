package beans.dsl;

import beans.dsl.Customer;

public class AccountService {

	public void logCustomer(Customer c) {
		System.out.println("*******Account service LOG for " + c.getName());

	}

}
