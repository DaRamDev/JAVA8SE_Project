package mylab.library.entity;

import java.util.ArrayList;
import java.util.List;

public class Library {
    
    private String name; 
    private List<Book> books;

    public Library(String name) {
        this.name = name;
        this.books = new ArrayList<Book>();
    }

    // 도서관 이름 조회
    public String getName() {
        return this.name;
    }

    // 도서 추가
    public void addBook(Book book) {
        this.books.add(book);
    }
    
    // 제목으로 도서 검색
    public Book findBookByTitle(String title) {
        for (Book book : this.books) {
            if (book.getTitle().equals(title)) {
                return book;
            }
        }
        return null;
    }
    
    // 저자로 도서 검색
    public List<Book> findBooksByAuthor(String author) {
        List<Book> result = new ArrayList<Book>();
        for (Book book : this.books) {            
            if (book.getAuthor().equals(author)) {
                result.add(book);
            }
        }
        return result;
    }
    
    // ISBN으로 도서 검색
    public Book findBookByISBN(String isbn) {
        for (Book book : this.books) {            
            if (book.getIsbn().equals(isbn)) {
                return book;
            }
        }
        return null;
    }

    // ISBN으로 도서 대출
    public boolean checkOutBook(String isbn) {
        Book book = findBookByISBN(isbn);
        if (book != null && book.isAvailable()) {
            return book.checkOut();
        }
        return false;
    }

    // ISBN으로 도서 반납
    public boolean returnBook(String isbn) {
        Book book = findBookByISBN(isbn);
        if (book != null && !book.isAvailable()) {
            book.returnBook();
            return true;
        }
        return false;
    }

    // 대출 가능한 도서 목록 반환
    public List<Book> getAvailableBooks() {
        List<Book> availableList = new ArrayList<Book>();
        for (Book book : this.books) {
            if (book.isAvailable()) {
                availableList.add(book);
            }
        }
        return availableList;
    }

    // 전체 도서 목록 반환
    public List<Book> getAllBooks() {
        return this.books;
    }

    // 전체 도서 수 반환
    public int getTotalBooks() {
        return this.books.size();
    }
    
    // 대출 가능한 도서 수 반환
    public int getAvailableBooksCount() {
        int count = 0;
        for (Book book : this.books) {
            if (book.isAvailable()) {
                count++;
            }
        }
        return count;
    }

    // 대출 중인 도서 수 반환
    public int getBorrowedBooksCount() {
        return getTotalBooks() - getAvailableBooksCount();
    }
}