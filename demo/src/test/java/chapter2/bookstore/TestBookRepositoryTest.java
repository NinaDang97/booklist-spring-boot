package chapter2.bookstore;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;
import static org.assertj.core.api.Assertions.assertThat;

import chapter2.bookstore.domain.Book;
import chapter2.bookstore.domain.BookRepository;
import chapter2.bookstore.domain.Category;

@RunWith(SpringRunner.class)
@DataJpaTest
public class TestBookRepositoryTest {
	@Autowired
	private BookRepository repository;
	
	@Test
	public void findByIsbnShouldReturnIsbn() {
		List<Book> books = repository.findByIsbn(1);
		
		assertThat(books).hasSize(1);
		assertThat(books.get(0).getIsbn()).isEqualTo(1);
	}
	
	@Test
	public void createNewBook(){
		Book book = new Book(10, "Java", "Heli", 2012, 142, new Category("Java"));
		repository.save(book);
		assertThat(book.getAuthor()).isNotNull();
	}

}
