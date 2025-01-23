package hishmar.quartermaster;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import io.awspring.cloud.dynamodb.DynamoDbTemplate;
import software.amazon.awssdk.enhanced.dynamodb.Key;
import software.amazon.awssdk.enhanced.dynamodb.model.QueryEnhancedRequest;

@Repository
public class CategoryRepository {

	@Autowired
	DynamoDbTemplate dynamoDbTemplate;
	
	
	public List<Category> getAll() {
		List<Category> categories = new ArrayList<Category>();
		dynamoDbTemplate.scanAll(Category.class).items().forEach(categories::add);
		return categories;
	}
	
	//TODO: exception for if the category doesn't exist
	public Category getCategory(String name) {
		Key key = Key.builder().partitionValue(name).build();
		return dynamoDbTemplate.load(key, Category.class);
	}
	
//TODO: method to retrieve all categories of a certain type
//	public List<Category> getCategoriesByType() {
//		List<Category> categories = new ArrayList<Category>();
//		return categories;
//	}

	public Category save(Category category) {
		return dynamoDbTemplate.save(category);
	}
	
	public Category update(Category category) {
		if(category.getName()!=null) {
		return dynamoDbTemplate.update(category);
		}
		//TODO: should be some kind of exception path specifically here if the category to update is missing a key
		else return null;
	}
	public void delete(Category category) {
		dynamoDbTemplate.delete(category);
	}
}
