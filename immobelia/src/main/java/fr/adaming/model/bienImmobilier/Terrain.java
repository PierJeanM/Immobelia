package fr.adaming.model.bienImmobilier;

import javax.persistence.DiscriminatorValue;

@DiscriminatorValue("terrain")
public class Terrain extends BienImmobilier{

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
	 * @param etang the etang to set
	 */
	public void setEtang(boolean etang) {
		this.etang = etang;
	}
	
	
	
}
