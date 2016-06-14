package fr.adaming.model.bienImmobilier;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;

@DiscriminatorValue("entrepot")
public class Entrepot extends BienImmobilier{

	@Column(name = "preau")
	private boolean preau;

	/**
	 * @param preau
	 */
	public Entrepot(boolean preau) {
		super();
		this.preau = preau;
	}

	/**
	 * @return the preau
	 */
	public boolean isPreau() {
		return preau;
	}

	/**
	 * @param preau the preau to set
	 */
	public void setPreau(boolean preau) {
		this.preau = preau;
	}
	
	
	
	
}
