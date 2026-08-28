package mylab.bank.entity;

// 저축 계좌 클래스 (Account 상속)
public class SavingsAccount extends Account {
    private double interestRate; // 이자율 (예: 3.0%)

    public SavingsAccount(String accountNumber, String ownerName, double balance, double interestRate) {
        super(accountNumber, ownerName, balance);
        this.interestRate = interestRate;
    }

    public double getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(double interestRate) {
        this.interestRate = interestRate;
    }

    // 이자 적용 메서드
    public void applyInterest() {
        double interest = getBalance() * (interestRate / 100.0);
        deposit(interest);
        System.out.println("이자 " + interest + "원이 적용되었습니다. 현재 잔액: " + getBalance() + "원");
    }

    @Override
    public String toString() {
        return "계좌번호: " + getAccountNumber() + ", 소유자: " + getOwnerName() + ", 잔액: " + getBalance() + "원, 이자율: " + interestRate + "%";
    }
}