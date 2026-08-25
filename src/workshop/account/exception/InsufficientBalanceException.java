package workshop.account.exception;

//잔액이 부족할 때 예외처리

public class InsufficientBalanceException extends Exception{
	
	private int currentBalance;
	
	public InsufficientBalanceException(String errorMessage) {
		super(errorMessage);
	}
}
