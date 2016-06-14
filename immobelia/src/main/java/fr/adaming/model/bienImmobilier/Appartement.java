package fr.adaming.model.bienImmobilier;

import javax.persistence.DiscriminatorValue;

@DiscriminatorValue("appartement")
public class Appartement extends BienImmobilier{

	private boolean balcon;

	/**
	 * @param balcon
	 */
	public Appartement(boolean balcon) {
		super();
		this.balcon = balcon;
	}

	/**
	 * @return the balcon
	 */
	public boolean isBalcon() {
		return balcon;
	}

	/**
	 * @param balcon the balcon to set
	 */
	public void setBalcon(boolean balcon) {
		this.balcon = balcon;
	}
	
	
	
}
