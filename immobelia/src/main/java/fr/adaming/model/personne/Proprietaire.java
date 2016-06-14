package fr.adaming.model.personne;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import fr.adaming.model.bienImmobilier.BienImmobilier;

@Entity(name = "proprietaire")
@Table(name = "proprietaires")
public class Proprietaire extends Personne{

	@Column(name = "telTravail")
	private String telTravail;

	@OneToMany(mappedBy = "proprio")
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
	public Proprietaire(int idProprietaire, String nom, String prenom,
			String telPrive, String telTravail, Adresse adresse,
			List<BienImmobilier> biensImmos) {
		super(idProprietaire, nom, prenom, telPrive, adresse);
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
	public Proprietaire(String nom, String prenom, String telephone, Adresse adresse, 
			String telTravail, List<BienImmobilier> biensImmos) {
		super(nom, prenom, telephone, adresse);
		this.telTravail = telTravail;
		this.biensImmos = biensImmos;
	}

	
	/**************************
	 * GETTERS & SETTERS
	 *
	 *************************/	
	

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
