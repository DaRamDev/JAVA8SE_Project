package mylab.bank.entity;

import mylab.bank.exception.InsufficientBalanceException;

// 모든 계좌의 기본이 되는 추상 클래스
public abstract class Account {
    private String accountNumber; // 계좌번호
    private String ownerName;     // 소유자 이름
    private double balance;       // 잔액

    // 1. 3개 인자를 받는 생성자 (이 부분이 없어서 super(...) 에러가 났던 것입니다)
    public Account(String accountNumber, String ownerName, double balance) {
        this.accountNumber = accountNumber;
        this.ownerName = ownerName;
        this.balance = balance;
    }

    // 2. Getter / Setter 메서드들
    public String getAccountNumber() {
        return accountNumber;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    // 3. 입금 메서드
    public void deposit(double amount) {
        this.balance += amount;
        System.out.println(amount + "원이 입금되었습니다. 현재 잔액: " + this.balance + "원");
    }

    // 4. 출금 메서드
    public void withdraw(double amount) throws InsufficientBalanceException {
        if (this.balance < amount) {
            throw new InsufficientBalanceException("잔액이 부족합니다. 현재 잔액: " + this.balance + "원");
        }
        this.balance -= amount;
        System.out.println(amount + "원이 출금되었습니다. 현재 잔액: " + this.balance + "원");
    }

    @Override
    public abstract String toString();
}