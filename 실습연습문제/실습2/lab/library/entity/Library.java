package lab.library.entity;

import java.util.ArrayList;
import java.util.List;

public class Library {
	private List<Book> books;
	private String name;
	
	public Library(String name) {
		this.name = name;
        this.books = new ArrayList<>();
	}
	
    public String getName() {
        return name;
    }
	
	// 도서를 추가하는 메서드
	public void addBook(Book book) {
		books.add(book);
		System.out.println("도서가 추가되었습니다: " + book.getTitle());
	}
	
	// 제목, 저자, ISBN으로 도서를 검색하는 메서드
	public Book findBookByTitle(String title) {
		for (Book book : books) {
            if (book.getTitle() == title) return book;           
        }
		
        return null;
	}
	
	public Book findBooksByAuthor(String author) {
        for (Book book : books) {
            if (book.getAuthor() == author) return book;         
        }
        
        return null;
    }

    public Book findBookByISBN(String isbn) {
        for (Book book : books) {
            if (book.getIsbn() == isbn) return book;          
        }
        
        return null;
    }
	
    // ISBN으로 도서를 대출하거나 반납하는 메서드
	public boolean checkOutBook(String isbn) {
		Book book = findBookByISBN(isbn);
		
        if (book.checkOut()) return true;       
        
		return false;
	}
	
	public boolean returnBook(String isbn) {
		findBookByISBN(isbn).returnBook();
		
		return true;
	}
	
	// 대출 가능한 도서 목록이나 전체 도서 목록을 반환하는 메서드
	public List<Book> getAvailableBooks() {
		List<Book> availableBook = new ArrayList<>();
        for (Book book : books) {
            if (book.isAvailable()) availableBook.add(book);            
        }
        
        return availableBook;
	}
	
	public List<Book> getAllBooks() {
        return books;
    }
	
	// 도서 수량 관련 정보를 반환하는 메서드
	public int getTotalBooks() {
        return books.size();
    }

    public int getAvailableBooksCount() {
        return getAvailableBooks().size();
    }

    public int getBorrowedBooksCount() {
        return getTotalBooks() - getAvailableBooksCount();
    }
}
