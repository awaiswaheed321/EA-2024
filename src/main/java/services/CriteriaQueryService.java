package services;

import entity.Author;
import entity.Book;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;

import java.util.List;

public class CriteriaQueryService {
    private final PersistenceService ps;

    public CriteriaQueryService(PersistenceService ps) {
        this.ps = ps;
    }

    public void run() {
//        task1();
        task2();
    }

    public void task2() {
        CriteriaBuilder cb = ps.getEntityManager().getCriteriaBuilder();
        CriteriaQuery<Book> cq = cb.createQuery(Book.class);
        Root<Author> root = cq.from(Author.class);
        cq.select(root.get("books"));

        Predicate p = cb.like(root.get("name"), "G%");

        cq.where(p);

        TypedQuery<Book> query = ps.getEntityManager().createQuery(cq);
        List<Book> books = query.getResultList();
        System.out.println(books);
    }

    private void task1() {
        CriteriaBuilder cb = ps.getEntityManager().getCriteriaBuilder();
        CriteriaQuery<Book> cq = cb.createQuery(Book.class);
        Root<Book> root = cq.from(Book.class);
        cq.select(root);

        Predicate p = cb.greaterThanOrEqualTo(root.get("availableCopies"), 5);
        Predicate p1 = cb.like(root.get("title"), "%5%");
        cq.where(cb.and(p, p1));

        TypedQuery<Book> query = ps.getEntityManager().createQuery(cq);
        List<Book> res = query.getResultList();
        System.out.println(res);
    }
}
