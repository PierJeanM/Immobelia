package fr.adaming.model.bienImmobilier;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity(name = "emplacement")
@DiscriminatorValue("emplacement")
public class Emplacement extends BienImmobilier{

	
	private boolean garage;
	
	public Emplacement() {
	}

	/**
	 * @param garage
	 */
	public Emplacement(boolean garage) {
		super();
		this.garage = garage;
	}

	/**
	 * @return the garage
	 */
	public boolean isGarage() {
		return garage;
	}

	/**
	 * @param garage the garage to set
	 */
	public void setGarage(boolean garage) {
		this.garage = garage;
	}
	
	
	
	
}
