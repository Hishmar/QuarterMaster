package hishmar.quartermaster;

import java.util.List;

public class ItemService {
    	
	private final ItemRepository repo;
	
	ItemService(ItemRepository repo){
		this.repo = repo;
	}

	public List<Item> getItemsInCategory() {
		return repo.getItemsInCategory();
	}

	public Item save(Item category) {
		return repo.save(category);
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
