package services;

import entity.Book;
import entity.Member;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

public class QueriesService {
    private final PersistenceService ps;

    public QueriesService(PersistenceService ps) {
        this.ps = ps;
    }

    public void run() {
//        task1();
//        task2();
    }

//    private void task1() {
//        String queryString = "SELECT b.* FROM BOOK b JOIN AUTHOR a ON b.AUTHOR_ID = a.ID WHERE a.NAME LIKE ?";
//        Query query = ps.getEntityManager().createNativeQuery(queryString, Book.class);
//        query.setParameter(1, "%George Orwell%");
//        List<Book> books = (List<Book>) query.getResultList();
//        books.forEach(System.out::println);
//    }
//
//    private void task2()    {
//        String queryString = "SELECT m.* from MEMBER as m where m.MEMBERSHIPDATE >= ? AND m.MEMBERSHIPDATE <= ?";
//        Query query = ps.getEntityManager().createNativeQuery(queryString, Member.class);
//        query.setParameter(1, LocalDate.of(2023, 4, 15));
//        query.setParameter(2, LocalDate.of(2023, 6, 15));
//        List<Member> members = (List<Member>) query.getResultList();
//        members.forEach(System.out::println);
//
//        TypedQuery<Member> q = ps.getEntityManager().createNativeQuery(queryString);
//    }

}
