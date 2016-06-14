package fr.adaming.model;

import javax.persistence.DiscriminatorValue;

@DiscriminatorValue("emplacement")
public class Emplacement extends BienImmobilier{

	
	private boolean garage;

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
