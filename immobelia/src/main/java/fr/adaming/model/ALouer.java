package fr.adaming.model;

public class ALouer implements Offre{

	private Double montantCaution;
	private Double montantCharges;
	private boolean meuble;
	
	/**
	 * 
	 */
	public ALouer() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param montantCaution
	 * @param montantCharges
	 * @param meuble
	 */
	public ALouer(Double montantCaution, Double montantCharges, boolean meuble) {
		super();
		this.montantCaution = montantCaution;
		this.montantCharges = montantCharges;
		this.meuble = meuble;
	}

	/**
	 * @return the montantCaution
	 */
	public Double getMontantCaution() {
		return montantCaution;
	}

	/**
	 * @param montantCaution the montantCaution to set
	 */
	public void setMontantCaution(Double montantCaution) {
		this.montantCaution = montantCaution;
	}

	/**
	 * @return the montantCharges
	 */
	public Double getMontantCharges() {
		return montantCharges;
	}

	/**
	 * @param montantCharges the montantCharges to set
	 */
	public void setMontantCharges(Double montantCharges) {
		this.montantCharges = montantCharges;
	}

	/**
	 * @return the meuble
	 */
	public boolean isMeuble() {
		return meuble;
	}

	/**
	 * @param meuble the meuble to set
	 */
	public void setMeuble(boolean meuble) {
		this.meuble = meuble;
	}
	
	
	
}
