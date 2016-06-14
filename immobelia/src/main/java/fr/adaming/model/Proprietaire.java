package fr.adaming.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity(name = "proprietaire")
@Table(name = "proprietaires")
public class Proprietaire {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_proprietaire")
	private int idProprietaire;

	@Column(name = "nom")
	private String nom;

	@Column(name = "rue")
	private String rue;

	@Column(name = "numRue")
	private String numRue;

	@Column(name = "codePostal")
	private int codePostal;

	@Column(name = "ville")
	private String ville;

	@Column(name = "telPrive")
	private String telPrive;

	@Column(name = "telTravail")
	private String telTravail;

	@OneToMany(mappedBy = "proprietaire")
	private List<BienImmobilier> biensImmos;

	/**
	 * ctor vide
	 */
	public Proprietaire() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * ctor chargé avec id
	 * 
	 * @param idProprietaire
	 * @param nom
	 * @param rue
	 * @param numRue
	 * @param codePostal
	 * @param ville
	 * @param telPrive
	 * @param telTravail
	 * @param biensImmos
	 */
	public Proprietaire(int idProprietaire, String nom, String rue,
			String numRue, int codePostal, String ville, String telPrive,
			String telTravail, List<BienImmobilier> biensImmos) {
		super();
		this.idProprietaire = idProprietaire;
		this.nom = nom;
		this.rue = rue;
		this.numRue = numRue;
		this.codePostal = codePostal;
		this.ville = ville;
		this.telPrive = telPrive;
		this.telTravail = telTravail;
		this.biensImmos = biensImmos;
	}

	/**
	 * ctor chargé sans id
	 * 
	 * @param nom
	 * @param rue
	 * @param numRue
	 * @param codePostal
	 * @param ville
	 * @param telPrive
	 * @param telTravail
	 * @param biensImmos
	 */
	public Proprietaire(String nom, String rue, String numRue, int codePostal,
			String ville, String telPrive, String telTravail,
			List<BienImmobilier> biensImmos) {
		super();
		this.nom = nom;
		this.rue = rue;
		this.numRue = numRue;
		this.codePostal = codePostal;
		this.ville = ville;
		this.telPrive = telPrive;
		this.telTravail = telTravail;
		this.biensImmos = biensImmos;
	}

	
	/**************************
	 * GETTERS & SETTERS
	 *
	 *************************/	
	
	public int getIdProprietaire() {
		return idProprietaire;
	}

	public void setIdProprietaire(int idProprietaire) {
		this.idProprietaire = idProprietaire;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getRue() {
		return rue;
	}

	public void setRue(String rue) {
		this.rue = rue;
	}

	public String getNumRue() {
		return numRue;
	}

	public void setNumRue(String numRue) {
		this.numRue = numRue;
	}

	public int getCodePostal() {
		return codePostal;
	}

	public void setCodePostal(int codePostal) {
		this.codePostal = codePostal;
	}

	public String getVille() {
		return ville;
	}

	public void setVille(String ville) {
		this.ville = ville;
	}

	public String getTelPrive() {
		return telPrive;
	}

	public void setTelPrive(String telPrive) {
		this.telPrive = telPrive;
	}

	public String getTelTravail() {
		return telTravail;
	}

	public void setTelTravail(String telTravail) {
		this.telTravail = telTravail;
	}

	public List<BienImmobilier> getBiensImmos() {
		return biensImmos;
	}

	public void setBiensImmos(List<BienImmobilier> biensImmos) {
		this.biensImmos = biensImmos;
	}

}
