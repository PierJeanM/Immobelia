package fr.adaming.model.bienImmobilier;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity(name="terrain")
@Table(name="terrains")
@DiscriminatorValue("terrain")
public class Terrain extends BienImmobilier {
	@Column(name = "etang")
	private boolean etang;

	/**
	 * @param etang
	 */
	public Terrain(boolean etang) {
		super();
		if (this.getTypeOffre().getClass().getSimpleName().equals("AAcheter")) {
			((AAcheter) this.getTypeOffre()).setEtat(null);
		}
		this.etang = etang;
	}

	/**
	 * @return the etang
	 */
	public boolean isEtang() {
		return etang;
	}

	/**
	 * @param etang
	 *            the etang to set
	 */
	public void setEtang(boolean etang) {
		this.etang = etang;
	}

}
