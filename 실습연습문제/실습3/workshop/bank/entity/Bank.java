package workshop.bank.entity;

import java.util.ArrayList;
import java.util.List;

import workshop.bank.exception.*;

public class Bank {
	private List<Account> accounts = new ArrayList<>();
	private int nextAccountNumber = 1000;
	
	public void createSavingsAccount(String ownerName, double balance, double interestRate) {
        String accountNumber = "AC" + nextAccountNumber++;
        SavingsAccount savingAccount = new SavingsAccount(accountNumber, ownerName, balance, interestRate);
        accounts.add(savingAccount);
        savingAccount.display();
    }

    public void createCheckingAccount(String ownerName, double balance, double withdrawalLimit) {
        String accountNumber = "AC" + nextAccountNumber++;
        CheckingAccount checkingaccount = new CheckingAccount(accountNumber, ownerName, balance, withdrawalLimit);
        accounts.add(checkingaccount);
        checkingaccount.display();
    }

    public Account findAccount(String accountNumber) throws AccountNotFoundException {
        for (Account account : accounts) {
            if (account.getAccountNumber().equals(accountNumber)) return account;          
        }
        throw new AccountNotFoundException("계좌번호 " + accountNumber + "에 해당하는 계좌를 찾을 수 없습니다.");
    }

    public void deposit(String accountNumber, double amount) throws AccountNotFoundException {
        findAccount(accountNumber).deposit(amount);
    }

    public void withdraw(String accountNumber, double amount) throws AccountNotFoundException, InsufficientBalanceException {
        findAccount(accountNumber).withdraw(amount);
    }

    public void transfer(String fromAccountNumber, String toAccountNumber, double amount) throws InsufficientBalanceException, AccountNotFoundException, WithdrawalLimitExceededException {
        findAccount(fromAccountNumber).withdraw(amount);
        findAccount(toAccountNumber).deposit(amount);
        System.out.println(amount + "원이 " + fromAccountNumber + "에서 " + toAccountNumber + "로 송금되었습니다.");
    }

    public void displayAllAccounts() {
        System.out.println("\n=== 모든 계좌 목록 ===");
        for (Account account : accounts) {
        	account.display();
        }
        System.out.println("===================");
    }
}
