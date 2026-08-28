package mylab.bank.entity;

import java.util.ArrayList;
import java.util.List;
import mylab.bank.exception.AccountNotFoundException;
import mylab.bank.exception.InsufficientBalanceException;

// 은행 시스템의 주요 관리 클래스
public class Bank {
    private List<Account> accounts; // 계좌 목록
    private int nextAccountNumber;  // 다음 계좌 생성 시 사용할 번호

    public Bank() {
        this.accounts = new ArrayList<>();
        this.nextAccountNumber = 1000;
    }

    // 저축 계좌 생성
    public String createSavingsAccount(String ownerName, double balance, double interestRate) {
        String accountNumber = "AC" + (nextAccountNumber++);
        SavingsAccount account = new SavingsAccount(accountNumber, ownerName, balance, interestRate);
        accounts.add(account);
        return accountNumber;
    }

    // 체킹 계좌 생성
    public String createCheckingAccount(String ownerName, double balance, double withdrawalLimit) {
        String accountNumber = "AC" + (nextAccountNumber++);
        CheckingAccount account = new CheckingAccount(accountNumber, ownerName, balance, withdrawalLimit);
        accounts.add(account);
        return accountNumber;
    }

    // 계좌 검색
    public Account findAccount(String accountNumber) throws AccountNotFoundException {
        for (Account account : accounts) {
            if (account.getAccountNumber().equals(accountNumber)) {
                return account;
            }
        }
        throw new AccountNotFoundException("계좌번호 " + accountNumber + "에 해당하는 계좌를 찾을 수 없습니다.");
    }

    // 입금 기능
    public void deposit(String accountNumber, double amount) throws AccountNotFoundException {
        Account account = findAccount(accountNumber);
        account.deposit(amount);
    }

    // 출금 기능
    public void withdraw(String accountNumber, double amount) throws AccountNotFoundException, InsufficientBalanceException {
        Account account = findAccount(accountNumber);
        account.withdraw(amount);
    }

    // 계좌 간 송금 기능
    public void transfer(String fromAccountNumber, String toAccountNumber, double amount)
            throws AccountNotFoundException, InsufficientBalanceException {
        Account fromAccount = findAccount(fromAccountNumber);
        Account toAccount = findAccount(toAccountNumber);

        fromAccount.withdraw(amount);
        toAccount.deposit(amount);
        System.out.println(amount + "원이 " + fromAccountNumber + "에서 " + toAccountNumber + "로 송금되었습니다.");
    }

    // 모든 계좌 정보 출력
    public void printAllAccounts() {
        for (Account account : accounts) {
            System.out.println(account);
        }
    }
}