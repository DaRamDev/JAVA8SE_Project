package workshop.account.control;

import workshop.account.entity.*;

public class AccountTest {
	public static void main(String[] args) {
	Account account = new Account();	
	
	//고객번호 : “A1100”, 계좌번호 : “221-22-3477”, 잔액 : 100000
	account.setCustId(“A1100”);
	account.setAcctId(“221-22-3477”);
	account.deposit(100000);
	
	System.out.println();
	}
}
