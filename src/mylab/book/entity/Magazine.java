package mylab.book.entity;

// 잡지 정보를 관리하는 클래스 (Publication 상속)
public class Magazine extends Publication {
    private String publishPeriod; // 발행주기 (예: 매월, 주간)

    public Magazine(String title, String publishDate, int page, int price, String publishPeriod) {
        super(title, publishDate, page, price);
        this.publishPeriod = publishPeriod;
    }

    public String getPublishPeriod() {
        return publishPeriod;
    }

    public void setPublishPeriod(String publishPeriod) {
        this.publishPeriod = publishPeriod;
    }

    @Override
    public String toString() {
        return super.toString() + " [잡지] 발행주기:" + publishPeriod + ", " + getPage() + "쪽, " + getPrice() + "원, 출판일:" + getPublishDate();
    }
}