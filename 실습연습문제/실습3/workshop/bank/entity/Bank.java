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
        throw new AccountNotFoundException("���¹�ȣ " + accountNumber + "�� �ش��ϴ� ���¸� ã�� �� �����ϴ�.");
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
        System.out.println(amount + "���� " + fromAccountNumber + "���� " + toAccountNumber + "�� �۱ݵǾ����ϴ�.");
    }

    public void displayAllAccounts() {
        System.out.println("\n=== ��� ���� ��� ===");
        for (Account account : accounts) {
        	account.display();
        }
        System.out.println("===================");
    }
}
