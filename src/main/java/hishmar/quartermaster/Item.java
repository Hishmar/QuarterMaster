package hishmar.quartermaster;

import java.time.LocalDate;

import lombok.Data;

@Data
public class Item {
	private int id;
	private LocalDate expiryStart;
	private LocalDate expectedExpiry;
	private float amount;
}
