package fr.adaming.model.bienImmobilier;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity(name="terrain")
@DiscriminatorValue("terrain")
public class Terrain extends BienImmobilier {
	@Column(name = "etang")
	private boolean etang;
	
	public Terrain() {
	}

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
