package mylab.bank.control;

import mylab.bank.entity.Account;
import mylab.bank.entity.Bank;
import mylab.bank.entity.SavingsAccount;

public class BankDemo {
    public static void main(String[] args) {
        Bank bank = new Bank();

        // 1. 계좌 생성 테스트
        System.out.println("=== 계좌 생성 ===");
        String acc1 = bank.createSavingsAccount("홍길동", 10000.0, 3.0);
        try {
            System.out.println("Saving(저축) 계좌가 생성되었습니다: " + bank.findAccount(acc1));
        } catch (Exception e) {}

        String acc2 = bank.createCheckingAccount("김철수", 20000.0, 5000.0);
        try {
            System.out.println("체킹 계좌가 생성되었습니다: " + bank.findAccount(acc2));
        } catch (Exception e) {}

        String acc3 = bank.createSavingsAccount("이영희", 30000.0, 2.0);
        try {
            System.out.println("저축 계좌가 생성되었습니다: " + bank.findAccount(acc3));
        } catch (Exception e) {}

        // 2. 모든 계좌 목록 출력
        System.out.println("\n=== 모든 계좌 목록 ===");
        bank.printAllAccounts();
        System.out.println("===================");

        // 3. 입금/출금 테스트
        System.out.println("\n=== 입금/출금 테스트 ===");
        try {
            bank.deposit(acc1, 5000.0);
            bank.withdraw(acc2, 3000.0);
        } catch (Exception e) {
            System.out.println("예외 발생: " + e.getMessage());
        }

        // 4. 이자 적용 테스트
        System.out.println("\n=== 이자 적용 테스트 ===");
        try {
            Account account = bank.findAccount(acc1);
            if (account instanceof SavingsAccount) {
                ((SavingsAccount) account).applyInterest();
            }
        } catch (Exception e) {
            System.out.println("예외 발생: " + e.getMessage());
        }

        // 5. 계좌 이체 테스트
        System.out.println("\n=== 계좌 이체 테스트 ===");
        try {
            bank.transfer(acc3, acc2, 5000.0);
        } catch (Exception e) {
            System.out.println("예외 발생: " + e.getMessage());
        }

        // 6. 변경 후 모든 계좌 목록 출력
        System.out.println("\n=== 모든 계좌 목록 ===");
        bank.printAllAccounts();
        System.out.println("===================");

        // 7. 예외 처리 테스트
        // 테스트 1: CheckingAccount 출금 한도 초과
        try {
            bank.withdraw(acc2, 6000.0);
        } catch (Exception e) {
            System.out.println("예외 발생: " + e.getMessage());
        }

        // 테스트 2: CheckingAccount 이체 시 출금 한도 초과
        try {
            bank.transfer(acc2, acc1, 6000.0);
        } catch (Exception e) {
            System.out.println("예외 발생: " + e.getMessage());
        }

        // 테스트 3: 존재하지 않는 계좌 검색
        try {
            bank.findAccount("AC9999");
        } catch (Exception e) {
            System.out.println("예외 발생: " + e.getMessage());
        }
    }
}