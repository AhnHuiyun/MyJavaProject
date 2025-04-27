package workshop.bank.entity;

import workshop.bank.exception.*;

public class CheckingAccount extends Account {
	 private double withdrawalLimit; 

	    public CheckingAccount(String accountNumber, String ownerName, double balance, double withdrawalLimit) {
	        super(accountNumber, ownerName, balance);
	        this.withdrawalLimit = withdrawalLimit;
	    }	    	    

	    public double getWithdrawalLimit() {
			return withdrawalLimit;
		}

		public void setWithdrawalLimit(double withdrawalLimit) {
			this.withdrawalLimit = withdrawalLimit;
		}

		@Override
	    public void withdraw(double amount) throws InsufficientBalanceException {
	        if (amount > withdrawalLimit) {
	            throw new WithdrawalLimitExceededException("출금 한도를 초과했습니다. 한도: " + withdrawalLimit + "원");
	        }
	        super.withdraw(amount);
	    }

	    @Override
	    public void display() {
	        System.out.println("계좌번호: " + accountNumber + ", 소유자: " + ownerName + ", 잔액: " + balance + "원, 출금 한도: " + withdrawalLimit + "원");
	    }
}
