package hishmar.quartermaster;

import java.util.List;

import org.springframework.stereotype.Service;


@Service
public class CategoryService {
	
	private final CategoryRepository repo;
	
	CategoryService(CategoryRepository repo){
		this.repo = repo;
	}

	public List<Category> getCategories() {
		return repo.getAll();
	}

	public Category save(Category category) {
		return repo.save(category);
	}

	public void delete(String name) {
		Category deleted = new Category(name);
		repo.delete(deleted);
		
	}

	public Category update(Category category) {
		return repo.update(category);
	}

	public Category getCategory(String name) {
		return repo.getCategory(name);
	}

}
