package hishmar.quartermaster;

import org.springframework.data.annotation.Id;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import lombok.Data;


@Data
public class Perishable {
	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String name;
	private int estimatedExpiryTime; //in days
	private Unit defaultUnit;
	private float density;// in g per ml
}
