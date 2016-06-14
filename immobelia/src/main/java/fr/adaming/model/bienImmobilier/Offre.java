package fr.adaming.model.bienImmobilier;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

@Entity(name = "offre")
@Table(name = "offres")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class Offre {
	
	@Id
	@GeneratedValue(strategy = GenerationType.TABLE)
	@Column(name = "id_offre")
	private Integer id;
	
	public Offre() {
	}	

	public Offre(int id) {
		this.id = id;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
}
