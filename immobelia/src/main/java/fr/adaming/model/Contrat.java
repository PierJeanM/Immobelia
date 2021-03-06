package fr.adaming.model;

import java.text.SimpleDateFormat;
import java.util.Date;

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
	private ConseillerImmobilier conseiller;

	@OneToOne
	@JoinColumn(name="client_id", referencedColumnName="id")
	private Client client;

	@OneToOne
	@JoinColumn(name="bien_id", referencedColumnName="id_bien")
	private BienImmobilier bienImmobilier;

	@Column(name = "date")
	private Date date;
	
	/**
	 * ctor vide
	 */
	public Contrat() {
		// TODO Auto-generated constructor stub
	}

	
	public Contrat(int idContrat, ConseillerImmobilier conseiller,
			Client client, BienImmobilier bienImmobilier,
			Date date) {
		super();
		this.idContrat = idContrat;
		this.conseiller = conseiller;
		this.client = client;
		this.bienImmobilier = bienImmobilier;
		this.date = date;
	}



	public Contrat(ConseillerImmobilier conseiller, Client client,
			BienImmobilier bienImmobilier, Date date) {
		super();
		this.conseiller = conseiller;
		this.client = client;
		this.bienImmobilier = bienImmobilier;
		this.date = date;
	}
	
	public String getDateToString(){
		SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
		return df.format(date);
	}

	public int getIdContrat() {
		return idContrat;
	}

	public void setIdContrat(int idContrat) {
		this.idContrat = idContrat;
	}

	public ConseillerImmobilier getConseiller() {
		return conseiller;
	}

	public void setConseiller(ConseillerImmobilier conseiller) {
		this.conseiller = conseiller;
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

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}
}
