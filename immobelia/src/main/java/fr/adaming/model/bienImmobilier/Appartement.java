package fr.adaming.model.bienImmobilier;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity(name="appartement")
@Table(name="appartements")
@DiscriminatorValue("appartement")
public class Appartement extends BienImmobilier {
	@Column(name = "balcon")
	private boolean balcon;
	
	public Appartement() {
	}

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
	 * @param balcon
	 *            the balcon to set
	 */
	public void setBalcon(boolean balcon) {
		this.balcon = balcon;
	}

}
