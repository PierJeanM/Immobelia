package fr.adaming.model.bienImmobilier;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity(name = "offre")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class Offre {
	
	@Id
	@GeneratedValue(strategy = GenerationType.TABLE)
	@Column(name = "id_offre")
	private Integer id;
	
	@OneToOne
	@JoinColumn(name="bien_immobilier", referencedColumnName="id_bien")
	private BienImmobilier bienImmobilier;
	
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
