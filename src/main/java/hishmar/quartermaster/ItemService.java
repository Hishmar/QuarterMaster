package hishmar.quartermaster;

import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class ItemService {
    	
	private final ItemRepository repo;
	
	ItemService(ItemRepository repo){
		this.repo = repo;
	}

	public List<Item> getItemsInCategory(String category) {
		return repo.getItemsInCategory(category);
	}

	public Item save(Item item) {
		return repo.save(item);
	}

	public void delete(Long id) {
		Item deleted = new Item(id);
		repo.delete(deleted);
		
	}

	public Item update(Item category) {
		return repo.update(category);
	}

	public Item getItem(Long id) {
		return repo.getItem(id);
	}

	public List<Item> getAll(){
		return repo.getAll();
	}



}
