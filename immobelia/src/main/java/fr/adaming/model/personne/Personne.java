package fr.adaming.model.personne;

// Imports
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity(name = "personne")
@Table(name = "personnes")
@Inheritance(strategy=InheritanceType.TABLE_PER_CLASS)
public abstract class Personne {

	/****************************************************************************/
	/****************************** DECLARATIONS ********************************/
	/****************************************************************************/

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@Column(name = "nom")
	private String nom;

	@Column(name = "prenom")
	private String prenom;

	@Column(name = "telephone")
	private String telephone;

	@OneToOne
	@JoinColumn(name = "adresse_id", referencedColumnName = "id_adresse")
	private Adresse adresse;

	/****************************************************************************/
	/****************************** CONSTRUCTEURS *******************************/
	/****************************************************************************/

	/**
	 * Constructeur chargé
	 * 
	 * @param nom
	 * @param prenom
	 * @param id_personne
	 * @param telephone
	 * @param adresse
	 */
	public Personne(int id, String nom, String prenom,
			String telephone, Adresse adresse) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.id = id;
		this.telephone = telephone;
		this.adresse = adresse;
	} // Fin constructeur chargé

	/**
	 * Constructeur sans Id
	 * 
	 * @param nom
	 * @param prenom
	 * @param telephone
	 * @param adresse
	 */
	public Personne(String nom, String prenom, String telephone, Adresse adresse) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.telephone = telephone;
		this.adresse = adresse;
	} // Fin constructeur sans Id

	/**
	 * Constructeur vide
	 */
	public Personne() {
		super();
	} // Fin constructeur vide

	/****************************************************************************/
	/********************************* METHODES *********************************/
	/****************************************************************************/

	@Override
	public String toString() {
		return "Personne [nom=" + nom + ", prenom=" + prenom + ", id_personne="
				+ id + ", telephone=" + telephone + "]";
	} // Fin methode toString

	/****************************************************************************/
	/****************************** GETTERS_SETTERS *****************************/
	/****************************************************************************/

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public int getId_personne() {
		return id;
	}

	public void setId_personne(int id_personne) {
		this.id = id_personne;
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

} // Fin classe Personne
