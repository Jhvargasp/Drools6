/**
 * 
 */
package beans.dsl;

/**
 * @author jorgvapu
 *
 */
public class Account {

	public Account() {
		id=Math.random()+"";
	}
	
	private String id;
	private double amount;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	
}
