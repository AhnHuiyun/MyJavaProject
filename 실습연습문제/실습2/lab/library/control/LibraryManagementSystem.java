package lab.library.control;

import lab.library.entity.Book;
import lab.library.entity.Library;

public class LibraryManagementSystem {
	
	private static String JavaIsbn = "978-89-01-14077-4";
	
	public static void main(String[] args) {
		Library library = new Library("�߾� ������");

        addSampleBooks(library);
        
        System.out.println("===== " + library.getName() + " =====");
        displayLibraryInfo(library);

        System.out.println("\n===== ���� �˻� �׽�Ʈ =====");
        testFindBook(library);

        System.out.println("\n===== ���� ���� �׽�Ʈ =====");
        testCheckOut(library);

        System.out.println("\n===== ���� �ݳ� �׽�Ʈ =====");
        testReturn(library);

        System.out.println("\n===== ���� ������ ���� ��� =====");
        displayAvailableBooks(library);
	}
	
	// ���� ���� ����� �������� �߰��ϴ� �޼���
	private static void addSampleBooks(Library library) {
        library.addBook(new Book("�ڹ� ���α׷���", "���ڹ�", "978-89-01-12345-6", 2022));
        library.addBook(new Book("��ü������ ��ǰ� ����", "����ȣ", "978-89-01-67890-1", 2015));
        library.addBook(new Book("Clean Code", "Robert C. Martin", "978-0-13-235088-4", 2008));
        library.addBook(new Book("Effective Java", "Joshua Bloch", "978-0-13-468599-1", 2018));
        library.addBook(new Book("Head First Java", "Kathy Sierra", "978-0-596-00920-5", 2005));
        library.addBook(new Book("�ڹ��� ����", "���ü�", "978-89-01-14077-4", 2019));
	}

	// ����� ���ڷ� ������ �˻��ϴ� ����� �׽�Ʈ�ϴ� �޼���
	private static void displayLibraryInfo(Library library) {
        System.out.println("��ü ���� ��: " + library.getTotalBooks());
        System.out.println("���� ���� ���� ��: " + library.getAvailableBooksCount());
        System.out.println("���� ���� ���� ��: " + library.getBorrowedBooksCount());
    }
	
	// ���� ���� ����� �׽�Ʈ�ϴ� �޼���
	private static void testFindBook(Library library) {
        Book book = library.findBookByTitle("�ڹ��� ����");
		System.out.println("�������� �˻� ���:");
		System.out.println(book);

        Book booksByAuthor = library.findBooksByAuthor("Robert C. Martin");
		System.out.println("\n���ڷ� �˻� ���:");
		System.out.println(booksByAuthor);
		
    }
	
	// ���� �ݳ� ����� �׽�Ʈ�ϴ� �޼���
    private static void testCheckOut(Library library) {
        if (library.checkOutBook(JavaIsbn)) {
            System.out.println("���� ���� ����!");
            System.out.println("����� ���� ����:");
            System.out.println(library.findBookByISBN(JavaIsbn));
        } else {
            System.out.println("���� ���� ����!");
        }
        
        System.out.println("\n������ ���� ����:");
        displayLibraryInfo(library);
    }
    
    // ���� ������ ���� ����� ����ϴ� �޼���
    private static void testReturn(Library library) {
        if (library.returnBook(JavaIsbn)) {
            System.out.println("���� �ݳ� ����!");
            System.out.println("�ݳ��� ���� ����:");
            System.out.println(library.findBookByISBN(JavaIsbn));
        } else {
            System.out.println("���� �ݳ� ����!");
        }
        
        System.out.println("\n������ ���� ����:");
        displayLibraryInfo(library);
    }

    private static void displayAvailableBooks(Library library) {
        for (Book book : library.getAvailableBooks()) {
            System.out.println(book);
            System.out.println("------------------------");
        }
    }
}
