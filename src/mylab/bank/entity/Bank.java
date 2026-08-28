package mylab.bank.entity;

import java.util.ArrayList;
import java.util.List;

public class Bank {
	
	private List<Account> accounts;
	private int nextAccountNumber;

	public Bank() {
		this.accounts = new ArrayList<>();
		this.nextAccountNumber = 1000;
	}
	//저축(Savings) 계좌와 체킹(Checking) 계좌 생성
	
	
}
