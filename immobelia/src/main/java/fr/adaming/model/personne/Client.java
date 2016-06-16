package fr.adaming.model.personne;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import fr.adaming.model.ClasseStandard;

@Entity(name = "client")
@Table(name = "clients")
public class Client extends Personne {

	@ManyToMany(mappedBy = "listClients")
	private List<ClasseStandard> bienRecherche;

	@ManyToOne
	@JoinColumn(name = "conseiller_id", referencedColumnName = "id")
	private ConseillerImmobilier conseillerImmobilier;

	/**
	 * ctor vide
	 */
	public Client() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * ctor chargé avec id
	 * 
	 * @param id_client
	 * @param nom
	 * @param telephone
	 * @param adresse
	 * @param bienRecherche
	 */
	public Client(int id_client, String nom, String prenom, String telephone,
			Adresse adresse, List<ClasseStandard> bienRecherche) {
		super(id_client, nom, prenom, telephone, adresse);
		this.bienRecherche = bienRecherche;
	}

	/**
	 * ctor chargé sans id
	 * 
	 * @param nom
	 * @param telephone
	 * @param adresse
	 * @param bienRecherche
	 */
	public Client(String nom, String prenom, String telephone, Adresse adresse,
			List<ClasseStandard> bienRecherche) {
		super(nom, prenom, telephone, adresse);
		this.bienRecherche = bienRecherche;
	}

	/**************************
	 * GETTERS & SETTERS
	 *
	 *************************/

	public List<ClasseStandard> getBienRecherche() {
		return bienRecherche;
	}

	public void setBienRecherche(List<ClasseStandard> bienRecherche) {
		this.bienRecherche = bienRecherche;
	}

	public ConseillerImmobilier getConseillerImmobilier() {
		return conseillerImmobilier;
	}

	public void setConseillerImmobilier(
			ConseillerImmobilier conseillerImmobilier) {
		this.conseillerImmobilier = conseillerImmobilier;
	}

}
