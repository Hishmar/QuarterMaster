package hishmar.quartermaster;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ItemController {

	private final ItemRepository repo;
	
	ItemController(ItemRepository repo){
		this.repo = repo;
	}
	
//	@GetMapping
	List<Item> getAll(){
		return repo.getItems();
	}
	
//	@PostMapping
	Item add(@RequestBody Item item) {
		return repo.save(item);
	}
	
//	@DeleteMapping
	void delete(@PathVariable String name) {
		repo.delete();
	}
}
