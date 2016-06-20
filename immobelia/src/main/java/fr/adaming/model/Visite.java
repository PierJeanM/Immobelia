package fr.adaming.model;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import fr.adaming.model.bienImmobilier.BienImmobilier;
import fr.adaming.model.personne.Client;
import fr.adaming.model.personne.ConseillerImmobilier;

@Entity(name = "visite")
@Table(name = "visites")
public class Visite {

	/****************************************************************************/
	/****************************** DECLARATIONS ********************************/
	/****************************************************************************/

	/****************************************************************************/
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_visite")
	private int idVisite;

	@Column(name = "date")
	private Date dateVisite;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "client_id", referencedColumnName="id")
	private Client client;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "bien_id", referencedColumnName = "id_bien")
	private BienImmobilier bienImmobilier;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "conseiller_id", referencedColumnName = "id")
	private ConseillerImmobilier conseiller;


	/****************************************************************************/
	/****************************** CONSTRUCTEURS *******************************/
	/****************************************************************************/

	/**
	 * Constructeur vide
	 */
	public Visite() {
		super();
	}


	public Visite(int idVisite, Date dateVisite, Client client,
			BienImmobilier bienImmobilier, ConseillerImmobilier conseiller) {
		super();
		this.idVisite = idVisite;
		this.dateVisite = dateVisite;
		this.client = client;
		this.bienImmobilier = bienImmobilier;
		this.conseiller = conseiller;
	}


	public Visite(Date dateVisite, Client client,
			BienImmobilier bienImmobilier, ConseillerImmobilier conseiller) {
		super();
		this.dateVisite = dateVisite;
		this.client = client;
		this.bienImmobilier = bienImmobilier;
		this.conseiller = conseiller;
	}


	public int getIdVisite() {
		return idVisite;
	}


	public void setIdVisite(int id_visite) {
		this.idVisite = id_visite;
	}


	public Date getDateVisite() {
		return dateVisite;
	}


	public void setDateVisite(Date dateVisite) {
		this.dateVisite = dateVisite;
	}


	public Client getClient() {
		return client;
	}


	public void setClient(Client client) {
		this.client = client;
	}


	public BienImmobilier getBienImmobilier() {
		return bienImmobilier;
	}


	public void setBienImmobilier(BienImmobilier bienImmobilier) {
		this.bienImmobilier = bienImmobilier;
	}


	public ConseillerImmobilier getConseiller() {
		return conseiller;
	}


	public void setConseiller(ConseillerImmobilier conseiller) {
		this.conseiller = conseiller;
	}

} // Fin classe Visite
