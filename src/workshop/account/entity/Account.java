package workshop.account.entity;

import workshop.account.exception.InsufficientBalanceException;

public class Account {
	private String custId;
	private String acctId;
	private int balance;
	
	//기본 생성자
	public Account() {
		System.out.println("Account 기본 생성자 호출");
	}
	
	//오버로딩
	public Account(String custId, String acctId, int balance) {
		System.out.println("오버로딩된 생성자 호출");
		this.custId = custId;
		this.acctId = acctId;
		this.balance = balance;
	}

	public String getCustId() {
		return custId;
	}
	public void setCustId(String custId) {
		this.custId = custId;
	}
	public String getAcctId() {
		return acctId;
	}

	public void setAcctId(String acctId) {
		this.acctId = acctId;
	}
	public int getBalance() {
		return balance;
	}
	public void setBalance(int balance) {
		this.balance = balance;
	}
	
	//입금
	public void deposit(int amount) {
		this.balance += amount;
	}
	//출금
	public void withdraw(int amount) 
		throws InsufficientBalanceException{
		if(amount > balance) {
			//exception을 강제 발생
			throw new InsufficientBalanceException
			("잔액부족", this.balance);
		}
		this.balance -= amount;
	}
	@Override
	public String toString() {
		return "Account [custId=" + custId + ", "
				+ "acctId=" + acctId + ", "
						+ "balance=" + balance + "]";
	}
	
	
	
}
