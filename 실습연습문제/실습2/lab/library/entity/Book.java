package lab.library.entity;

public class Book {
	private String title;
    private String author;
    private String isbn;
    private int publishYear;
    private boolean isAvailable;
    
    public Book() {
    	isAvailable = true;
    }

	public Book(String title, String author, String isbn, int publishYear) {
		super();
		this.title = title;
		this.author = author;
		this.isbn = isbn;
		this.publishYear = publishYear;
		isAvailable = true;
	}
	
	public String getTitle() {
		return title;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public int getPublishYear() {
		return publishYear;
	}

	public void setPublishYear(int publishYear) {
		this.publishYear = publishYear;
	}

	public boolean isAvailable() {
		return isAvailable;
	}

	public void setAvailable(boolean isAvailable) {
		this.isAvailable = isAvailable;
	}
    
	// 도서 대출을 처리하는 메서드로, 대출 가능한 경우 isAvailable을 false로 변경하고 true를 반환
    public boolean checkOut() {
    	if (isAvailable == true) {
    		isAvailable = false;
    		return true;
    	}
    	
    	return false;
    }
    
    // 도서 반납을 처리하는 메서드로, isAvailable을 true로 변경
    public void returnBook() {
    	isAvailable = true;
    }
    
    // 도서 정보의 문자열 표현을 반환하는 메서드
    @Override
    public String toString() {
    	return String.format(
            "책 제목: %s\t저자: %s\tISBN: %s\t출판년도: %d\t대출 가능 여부: %s",
            title, author, isbn, publishYear, (isAvailable ? "가능" : "대출 중")
        );
    }
}
