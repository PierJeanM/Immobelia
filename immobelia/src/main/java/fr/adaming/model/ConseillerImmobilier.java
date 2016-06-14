package fr.adaming.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity(name="conseillerImmobilier")
@Table(name="conseillersImmobilier")
public class ConseillerImmobilier extends Personne {

	/****************************************************************************/
	/****************************** DECLARATIONS ********************************/
	/****************************************************************************/
	
	/****************************************************************************/
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_conseiller")
	private int id_conseiller;
	
	@Column(name="password")
	private String motDePasse;

	/*************************** Declaration_associations *************************/
	@OneToMany(mappedBy="visite")
	private List<Visite> listVisites;
	
	/****************************************************************************/
	/****************************** CONSTRUCTEURS *******************************/
	/****************************************************************************/
	
	/**
	 * Constructeur Chargé
	 * @param nom
	 * @param prenom
	 * @param id_personne
	 * @param telephone
	 * @param adresse
	 * @param id_conseiller
	 * @param motDePasse
	 */
	public ConseillerImmobilier(String nom, String prenom, int id_personne,
			String telephone, Adresse adresse, int id_conseiller,
			String motDePasse) {
		super(nom, prenom, id_personne, telephone, adresse);
		this.id_conseiller = id_conseiller;
		this.motDePasse = motDePasse;
	}

	/**
	 * Constructeur sans Id
	 * @param nom
	 * @param prenom
	 * @param id_personne
	 * @param telephone
	 * @param adresse
	 * @param motDePasse
	 */
	public ConseillerImmobilier(String nom, String prenom, int id_personne,
			String telephone, Adresse adresse, String motDePasse) {
		super(nom, prenom, id_personne, telephone, adresse);
		this.motDePasse = motDePasse;
	}

	/**
	 * Constructeur vide
	 */
	public ConseillerImmobilier() {
		super();
		// TODO Auto-generated constructor stub
	}

	/****************************************************************************/
	/********************************* METHODES *********************************/
	/****************************************************************************/
	
	@Override
	public String toString() {
		return "ConseillerImmobilier [id_conseiller=" + id_conseiller
				+ ", motDePasse=" + motDePasse + "]";
	} // Fin methode toString

	/****************************************************************************/
	/****************************** GETTERS_SETTERS *****************************/
	/****************************************************************************/
	
	public int getId_conseiller() {
		return id_conseiller;
	}

	public void setId_conseiller(int id_conseiller) {
		this.id_conseiller = id_conseiller;
	}

	public String getMotDePasse() {
		return motDePasse;
	}

	public void setMotDePasse(String motDePasse) {
		this.motDePasse = motDePasse;
	}
		
} // Fin classe ConseillerImmobilier
