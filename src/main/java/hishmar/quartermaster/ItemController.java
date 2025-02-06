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
public class ItemController {

	private final ItemService service;
	
	ItemController(ItemService service){
		this.service = service;
	}
	
	@GetMapping("/items")
	List<Item> getAll(){
		return service.getAll();
	}
	@GetMapping("/items/{id}")
	Item get(@PathVariable String id) {
		return service.getItem(id);
	}
	
	@PostMapping("/items")
	Item add(@RequestBody Item item) {
		return service.save(item);
	}
	
	@PutMapping("/items/{id}")
	Item update(@RequestBody Item item, @PathVariable String id) {
		item.setItemId(id);
		return service.update(item);
	}
	
	@DeleteMapping("/items/{id}")
	void delete(@PathVariable String id) {
		service.delete(id);
	}
}
