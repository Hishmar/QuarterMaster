package hishmar.quartermaster;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbBean;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbPartitionKey;


@DynamoDbBean
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Item {
	private String itemId;
	@Setter
	private LocalDate expiryStart;
	@Setter
	private LocalDate expectedExpiry;
	@Setter
	private float amount;
	@Setter
	private String category;

	@DynamoDbPartitionKey
	public void setItemId(String itemId) {
		this.itemId = itemId;
	}

	public Item(String itemId){
		this.itemId= itemId;
	}
}
