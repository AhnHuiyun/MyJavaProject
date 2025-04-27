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
	            throw new WithdrawalLimitExceededException("��� �ѵ��� �ʰ��߽��ϴ�. �ѵ�: " + withdrawalLimit + "��");
	        }
	        super.withdraw(amount);
	    }

	    @Override
	    public void display() {
	        System.out.println("���¹�ȣ: " + accountNumber + ", ������: " + ownerName + ", �ܾ�: " + balance + "��, ��� �ѵ�: " + withdrawalLimit + "��");
	    }
}
