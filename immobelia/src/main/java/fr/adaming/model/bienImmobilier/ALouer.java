package fr.adaming.model.bienImmobilier;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity(name = "aLouer")
@Table(name = "aLouer")
public class ALouer extends Offre{

	private Double montantCaution;
	private Double montantCharges;
	private boolean meuble;
	
	/**
	 * 
	 */
	public ALouer() {
	}
	
	public ALouer(Integer id, Double montantCaution, Double montantCharges, boolean meuble) {
		super(id);
		this.montantCaution = montantCaution;
		this.montantCharges = montantCharges;
		this.meuble = meuble;
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
