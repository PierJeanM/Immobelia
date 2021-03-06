package fr.adaming.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import fr.adaming.model.personne.Client;

@Entity(name="classe_standard")
@Table(name="classes_standards")
public class ClasseStandard {
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "ClasseStandard [superficieMin=" + superficieMin + ", prixMax="
				+ prixMax + ", nombreChambres=" + nombreChambres
				+ ", typeOffre=" + typeOffre + ", typeBien=" + typeBien + "]";
	}

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

	@Column(name="type_offre")
	private String typeOffre;
	
	@Column(name="type_bien")
	private String typeBien;
	
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name="client_classeStandard", joinColumns = {@JoinColumn(name="id_classestandard")},inverseJoinColumns={@JoinColumn(name="id_client")})
	private List<Client> listClients;
	
	public ClasseStandard() {
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
			Double prixMax, int nombreChambres, String typeOffre, String typeBien) {
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
			int nombreChambres, String typeOffre, String typeBien) {
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
	public String getTypeOffre() {
		return typeOffre;
	}

	/**
	 * @param typeOffre the typeOffre to set
	 */
	public void setTypeOffre(String typeOffre) {
		this.typeOffre = typeOffre;
	}

	/**
	 * @return the typeBien
	 */
	public String getTypeBien() {
		return typeBien;
	}

	/**
	 * Faire attention à typer bas
	 * 
	 * @param typeBien the typeBien to set
	 */
	public void setTypeBien(String typeBien) {
		this.typeBien = typeBien;
	}

	public List<Client> getListClients() {
		return listClients;
	}

	public void setListClients(List<Client> listClients) {
		this.listClients = listClients;
	}
}
