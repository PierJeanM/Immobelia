package fr.adaming.model.bienImmobilier;

import javax.persistence.DiscriminatorValue;

@DiscriminatorValue("studio")
public class Studio extends BienImmobilier{
 
	private boolean mezzanine;

	/**
	 * @param mezzanine
	 */
	public Studio(boolean mezzanine) {
		super();
		this.mezzanine = mezzanine;
	}

	/**
	 * @return the mezzanine
	 */
	public boolean isMezzanine() {
		return mezzanine;
	}

	/**
	 * @param mezzanine the mezzanine to set
	 */
	public void setMezzanine(boolean mezzanine) {
		this.mezzanine = mezzanine;
	}
	
	
	
}
