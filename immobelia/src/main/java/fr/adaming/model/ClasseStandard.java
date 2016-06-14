package fr.adaming.model;

import fr.adaming.model.bienImmobilier.Offre;

public class ClasseStandard {
	
	private Integer idClasseStandard;
	private Double superficieMin;
	private Double prixMax;
	private int nombreChambres;
	private Offre typeOffre;
	private Class<?> typeBien;
	
	public ClasseStandard() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param idClasseStandard
	 * @param superficieMin
	 * @param prixMax
	 * @param nombreChambres
	 * @param typeOffre
	 * @param typeBien
	 */
	public ClasseStandard(Integer idClasseStandard, Double superficieMin,
			Double prixMax, int nombreChambres, Offre typeOffre, Class<?> typeBien) {
		super();
		this.idClasseStandard = idClasseStandard;
		this.superficieMin = superficieMin;
		this.prixMax = prixMax;
		this.nombreChambres = nombreChambres;
		this.typeOffre = typeOffre;
		this.typeBien = typeBien;
	}

	/**
	 * @param superficieMin
	 * @param prixMax
	 * @param nombreChambres
	 * @param typeOffre
	 * @param typeBien
	 */
	public ClasseStandard(Double superficieMin, Double prixMax,
			int nombreChambres, Offre typeOffre, Class<?> typeBien) {
		super();
		this.superficieMin = superficieMin;
		this.prixMax = prixMax;
		this.nombreChambres = nombreChambres;
		this.typeOffre = typeOffre;
		this.typeBien = typeBien;
	}

	/**
	 * @return the idClasseStandard
	 */
	public Integer getIdClasseStandard() {
		return idClasseStandard;
	}

	/**
	 * @param idClasseStandard the idClasseStandard to set
	 */
	public void setIdClasseStandard(Integer idClasseStandard) {
		this.idClasseStandard = idClasseStandard;
	}

	/**
	 * @return the superficieMin
	 */
	public Double getSuperficieMin() {
		return superficieMin;
	}

	/**
	 * @param superficieMin the superficieMin to set
	 */
	public void setSuperficieMin(Double superficieMin) {
		this.superficieMin = superficieMin;
	}

	/**
	 * @return the prixMax
	 */
	public Double getPrixMax() {
		return prixMax;
	}

	/**
	 * @param prixMax the prixMax to set
	 */
	public void setPrixMax(Double prixMax) {
		this.prixMax = prixMax;
	}

	/**
	 * @return the nombreChambres
	 */
	public int getNombreChambres() {
		return nombreChambres;
	}

	/**
	 * @param nombreChambres the nombreChambres to set
	 */
	public void setNombreChambres(int nombreChambres) {
		this.nombreChambres = nombreChambres;
	}

	/**
	 * @return the typeOffre
	 */
	public Offre getTypeOffre() {
		return typeOffre;
	}

	/**
	 * @param typeOffre the typeOffre to set
	 */
	public void setTypeOffre(Offre typeOffre) {
		this.typeOffre = typeOffre;
	}

	/**
	 * @return the typeBien
	 */
	public Class<?> getTypeBien() {
		return typeBien;
	}

	/**
	 * Faire attention à typer bas
	 * 
	 * @param typeBien the typeBien to set
	 */
	public void setTypeBien(Class<?> typeBien) {
		this.typeBien = typeBien;
	}
	
	
	

}
