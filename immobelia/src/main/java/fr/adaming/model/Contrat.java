package fr.adaming.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import fr.adaming.model.bienImmobilier.BienImmobilier;
import fr.adaming.model.personne.Client;
import fr.adaming.model.personne.ConseillerImmobilier;

@Entity(name = "contrat")
@Table(name = "contrats")
public class Contrat {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_contrat")
	private int idContrat;

	@OneToOne
	@JoinColumn(name="conseiller_id", referencedColumnName="id")
	private ConseillerImmobilier conseillerId;

	@OneToOne
	@JoinColumn(name="client_id", referencedColumnName="id")
	private Client clientId;

	@OneToOne
	@JoinColumn(name="conseiller_id", referencedColumnName="id")
	private BienImmobilier bienImmobilierId;

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
	 * @param conseillerId
	 * @param clientId
	 * @param bienImmobilierId
	 * @param validationContrat
	 */
	public Contrat(int idContrat, ConseillerImmobilier conseillerId,
			Client clientId, BienImmobilier bienImmobilierId,
			boolean validationContrat) {
		super();
		this.idContrat = idContrat;
		this.conseillerId = conseillerId;
		this.clientId = clientId;
		this.bienImmobilierId = bienImmobilierId;
		this.validationContrat = validationContrat;
	}

	/**
	 * ctor chargé sans id
	 * @param conseillerId
	 * @param clientId
	 * @param bienImmobilierId
	 * @param validationContrat
	 */
	public Contrat(ConseillerImmobilier conseillerId, Client clientId,
			BienImmobilier bienImmobilierId, boolean validationContrat) {
		super();
		this.conseillerId = conseillerId;
		this.clientId = clientId;
		this.bienImmobilierId = bienImmobilierId;
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

	public ConseillerImmobilier getConseillerId() {
		return conseillerId;
	}

	public void setConseillerId(ConseillerImmobilier conseillerId) {
		this.conseillerId = conseillerId;
	}

	public Client getClientId() {
		return clientId;
	}

	public void setClientId(Client clientId) {
		this.clientId = clientId;
	}

	public BienImmobilier getBienImmobilierId() {
		return bienImmobilierId;
	}

	public void setBienImmobilierId(BienImmobilier bienImmobilierId) {
		this.bienImmobilierId = bienImmobilierId;
	}

	public boolean isValidationContrat() {
		return validationContrat;
	}

	public void setValidationContrat(boolean validationContrat) {
		this.validationContrat = validationContrat;
	}
	
	
	
	

	

}
