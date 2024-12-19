package hishmar.quartermaster;

import java.time.LocalDate;

import lombok.Data;

@Data
public class Item {
	private Long itemId;
	private LocalDate expiryStart;
	private LocalDate expectedExpiry;
	private float amount;
	private Category category;
}
