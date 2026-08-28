package mylab.book.entity;

// 참고서 정보를 관리하는 클래스 (Publication 상속)
public class ReferenceBook extends Publication {
    private String field; // 전문 분야

    public ReferenceBook(String title, String publishDate, int page, int price, String field) {
        super(title, publishDate, page, price);
        this.field = field;
    }

    public String getField() {
        return field;
    }

    public void setField(String field) {
        this.field = field;
    }

    @Override
    public String toString() {
        return super.toString() + " [참고서] 분야:" + field + ", " + getPage() + "쪽, " + getPrice() + "원, 출판일:" + getPublishDate();
    }
}