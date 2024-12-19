package hishmar.quartermaster;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CategoryController {

	private final CategoryService service;
	
	CategoryController(CategoryService service){
		this.service = service;
	}
	
	@GetMapping("/categories")
	List<Category> getAll(){
		return service.getCategories();
	}
	@GetMapping("/categories/{name}")
	Category get(@PathVariable String name) {
		return service.getCategory(name);
	}
	
	@PostMapping("/categories")
	void add(@RequestBody Category category) {
		service.save(category);
	}
	
	@PutMapping("/categories/{name}")
	Category update(@RequestBody Category category, @PathVariable String name) {
		category.setName(name);
		return service.update(category);
	}
	
	@DeleteMapping("/categories/{id}")
	void delete(@PathVariable String name) {
		service.delete(name);
	}
}
