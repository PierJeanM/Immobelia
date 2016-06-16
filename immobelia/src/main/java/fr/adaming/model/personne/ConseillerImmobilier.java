package fr.adaming.model.personne;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import fr.adaming.model.Visite;

@Entity(name = "conseillerImmobilier")
@Table(name = "conseillersImmobilier")
public class ConseillerImmobilier extends Personne {

	/****************************************************************************/
	/****************************** DECLARATIONS ********************************/
	/****************************************************************************/

	/****************************************************************************/

	@Column(name = "password")
	private String motDePasse;

	/*************************** Declaration_associations *************************/
	@OneToMany(mappedBy = "conseiller")
	private List<Visite> listVisites;

	/****************************************************************************/
	/****************************** CONSTRUCTEURS *******************************/
	/****************************************************************************/

	/**
	 * Constructeur Chargé
	 * 
	 * @param nom
	 * @param prenom
	 * @param id_personne
	 * @param telephone
	 * @param adresse
	 * @param id_conseiller
	 * @param motDePasse
	 */
	public ConseillerImmobilier(int id_personne, String nom, String prenom,
			String telephone, Adresse adresse, int id_conseiller,
			String motDePasse, List<Visite> listVisites) {
		super(id_personne, nom, prenom, telephone, adresse);
		this.motDePasse = motDePasse;
		this.listVisites = listVisites;
	}

	/**
	 * Constructeur sans Id
	 * 
	 * @param nom
	 * @param prenom
	 * @param id_personne
	 * @param telephone
	 * @param adresse
	 * @param motDePasse
	 */
	public ConseillerImmobilier(String nom, String prenom, String telephone,
			Adresse adresse, String motDePasse, List<Visite> listVisites) {
		super(nom, prenom, telephone, adresse);
		this.motDePasse = motDePasse;
		this.listVisites = listVisites;
	}

	/**
	 * Constructeur vide
	 */
	public ConseillerImmobilier() {
		super();
		// TODO Auto-generated constructor stub
	}

	/****************************************************************************/
	/****************************** GETTERS_SETTERS *****************************/
	/****************************************************************************/

	public String getMotDePasse() {
		return motDePasse;
	}

	public void setMotDePasse(String motDePasse) {
		this.motDePasse = motDePasse;
	}

} // Fin classe ConseillerImmobilier
