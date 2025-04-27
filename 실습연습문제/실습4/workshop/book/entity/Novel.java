package workshop.book.entity;

public class Novel extends Publication {
	private String author;
    private String genre;

    public Novel() {}

    public Novel(String title, String publishDate, int page, int price, String author, String genre) {
        super(title, publishDate, page, price);
        this.author = author;
        this.genre = genre;
    }

    public String getAuthor() {
        return author;
    }

    public String getGenre() {
        return genre;
    }

    @Override
    public String toString() {
        return getTitle() + " [소설] 저자:" + author + ", 장르:" + genre;
    }
}
