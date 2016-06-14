package fr.adaming.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity(name = "contrat")
@Table(name = "contrats")
public class Contrat {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_contrat")
	private int idContrat;

	@OneToOne
	@JoinColumn(name="conseiller_id", referencedColumnName="id_conseiller")
	private ConseillerImmobilier conseiller_id;

	@OneToOne
	@JoinColumn(name="client_id", referencedColumnName="id_client")
	private Client client_id;

	@OneToOne
	@JoinColumn(name="conseiller_id", referencedColumnName="id_conseiller")
	private BienImmobilier bienImmobilier_id;

	@Column(name = "validationContrat")
	private boolean validationContrat;

	/**
	 * ctor vide
	 */
	public Contrat() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * ctor chargé avec id
	 * @param idContrat
	 * @param conseiller_id
	 * @param client_id
	 * @param bienImmobilier_id
	 * @param validationContrat
	 */
	public Contrat(int idContrat, int conseiller_id, int client_id,
			int bienImmobilier_id, boolean validationContrat) {
		super();
		this.idContrat = idContrat;
		this.conseiller_id = conseiller_id;
		this.client_id = client_id;
		this.bienImmobilier_id = bienImmobilier_id;
		this.validationContrat = validationContrat;
	}

	/**
	 * ctor chargé sans id
	 * @param conseiller_id
	 * @param client_id
	 * @param bienImmobilier_id
	 * @param validationContrat
	 */
	public Contrat(int conseiller_id, int client_id, int bienImmobilier_id,
			boolean validationContrat) {
		super();
		this.conseiller_id = conseiller_id;
		this.client_id = client_id;
		this.bienImmobilier_id = bienImmobilier_id;
		this.validationContrat = validationContrat;
	}

	
	/**************************
	 * GETTERS & SETTERS
	 *
	 *************************/	
	
	public int getIdContrat() {
		return idContrat;
	}

	public void setIdContrat(int idContrat) {
		this.idContrat = idContrat;
	}

	public int getConseiller_id() {
		return conseiller_id;
	}

	public void setConseiller_id(int conseiller_id) {
		this.conseiller_id = conseiller_id;
	}

	public int getClient_id() {
		return client_id;
	}

	public void setClient_id(int client_id) {
		this.client_id = client_id;
	}

	public int getBienImmobilier_id() {
		return bienImmobilier_id;
	}

	public void setBienImmobilier_id(int bienImmobilier_id) {
		this.bienImmobilier_id = bienImmobilier_id;
	}

	public boolean isValidationContrat() {
		return validationContrat;
	}

	public void setValidationContrat(boolean validationContrat) {
		this.validationContrat = validationContrat;
	}

}
