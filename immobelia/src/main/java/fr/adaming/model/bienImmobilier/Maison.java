package fr.adaming.model.bienImmobilier;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity(name="maison")
@Table(name="maisons")
@DiscriminatorValue("maison")
public class Maison extends BienImmobilier {

	@Column(name = "jardin")
	private boolean jardin;

	/**
	 * @param jardin
	 */
	public Maison(boolean jardin) {
		super();
		this.jardin = jardin;
	}

	/**
	 * @return the jardin
	 */
	public boolean isJardin() {
		return jardin;
	}

	/**
	 * @param jardin
	 *            the jardin to set
	 */
	public void setJardin(boolean jardin) {
		this.jardin = jardin;
	}

}
