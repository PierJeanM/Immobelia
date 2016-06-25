package fr.adaming.model.bienImmobilier;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity(name = "aAcheter")
@Table(name = "aAcheter")
public class AAcheter extends Offre{

	private String etat;
	
	public AAcheter() {
		super();
	}
	
	public AAcheter(Integer id, String etat) {
		super(id);
		this.etat = etat;
	}

	/**
	 * @param etat
	 */
	public AAcheter(String etat) {
		super();
		this.etat = etat;
	}

	/**
	 * @return the etat
	 */
	public String getEtat() {
		return etat;
	}

	/**
	 * @param etat the etat to set
	 */
	public void setEtat(String etat) {
		this.etat = etat;
	}
}
