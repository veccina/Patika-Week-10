import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

import java.time.LocalDate;
import java.util.List;

public class App {
    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("library");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();

        transaction.begin();
        //Author ekleme
        Author author = new Author();
        author.setName ("Stephen King");
        author.setBirthdate(LocalDate.of(1947, 9, 21));
        author.setCountry("USA");
        entityManager.persist(author);

        //Category ekleme
        Category category = new Category();
        category.setName("Korku");
        category.setDescription("Korku ve gerilim türündeki kitaplar");
        entityManager.persist(category);

        //Publisher ekleme
        Publisher publisher = new Publisher();
        publisher.setName("Viking Press");
        publisher.setEstablishmentYear(1925);
        publisher.setAddress("New York, USA");
        entityManager.persist(publisher);

        //Book ekleme
        Book book = new Book();
        book.setName("The Shining");
        book.setPublicationYear(1977);
        book.setStock(100);
        book.setAuthor(author);
        book.setPublisher(publisher);
        book.setCategories(List.of(category));
        entityManager.persist(book);

        //BookBorrowing Ekleme
        BookBorrowing bookBorrowing = new BookBorrowing();
        bookBorrowing.setBorrowerName("John Doe");
        bookBorrowing.setBorrowingDate(LocalDate.now());
        bookBorrowing.setBook(book);
        entityManager.persist(bookBorrowing);

        transaction.commit();

    }
}
