package fr.adaming.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

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
	private int id_visite;

	@Column(name = "date")
	private Date dateVisite;

	@Column(name = "client_id")
	private int client_id;

	@Column(name = "bienImmobilier_id")
	private int bienImmobilier_id;

	@Column(name = "conseiller_id")
	private int conseiller_id;

	/*************************** Declaration_associations *************************/
	@ManyToOne
	@JoinColumn(name = "conseiller_id", referencedColumnName = "id_conseiller")
	private ConseillerImmobilier conseillerImmobilier;

	/****************************************************************************/
	/****************************** CONSTRUCTEURS *******************************/
	/****************************************************************************/

	/**
	 * Constructeur vide
	 */
	public Visite() {
		super();
	}

	/**
	 * Constructeur sans id
	 * 
	 * @param dateVisite
	 * @param client_id
	 * @param bienImmobilier_id
	 * @param conseiller_id
	 */
	public Visite(Date dateVisite, int client_id, int bienImmobilier_id,
			int conseiller_id) {
		super();
		this.dateVisite = dateVisite;
		this.client_id = client_id;
		this.bienImmobilier_id = bienImmobilier_id;
		this.conseiller_id = conseiller_id;
	}

	/**
	 * Constructeur chargé
	 * 
	 * @param dateVisite
	 * @param id_visite
	 * @param client_id
	 * @param bienImmobilier_id
	 * @param conseiller_id
	 */
	public Visite(Date dateVisite, int id_visite, int client_id,
			int bienImmobilier_id, int conseiller_id) {
		super();
		this.dateVisite = dateVisite;
		this.id_visite = id_visite;
		this.client_id = client_id;
		this.bienImmobilier_id = bienImmobilier_id;
		this.conseiller_id = conseiller_id;
	}

	/****************************************************************************/
	/********************************* METHODES *********************************/
	/****************************************************************************/

	@Override
	public String toString() {
		return "Visite [dateVisite=" + dateVisite + ", id_visite=" + id_visite
				+ ", client_id=" + client_id + ", bienImmobilier_id="
				+ bienImmobilier_id + ", conseiller_id=" + conseiller_id + "]";
	}

	/****************************************************************************/
	/****************************** GETTERS_SETTERS *****************************/
	/****************************************************************************/

	/****************************************************************************/

	public Date getDateVisite() {
		return dateVisite;
	}

	public void setDateVisite(Date dateVisite) {
		this.dateVisite = dateVisite;
	}

	public int getId_visite() {
		return id_visite;
	}

	public void setId_visite(int id_visite) {
		this.id_visite = id_visite;
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

	public int getConseiller_id() {
		return conseiller_id;
	}

	public void setConseiller_id(int conseiller_id) {
		this.conseiller_id = conseiller_id;
	}

	/******************** Getters_Setters pour associations *******************/

	public ConseillerImmobilier getConseillerImmobilier() {
		return conseillerImmobilier;
	}

	public void setConseillerImmobilier(
			ConseillerImmobilier conseillerImmobilier) {
		this.conseillerImmobilier = conseillerImmobilier;
	}

} // Fin classe Visite
