package workshop.book.control;

import workshop.book.entity.*;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {
	private List<Publication> items;
	
	public ShoppingCart() {
		items = new ArrayList<>();
	}

	public void addItem(Publication item) {
		int index = items.size() + 1;
		items.add(item);
		System.out.println(index + ". " + item.getTitle() + "��(��) ��ٱ��Ͽ� �߰��Ǿ����ϴ�.");
	}
	
	public boolean removeItem(String title) {
		for (Publication p : items) {
			if (p.getTitle().equals(title)) {
				items.remove(p);
				System.out.println(title + "��(��) ��ٱ��Ͽ��� ���ŵǾ����ϴ�.");
				return true;
			}
		}
		
		return false;
	}
	
	public void displayCart() {
	    int index = 1;
	    
	    for (Publication p : items) {
	    	System.out.println(index++  + ". " + p.toString() + ", " + p.getPage() + "��" + ", " + p.getPrice() + "��" + ", ������:" + p.getPublishDate());
	    }
	    
	    System.out.println("------------------------");
	    System.out.println("�� ����: " + String.format("%,d", calculateTotalPrice()) + "��");
	    System.out.println("���� ���� ����: " + String.format("%,d", calculateDiscountedPrice()) + "��");
	}
	
	public int calculateTotalPrice() {
		int total=0;
		
		for (Publication p : items) {
			total += p.getPrice();
		}
		
		return total;
	}
	
	public int calculateDiscountedPrice() {
		int discountedTotal = 0;
		// �� �κ��� GPT ���
        for (Publication p : items) {
            if (p instanceof Magazine) {
                discountedTotal += p.getPrice() * 0.9;
            } else if (p instanceof Novel) {
                discountedTotal += p.getPrice() * 0.85;
            } else if (p instanceof ReferenceBook) {
                discountedTotal += p.getPrice() * 0.8;
            } else {
                discountedTotal += p.getPrice();
            }
        }
        
        return discountedTotal;
	}
	
	public void printStatistics() {
        int novelCount = 0, magazineCount = 0, refBookCount = 0;
        // �� �κ��� GPT ���
        for (Publication p : items) {
            if (p instanceof Novel) novelCount++;
            else if (p instanceof Magazine) magazineCount++;
            else if (p instanceof ReferenceBook) refBookCount++;
        }
        
        System.out.println("�Ҽ�: " + novelCount + "��");
        System.out.println("����: " + magazineCount + "��");
        System.out.println("����: " + refBookCount + "��");
    }
	
	public static void main(String[] args) {
        ShoppingCart shoppingCart = new ShoppingCart();
        	
        System.out.println("\n==== ���ǹ� ��ٱ��Ͽ� �߰� ====");
        shoppingCart.addItem(new Magazine("����ũ�μ���Ʈ", "2007-10-01", 328, 9900, "�ſ�"));
        shoppingCart.addItem(new Magazine("�濵����ǻ��", "2007-10-03", 316, 9000, "�ſ�"));
        shoppingCart.addItem(new Novel("���߿�", "2007-07-01", 396, 9800, "����������������", "����Ҽ�"));
        shoppingCart.addItem(new Novel("���ѻ꼺", "2007-04-14", 383, 11000, "����", "���ϼҼ�"));
        shoppingCart.addItem(new ReferenceBook("�ǿ��������α׷���", "2007-01-14", 496, 25000, "����Ʈ�������"));
        shoppingCart.addItem(new Novel("�ҳ��̿´�", "2014-05-01", 216, 15000, "�Ѱ�", "����Ҽ�"));
        shoppingCart.addItem(new Novel("�ۺ������ʴ´�", "2021-09-09", 332, 15120, "�Ѱ�", "����Ҽ�"));
        
        System.out.println("\n==== ��ٱ��� ���� ��� ====");
        shoppingCart.displayCart();
        
        System.out.println("\n===== ��ٱ��Ͽ� ��� ���ǹ� ��� =====");
        shoppingCart.printStatistics();
        
        System.out.println("\n===== '���߿�' �׸� ���� =====");
        shoppingCart.removeItem("���߿�");
        	
        System.out.println("\n===== '���߿�' �׸� ���� �� ��ٱ��� ���� ��� =====");
        shoppingCart.displayCart();
    }
}
