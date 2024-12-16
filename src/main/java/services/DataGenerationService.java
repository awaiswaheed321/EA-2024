package services;

import entity.*;
import enums.Genre;
import jakarta.persistence.EntityManager;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class DataGenerationService {
    private final PersistenceService ps;

    public DataGenerationService(PersistenceService ps) {
        this.ps = ps;
    }

    public void generateData() {
        ps.startTransaction();

        EntityManager em = ps.getEntityManager();

        // Create Authors
        Author author1 = new Author();
        author1.setName("J.K. Rowling");
        em.persist(author1);

        Author author2 = new Author();
        author2.setName("George Orwell");
        em.persist(author2);

        // Create Books
        Book book1 = new Book();
        book1.setTitle("Harry Potter and the Sorcerer's Stone");
        book1.setGenre(Genre.FANTASY);
        book1.setAvailableCopies(5);
        book1.setAuthor(author1);
        em.persist(book1);

        Book book2 = new Book();
        book2.setTitle("1984");
        book2.setGenre(Genre.SCIENCE_FICTION);
        book2.setAvailableCopies(2);
        book2.setAuthor(author2);
        em.persist(book2);

        Book book3 = new Book();
        book3.setTitle("Animal Farm");
        book3.setGenre(Genre.FICTION);
        book3.setAvailableCopies(3);
        book3.setAuthor(author2);
        em.persist(book3);

        // Create Members
        Member member1 = new Member();
        member1.setName("Alice");
        member1.setMembershipDate(LocalDate.of(2022, 1, 10));
        em.persist(member1);

        Member member2 = new Member();
        member2.setName("Bob");
        member2.setMembershipDate(LocalDate.of(2023, 5, 15));
        em.persist(member2);

        // Create Borrow Records
        BorrowRecord record1 = new BorrowRecord();
        record1.setMember(member1);
        record1.setBook(book1);
        record1.setBorrowDate(LocalDate.now().minusDays(10));
        record1.setReturnDate(LocalDate.now());
        em.persist(record1);

        BorrowRecord record2 = new BorrowRecord();
        record2.setMember(member1);
        record2.setBook(book2);
        record2.setBorrowDate(LocalDate.now().minusDays(15));
        record2.setReturnDate(null); // Not yet returned
        em.persist(record2);

        BorrowRecord record3 = new BorrowRecord();
        record3.setMember(member2);
        record3.setBook(book3);
        record3.setBorrowDate(LocalDate.now().minusDays(5));
        record3.setReturnDate(null); // Not yet returned
        em.persist(record3);

        // Create Libraries
        Library library1 = new Library();
        library1.setName("Central Library");
        library1.setLocation("Downtown");
        List<Book> library1Books = new ArrayList<>();
        library1Books.add(book1);
        library1Books.add(book2);
        library1.setBooks(library1Books);
        em.persist(library1);

        Library library2 = new Library();
        library2.setName("Community Library");
        library2.setLocation("Uptown");
        List<Book> library2Books = new ArrayList<>();
        library2Books.add(book3);
        library2.setBooks(library2Books);
        em.persist(library2);

        ps.endTransaction();
        System.out.println("Database populated successfully!");
    }
}
