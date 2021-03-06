import java.util.Date;
import java.util.Scanner;

public class CheckingAccount extends Account
{
	public CheckingAccount(User user, float initDeposit) 
	{
		NumCnt = NumCnt + 1; //incrementing account no# at each new creation
		
		accountNum = NumCnt; //Assigning NumCnt to accountNum
		
		dateCreated = new Date();//Getting system date and time
		
		Name = user.getName();  //Getting user name from user object
		
		this.user = user;
		
		this.user.setCheckAcc(this);
		
		balance = initDeposit;//setting initial deposit	
		
	}
	
	/**
	 * 
	 * @param float deposit amount 
	 */
	public void makeDeposit(float deposit) 
	{
		if( deposit > 0 ) 
		{
			balance += deposit;
			balance -= transactionFees; //deducting transaction fees
			totalDeductions += transactionFees;//adding in total transaction fees taken
		
			this.printStatement(deposit);
		}
		else 
		{
			System.out.println("INVALID DEPOSIT AMOUNT !");
		}
		
	}
	
	/**
	 * 
	 * @param float withrawing amount
	 */
	public void makeWithdrawal(float amount) 
	{
		//Withdrawal can proceed uptil account is -5000 in debt
		if( this.balance-amount >= -5000) 
		{
			balance -= amount;
			balance -= transactionFees; //deducting transaction fees
			totalDeductions += transactionFees;//adding in total transaction fees taken
		
			
			this.printStatement(amount);
		}
		else 
		{
			System.out.println("TRANSACTION FAILED ! \n (Max debt reached)\n");
		}
		
	}
	

	
	
	public void displayAllDeductions() 
	{
		
		float tax = ( (balance*(float)4) / 100 );
		

		System.out.println("Total Tax deducted : " + Float.toString(tax) + " PKR" + '\n');
	
	}
	
	
	protected float transactionFees = 10;
	
		
}
