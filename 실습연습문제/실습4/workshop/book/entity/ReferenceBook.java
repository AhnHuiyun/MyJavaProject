package workshop.book.entity;

public class ReferenceBook extends Publication {
	private String field;

    public ReferenceBook() {}

    public ReferenceBook(String title, String publishDate, int page, int price, String field) {
        super(title, publishDate, page, price);
        this.field = field;
    }

    public String getField() {
        return field;
    }

    @Override
    public String toString() {
        return getTitle() + " [참고서] 분야:" + field;
    }
}
