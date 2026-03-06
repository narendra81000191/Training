package cofg.Day6;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString


public class Account {
	private  long Accounno;
	private String Name;
	private String BranchName;
	private double Balance;
	public void withdraw(double  amount) {
		if(amount>=this.Balance)
			{System.out.println("withdrw amount");
			
		    this.Balance=-amount;
		     }
		else
			System.out.println("withdrw failed");
		
			
	}
	public void deposit(double amount) {
		this.Balance=+amount;
		System.out.println("amount deposited");
	}

}
