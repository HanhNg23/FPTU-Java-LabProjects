package items;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;


/* This class is a Java Persistence API entity that
 * define a phone bill in the batch application.
 */

@Entity
public class PhoneBill implements Serializable{

	private String phoneNumber;
	
	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
	@OrderBy("datetime ASC")
	private List<CallRecord> calls;
	private BigDecimal amountBase;
	private BigDecimal taxRate;
	private BigDecimal tax;
	private BigDecimal amountTotal;
	private static final long serialVersionUID = -7617311744533479326L;
	
	public PhoneBill() {
		
	}
	
	public PhoneBill(String number) {
		this.phoneNumber = number;
		calls = new ArrayList<>();
	}
	
	public void addCall(CallRecord call) {
		calls.add(call);
	}
	public void calculate(BigDecimal taxRate) {
		/*Compute the total amount and tax*/
		this.taxRate = taxRate;
		amountBase = new BigDecimal(0).setScale(2);
		for(CallRecord call: calls) {
			//amountBase = amountBase.add(call.getPrice());
			TreeMap<K, V>
		}
	}
	
	
}
