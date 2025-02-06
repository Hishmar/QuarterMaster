package hishmar.quartermaster;

import java.util.List;
import java.util.UUID;

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
		item.setItemId(UUID.randomUUID().toString());
		return repo.save(item);
	}

	//TODO: batch save could be useful in the future
	// public List<Item> batchSave(List<Item> items){
	// 	return items;
	// }

	public void delete(String id) {
		Item deleted = new Item(id);
		repo.delete(deleted);
	}

	public Item update(Item item) {
		//TODO: should be some kind of exception path specifically here if the category to update is missing a key
		return repo.update(item);
	}

	public Item getItem(String id) {
		return repo.getItem(id);
	}

	public List<Item> getAll(){
		return repo.getAll();
	}



}
