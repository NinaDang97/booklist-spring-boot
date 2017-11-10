package chapter2.bookstore;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import static org.assertj.core.api.Assertions.assertThat;

import chapter2.bookstore.web.BookController;

@RunWith(SpringRunner.class) //tell JUnit run using Spring testing support
@SpringBootTest //regular test
public class DemoApplicationTests {

	@Autowired
	private BookController controller;
	
	@Test //define method for testing
	public void contextLoads() throws Exception{
		assertThat(controller).isNotNull();
	}

}
