package hishmar.quartermaster;

import java.util.List;

import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbBean;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbPartitionKey;

@DynamoDbBean
public class Category {
	private String name;
	private String type;
	private Integer estimatedExpiryTime;
	private Unit defaultUnit;
	private Float density;// in g per ml
	private List<String> tags;
	
	@DynamoDbPartitionKey
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public Integer getEstimatedExpiryTime() {
		return estimatedExpiryTime;
	}
	public void setEstimatedExpiryTime(Integer estimatedExpiryTime) {
		this.estimatedExpiryTime = estimatedExpiryTime;
	}
	
	public Unit getDefaultUnit() {
		return defaultUnit;
	}
	public void setDefaultUnit(Unit defaultUnit) {
		this.defaultUnit = defaultUnit;
	}
	public Float getDensity() {
		return density;
	}

	public void setDensity(Float density) {
		this.density = density;
	}
	public List<String> getTags() {
		return tags;
	}
	public void setTags(List<String> tags) {
		this.tags = tags;
	}

	
	public Category(String name, String type, Integer estimatedExpiryTime, Unit defaultUnit, Float density,
			List<String> tags) {
		super();
		this.name = name;
		this.type = type;
		this.estimatedExpiryTime = estimatedExpiryTime;
		this.defaultUnit = defaultUnit;
		this.density = density;
		this.tags = tags;
	}
	
	public Category(String name) {
		this.name = name;
	}
	
	public Category() {
		
	}
}
