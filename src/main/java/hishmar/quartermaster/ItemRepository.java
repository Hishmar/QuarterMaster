package hishmar.quartermaster;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import io.awspring.cloud.dynamodb.DynamoDbTemplate;
import software.amazon.awssdk.enhanced.dynamodb.Key;
import software.amazon.awssdk.enhanced.dynamodb.model.QueryEnhancedRequest;

@Repository
public class ItemRepository {

	@Autowired
	DynamoDbTemplate dynamoDbTemplate;

	public List<Item> getItemsInCategory(String category) {
		List<Item> items = new ArrayList<Item>();
		dynamoDbTemplate.scanAll(Item.class, category).items().forEach(items::add);
		return items;
	}

	public Item save(Item item) {
		return dynamoDbTemplate.save(item);
	}

	public void delete(Item item) {
		dynamoDbTemplate.delete(item);		
	}

    public List<Item> getAll() {
		List<Item> items = new ArrayList<Item>();
		dynamoDbTemplate.scanAll(Item.class).items().forEach(items::add);
		return items;
    }

    public Item update(Item item) {
		if(item.getItemId()!=null){
			return dynamoDbTemplate.update(item);
		}
		//TODO: should be some kind of exception path specifically here if the category to update is missing a key
		else return null;
    }

    public Item getItem(Long id) {
		Key key = Key.builder().partitionValue(id).build();
		return dynamoDbTemplate.load(key, Item.class);
    }
}