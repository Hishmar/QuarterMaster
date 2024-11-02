package hishmar.quartermaster;

import lombok.Data;

@Data
public class Perishable {
	private int id;
	private String name;
	private int estimatedExpiryTime; //in days
	private Unit defaultUnit;
	private float density;// in g per ml
}
