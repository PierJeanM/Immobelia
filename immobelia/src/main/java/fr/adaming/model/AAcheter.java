package fr.adaming.model;

public class AAcheter implements Offre{

	private String etat;
	
	public AAcheter() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param etat
	 */
	public AAcheter(String etat) {
		super();
		this.etat = etat;
	}

	/**
	 * @return the etat
	 */
	public String getEtat() {
		return etat;
	}

	/**
	 * @param etat the etat to set
	 */
	public void setEtat(String etat) {
		this.etat = etat;
	}
	
	
	
}
