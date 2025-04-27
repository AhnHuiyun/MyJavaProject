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
		System.out.println(index + ". " + item.getTitle() + "이(가) 장바구니에 추가되었습니다.");
	}
	
	public boolean removeItem(String title) {
		for (Publication p : items) {
			if (p.getTitle().equals(title)) {
				items.remove(p);
				System.out.println(title + "이(가) 장바구니에서 제거되었습니다.");
				return true;
			}
		}
		
		return false;
	}
	
	public void displayCart() {
	    int index = 1;
	    
	    for (Publication p : items) {
	    	System.out.println(index++  + ". " + p.toString() + ", " + p.getPage() + "쪽" + ", " + p.getPrice() + "원" + ", 출판일:" + p.getPublishDate());
	    }
	    
	    System.out.println("------------------------");
	    System.out.println("총 가격: " + String.format("%,d", calculateTotalPrice()) + "원");
	    System.out.println("할인 적용 가격: " + String.format("%,d", calculateDiscountedPrice()) + "원");
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
		// 이 부분은 GPT 사용
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
        // 이 부분은 GPT 사용
        for (Publication p : items) {
            if (p instanceof Novel) novelCount++;
            else if (p instanceof Magazine) magazineCount++;
            else if (p instanceof ReferenceBook) refBookCount++;
        }
        
        System.out.println("소설: " + novelCount + "권");
        System.out.println("잡지: " + magazineCount + "권");
        System.out.println("참고서: " + refBookCount + "권");
    }
	
	public static void main(String[] args) {
        ShoppingCart shoppingCart = new ShoppingCart();
        	
        System.out.println("\n==== 출판물 장바구니에 추가 ====");
        shoppingCart.addItem(new Magazine("마이크로소프트", "2007-10-01", 328, 9900, "매월"));
        shoppingCart.addItem(new Magazine("경영과컴퓨터", "2007-10-03", 316, 9000, "매월"));
        shoppingCart.addItem(new Novel("빠삐용", "2007-07-01", 396, 9800, "베르나르베르베르", "현대소설"));
        shoppingCart.addItem(new Novel("남한산성", "2007-04-14", 383, 11000, "김훈", "대하소설"));
        shoppingCart.addItem(new ReferenceBook("실용주의프로그래머", "2007-01-14", 496, 25000, "소프트웨어공학"));
        shoppingCart.addItem(new Novel("소년이온다", "2014-05-01", 216, 15000, "한강", "장편소설"));
        shoppingCart.addItem(new Novel("작별하지않는다", "2021-09-09", 332, 15120, "한강", "장편소설"));
        
        System.out.println("\n==== 장바구니 내용 출력 ====");
        shoppingCart.displayCart();
        
        System.out.println("\n===== 장바구니에 담긴 출판물 통계 =====");
        shoppingCart.printStatistics();
        
        System.out.println("\n===== '빠삐용' 항목 제거 =====");
        shoppingCart.removeItem("빠삐용");
        	
        System.out.println("\n===== '빠삐용' 항목 제거 후 장바구니 내용 출력 =====");
        shoppingCart.displayCart();
    }
}
