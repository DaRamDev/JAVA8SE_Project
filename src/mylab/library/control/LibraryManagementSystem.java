package mylab.library.control;

import java.util.List;
import mylab.library.entity.Book;
import mylab.library.entity.Library;

public class LibraryManagementSystem {

    public static void main(String[] args) {
        // a. 도서관 객체 생성
        Library library = new Library("중앙도서관");

        // b. addSampleBooks()를 호출하여 샘플 도서 추가
        addSampleBooks(library);

        // c. 도서관 정보 출력
        System.out.println("=== " + library.getName() + " 현황 ===");
        System.out.println("전체 도서 수: " + library.getTotalBooks() + "권");
        System.out.println("대출 가능 도서 수: " + library.getAvailableBooksCount() + "권");
        System.out.println("대출 중인 도서 수: " + library.getBorrowedBooksCount() + "권");
        System.out.println();

        // d. 각 기능 테스트 메서드 호출
        testFindBook(library);
        testCheckOut(library);
        testReturn(library);

        // e. displayAvailableBooks()를 호출하여 대출 가능한 도서 목록 출력
        displayAvailableBooks(library);
    }

    // 샘플 도서 목록 추가
    private static void addSampleBooks(Library library) {
        library.addBook(new Book("자바 프로그래밍", "김자바", "978-89-01-12345-6", 2022));
        library.addBook(new Book("객체지향의 사실과 오해", "조영호", "978-89-01-67890-1", 2015));
        library.addBook(new Book("Clean Code", "Robert C. Martin", "978-0-13-235088-4", 2008));
        library.addBook(new Book("Effective Java", "Joshua Bloch", "978-0-13-468599-1", 2018));
        library.addBook(new Book("Head First Java", "Kathy Sierra", "978-0-596-00920-5", 2005));
        library.addBook(new Book("자바의 정석", "남궁성", "978-89-01-14077-4", 2019));
    }

    // 도서 검색 기능 테스트 (제목, 저자)
    public static void testFindBook(Library library) {
        System.out.println("=== 1. 도서 검색 테스트 ===");
        // 제목 검색
        Book bookByTitle = library.findBookByTitle("자바 프로그래밍");
        if (bookByTitle != null) {
            System.out.println("[제목 검색 성공] " + bookByTitle.getTitle() + " / " + bookByTitle.getAuthor());
        }

        // 저자 검색 (여러 권 목록)
        List<Book> booksByAuthor = library.findBooksByAuthor("김자바");
        System.out.println("[저자 검색 결과] 총 " + booksByAuthor.size() + "권");
        for (Book book : booksByAuthor) {
            System.out.println("- " + book.getTitle() + " (" + book.getPublishYear() + "년)");
        }
        System.out.println();
    }

    // 도서 대출 기능 테스트 (ISBN 기반)
    public static void testCheckOut(Library library) {
        System.out.println("=== 2. 도서 대출 테스트 ===");
        String isbn = "978-89-01-12345-6";
        boolean isSuccess = library.checkOutBook(isbn);
        
        if (isSuccess) {
            System.out.println("대출 성공 (ISBN: " + isbn + ")");
        } else {
            System.out.println("대출 실패: 이미 대출 중이거나 책이 없습니다.");
        }
        System.out.println();
    }

    // 도서 반납 기능 테스트 (ISBN 기반)
    public static void testReturn(Library library) {
        System.out.println("=== 3. 도서 반납 테스트 ===");
        String isbn = "978-89-01-12345-6";
        boolean isSuccess = library.returnBook(isbn);
        
        if (isSuccess) {
            System.out.println("반납 성공 (ISBN: " + isbn + ")");
        } else {
            System.out.println("반납 실패: 대출 중인 도서가 아닙니다.");
        }
        System.out.println();
    }

    // 대출 가능한 도서 목록만 출력
    public static void displayAvailableBooks(Library library) {
        System.out.println("=== 4. 대출 가능 도서 목록 ===");
        for (Book book : library.getAvailableBooks()) {
            System.out.println("- " + book.getTitle() + " (" + book.getAuthor() + ")");
        }
    }
}