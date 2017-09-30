package chapter2.bookstore.domain;

import java.util.List;
import org.springframework.data.repository.CrudRepository;

import chapter2.bookstore.domain.Category;

public interface CategoryRepository extends CrudRepository<Category, Long>{
	  List<Category> findByName(String name);
}
