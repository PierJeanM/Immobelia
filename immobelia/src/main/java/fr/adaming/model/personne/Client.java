package fr.adaming.model.personne;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import fr.adaming.model.ClasseStandard;

@Entity(name="client")
@Table(name="clients")
public class Client extends Personne{
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_client")
	private int id_client;
	
	@Column(name="nom")
	private String nom;
	
	@Column(name="telephone")
	private String telephone;
	
	@Column(name="adresse")
	private Adresse adresse;
	
	@OneToMany(mappedBy="client")
	private List<ClasseStandard> bienRecherche;
	
	/**
	 * ctor vide
	 */
	public Client() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * ctor chargé avec id
	 * @param id_client
	 * @param nom
	 * @param telephone
	 * @param adresse
	 * @param bienRecherche
	 */
	public Client(int id_client, String nom, String telephone,
			Adresse adresse, List<ClasseStandard> bienRecherche) {
		super();
		this.id_client = id_client;
		this.nom = nom;
		this.telephone = telephone;
		this.adresse = adresse;
		this.bienRecherche = bienRecherche;
	}

	/**
	 * ctor chargé sans id
	 * @param nom
	 * @param telephone
	 * @param adresse
	 * @param bienRecherche
	 */
	public Client(String nom, String telephone, Adresse adresse,
			List<ClasseStandard> bienRecherche) {
		super();
		this.nom = nom;
		this.telephone = telephone;
		this.adresse = adresse;
		this.bienRecherche = bienRecherche;
	}

	/**************************
	 * GETTERS & SETTERS
	 *
	 *************************/	
	
	public int getId_client() {
		return id_client;
	}

	public void setId_client(int id_client) {
		this.id_client = id_client;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public Adresse getAdresse() {
		return adresse;
	}

	public void setAdresse(Adresse adresse) {
		this.adresse = adresse;
	}

	public List<ClasseStandard> getBienRecherche() {
		return bienRecherche;
	}

	public void setBienRecherche(List<ClasseStandard> bienRecherche) {
		this.bienRecherche = bienRecherche;
	}
	
	
	
	
	
	
	
	

}
