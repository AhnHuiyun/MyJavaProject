package workshop.bank.control;

import workshop.bank.entity.*;

public class BankDemo {
	public static void main(String[] args) {
		Bank bank = new Bank();
		
		System.out.println("=== ���� ���� ===");
		System.out.print("Saving(����) ���°� �����Ǿ����ϴ�: ");
		bank.createSavingsAccount("ȫ�浿", 10000, 3);
		System.out.print("üŷ ���°� �����Ǿ����ϴ�: ");
        bank.createCheckingAccount("��ö��", 20000, 5000);
        System.out.print("���� ���°� �����Ǿ����ϴ�: ");
        bank.createSavingsAccount("�̿���", 30000, 2);
		
		bank.displayAllAccounts();
		
		System.out.println("\n=== �Ա�/��� �׽�Ʈ ===");
		try {
            bank.deposit("AC1000", 5000);
            bank.withdraw("AC1001", 3000);
            
        } catch (Exception e) {
            System.out.println("���� �߻�: " + e.getMessage());
        }
		
		System.out.println("\n=== ���� ���� �׽�Ʈ ===");
		try {
            Account account = bank.findAccount("AC1000");
            // �� �κ��� GPT ���
            if (account instanceof SavingsAccount) 
                ((SavingsAccount) account).applyInterest(); 
            
        } catch (Exception e) {
            System.out.println("���� �߻�: " + e.getMessage());
        }
		
		System.out.println("\n=== ������ü �׽�Ʈ ===");
		try {
            bank.transfer("AC1002", "AC1001", 5000);
            
        } catch (Exception e) {
            System.out.println("���� �߻�: " + e.getMessage());
        }
		
		bank.displayAllAccounts();
		
        try {
            bank.withdraw("AC1000", 16000);
            
        } catch (Exception e) {
            System.out.println("���� �߻�: " + e.getMessage());
        }

        try {
            bank.withdraw("AC1001", 6000);
            
        } catch (Exception e) {
            System.out.println("���� �߻�: " + e.getMessage());
        }

        try {
            bank.findAccount("AC9999");
            
        } catch (Exception e) {
            System.out.println("���� �߻�: " + e.getMessage());
        }
	}
}
