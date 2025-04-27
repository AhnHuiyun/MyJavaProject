package workshop.bank.control;

import workshop.bank.entity.*;

public class BankDemo {
	public static void main(String[] args) {
		Bank bank = new Bank();
		
		System.out.println("=== 계좌 생성 ===");
		System.out.print("Saving(저축) 계좌가 생성되었습니다: ");
		bank.createSavingsAccount("홍길동", 10000, 3);
		System.out.print("체킹 계좌가 생성되었습니다: ");
        bank.createCheckingAccount("김철수", 20000, 5000);
        System.out.print("저축 계좌가 생성되었습니다: ");
        bank.createSavingsAccount("이영희", 30000, 2);
		
		bank.displayAllAccounts();
		
		System.out.println("\n=== 입금/출금 테스트 ===");
		try {
            bank.deposit("AC1000", 5000);
            bank.withdraw("AC1001", 3000);
            
        } catch (Exception e) {
            System.out.println("예외 발생: " + e.getMessage());
        }
		
		System.out.println("\n=== 이자 적용 테스트 ===");
		try {
            Account account = bank.findAccount("AC1000");
            // 이 부분은 GPT 사용
            if (account instanceof SavingsAccount) 
                ((SavingsAccount) account).applyInterest(); 
            
        } catch (Exception e) {
            System.out.println("예외 발생: " + e.getMessage());
        }
		
		System.out.println("\n=== 계좌이체 테스트 ===");
		try {
            bank.transfer("AC1002", "AC1001", 5000);
            
        } catch (Exception e) {
            System.out.println("예외 발생: " + e.getMessage());
        }
		
		bank.displayAllAccounts();
		
        try {
            bank.withdraw("AC1000", 16000);
            
        } catch (Exception e) {
            System.out.println("예외 발생: " + e.getMessage());
        }

        try {
            bank.withdraw("AC1001", 6000);
            
        } catch (Exception e) {
            System.out.println("예외 발생: " + e.getMessage());
        }

        try {
            bank.findAccount("AC9999");
            
        } catch (Exception e) {
            System.out.println("예외 발생: " + e.getMessage());
        }
	}
}
