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
	
	// ������ �߰��ϴ� �޼���
	public void addBook(Book book) {
		books.add(book);
		System.out.println("������ �߰��Ǿ����ϴ�: " + book.getTitle());
	}
	
	// ����, ����, ISBN���� ������ �˻��ϴ� �޼���
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
	
    // ISBN���� ������ �����ϰų� �ݳ��ϴ� �޼���
	public boolean checkOutBook(String isbn) {
		Book book = findBookByISBN(isbn);
		
        if (book.checkOut()) return true;       
        
		return false;
	}
	
	public boolean returnBook(String isbn) {
		findBookByISBN(isbn).returnBook();
		
		return true;
	}
	
	// ���� ������ ���� ����̳� ��ü ���� ����� ��ȯ�ϴ� �޼���
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
	
	// ���� ���� ���� ������ ��ȯ�ϴ� �޼���
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
