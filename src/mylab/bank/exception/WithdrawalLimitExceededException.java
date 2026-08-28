package mylab.bank.exception;

// 출금 한도를 초과할 때 발생하는 예외 클래스 (InsufficientBalanceException 상속)
public class WithdrawalLimitExceededException extends InsufficientBalanceException {
    public WithdrawalLimitExceededException(String message) {
        super(message);
    }
}