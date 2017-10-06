package chapter2.bookstore;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import chapter2.bookstore.domain.Book;
import chapter2.bookstore.domain.BookRepository;
import chapter2.bookstore.domain.Category;
import chapter2.bookstore.domain.CategoryRepository;
import chapter2.bookstore.domain.User;
import chapter2.bookstore.domain.UserRepository;

@SpringBootApplication
public class DemoApplication {
	private static final Logger log = LoggerFactory.getLogger(DemoApplication.class);
	
	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner bookDemo(BookRepository brepository, CategoryRepository crepository, UserRepository urepository) {
		return (args) -> {
			log.info("save a couple of books");
			crepository.save(new Category("SQL database"));
			crepository.save(new Category("Java Programming"));
			crepository.save(new Category("Frontend Developement"));
			
//			brepository.save(new Book(1, "Math", "Joonas", 2012, 142, crepository.findByName("SQL database").get(1)));
//			brepository.save(new Book(2, "Javascript", "Katy Perry", 2002, 87, crepository.findByName("Frontend Development").get(1)));	
			
//			jdbcTemplate.update("insert into student(isbn, title, author, year, price, name) values (?, ?, ?, ?, ?, ?)", 100, "SQL Advanced", "Amir Rahul", 2018, 28, "SQL database");
//			jdbcTemplate.update("insert into student(isbn, title, author, year, price, name) values (?, ?, ?, ?, ?, ?)", 200, "Introduction to Java", "Timmy Dogue", 2004, 70, "Java Programming");
//	        
			// Create users: admin/admin user/user
			User user1 = new User("user", "$2a$06$DA00YK7iTpEAJdVO0WOmFujMnqCF0vBTmkAL.FP9QBGftiPh3/38.", "a1603171@myy.haaga-helia.fi","USER");
			User user2 = new User("admin", "$2a$06$/UYvbL.Gz.eug9LIlEqud.IMGJuNZ5MUwXyl8tOmy/rgMYwQBuNCC", "khanh.2dbt@gmail.com","ADMIN");
			urepository.save(user1);
			urepository.save(user2);
			
			log.info("fetch all books");
			for (Book book : brepository.findAll()) {
				log.info(book.toString());
			}

		};
	}
}
