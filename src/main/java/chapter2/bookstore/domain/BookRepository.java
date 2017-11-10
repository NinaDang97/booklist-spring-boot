package chapter2.bookstore.domain;

import java.util.List;
import org.springframework.data.repository.CrudRepository;

import chapter2.bookstore.domain.Book;

public interface BookRepository extends CrudRepository<Book, Long>{
	 List<Book> findByIsbn(int isbn);
}
