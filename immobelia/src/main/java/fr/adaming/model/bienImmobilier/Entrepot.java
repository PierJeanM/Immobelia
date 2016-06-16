package fr.adaming.model.bienImmobilier;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity(name="entrepot")
@DiscriminatorValue("entrepot")
public class Entrepot extends BienImmobilier{

	@Column(name = "preau")
	private boolean preau;
	
	public Entrepot() {
	}

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
