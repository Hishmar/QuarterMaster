package hishmar.quartermaster;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PerishableController {

	private final PerishableRepository repo;
	
	PerishableController(PerishableRepository repo){
		this.repo = repo;
	}
	
	@GetMapping
	List<Perishable> getAll(){
		return repo.getPerishables();
	}
	
	@PostMapping
	Perishable add(@RequestBody Perishable perishable) {
		return repo.save(perishable);
	}
	
	@DeleteMapping
	void delete(@PathVariable String name) {
		repo.delete();
	}
}
