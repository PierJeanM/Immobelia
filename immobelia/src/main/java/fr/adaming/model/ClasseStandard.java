package fr.adaming.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import fr.adaming.model.bienImmobilier.Offre;

@Entity(name="classe_standard")
@Table(name="classes_standards")
public class ClasseStandard {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_classe_standard")
	private Integer idClasseStandard;
	@Column(name="superficie_min")
	private Double superficieMin;
	@Column(name="prix_max")
	private Double prixMax;
	@Column(name="nombre_chambres")
	private int nombreChambres;

	@ManyToOne
	@JoinColumn(name = "type_offre", referencedColumnName = "id_offre")
	private Offre typeOffre;
	@Column(name="type_bien")
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
