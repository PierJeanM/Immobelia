package fr.adaming.model.bienImmobilier;

import java.util.GregorianCalendar;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import fr.adaming.model.ClasseStandard;
import fr.adaming.model.personne.Client;

/**
 * 
 * Classe de reference des bien immobiliers
 * 
 * @author INTI-0247
 *
 */
@Entity(name = "bienImmobilier")
@Table(name = "bienImmobiliers")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "type_bien")
public abstract class BienImmobilier {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_bien")
	private Integer idBien;
	@Column(name = "statut")
	private boolean statut;
	@Column(name = "date_soumission")
	private GregorianCalendar dateSoumission;
	@Column(name = "date_mise_disposition")
	private GregorianCalendar dateMiseDisposition;
	@Column(name = "revenu_cadastral")
	private Double revenuCadastral;
	@Column(name = "liste_visiteurs")
	private List<Client> listeVisiteurs;
	@Column(name = "date_visite")
	private GregorianCalendar dateVisite;
	@Column(name = "tel_client")
	private String telClient; // Client acquereur ou locataire, a instancier
								// avec creation contrat
	@Column(name = "tel_conseiller")
	private String telConseiller;
	@Column(name = "prix")
	private Double prix;
	@Column(name = "type_bail")
	private Bail typeBail;
	@Column(name = "type_offre")
	private Offre typeOffre;
	@Column(name = "superficie")
	private Double superficie;

	@ManyToOne
	@JoinColumn(name = "classe_standard_id", referencedColumnName = "")
	private ClasseStandard classeStandard;

	public BienImmobilier() {

		// TODO Auto-generated constructor stub
	}

	/**
	 * Constructeur Sans ID
	 * 
	 * @param statut
	 * @param classeStandard
	 * @param dateSoumission
	 * @param dateMiseDisposition
	 * @param revenuCadastral
	 * @param listeVisiteurs
	 * @param dateVisite
	 * @param heureVisite
	 * @param telClient
	 * @param telConseiller
	 * @param prix
	 * @param typeBail
	 * @param typeOffre
	 * @param superficie
	 */
	public BienImmobilier(boolean statut, ClasseStandard classeStandard,
			GregorianCalendar dateSoumission,
			GregorianCalendar dateMiseDisposition, Double revenuCadastral,
			List<Client> listeVisiteurs, GregorianCalendar dateVisite,
			String telClient, String telConseiller, Double prix, Bail typeBail,
			Offre typeOffre, Double superficie) {
		super();
		this.statut = statut;
		this.classeStandard = classeStandard;
		this.dateSoumission = dateSoumission;
		this.dateMiseDisposition = dateMiseDisposition;
		this.revenuCadastral = revenuCadastral;
		this.listeVisiteurs = listeVisiteurs;
		this.dateVisite = dateVisite;
		this.telClient = telClient;
		this.telConseiller = telConseiller;
		this.prix = prix;
		this.typeBail = typeBail;
		this.typeOffre = typeOffre;
		this.superficie = superficie;
	}

	/**
	 * Constructeur avec ID
	 * 
	 * @param idBien
	 * @param statut
	 * @param classeStandard
	 * @param dateSoumission
	 * @param dateMiseDisposition
	 * @param revenuCadastral
	 * @param listeVisiteurs
	 * @param dateVisite
	 * @param heureVisite
	 * @param telClient
	 * @param telConseiller
	 * @param prix
	 * @param typeBail
	 * @param typeOffre
	 * @param superficie
	 */
	public BienImmobilier(Integer idBien, boolean statut,
			ClasseStandard classeStandard, GregorianCalendar dateSoumission,
			GregorianCalendar dateMiseDisposition, Double revenuCadastral,
			List<Client> listeVisiteurs, GregorianCalendar dateVisite,
			String telClient, String telConseiller, Double prix, Bail typeBail,
			Offre typeOffre, Double superficie) {
		super();
		this.idBien = idBien;
		this.statut = statut;
		this.classeStandard = classeStandard;
		this.dateSoumission = dateSoumission;
		this.dateMiseDisposition = dateMiseDisposition;
		this.revenuCadastral = revenuCadastral;
		this.listeVisiteurs = listeVisiteurs;
		this.dateVisite = dateVisite;
		this.telClient = telClient;
		this.telConseiller = telConseiller;
		this.prix = prix;
		this.typeBail = typeBail;
		this.typeOffre = typeOffre;
		this.superficie = superficie;
	}

	/**********************************/
	/********* GETTER AND SETTER ********/
	/**********************************/

	public Integer getIdBien() {
		return idBien;
	}

	public void setIdBien(Integer idBien) {
		this.idBien = idBien;
	}

	public boolean isStatut() {
		return statut;
	}

	public void setStatut(boolean statut) {
		this.statut = statut;
	}

	public ClasseStandard getClasseStandard() {
		return classeStandard;
	}

	public void setClasseStandard(ClasseStandard classeStandard) {
		this.classeStandard = classeStandard;
	}

	public GregorianCalendar getDateSoumission() {
		return dateSoumission;
	}

	public void setDateSoumission(GregorianCalendar dateSoumission) {
		this.dateSoumission = dateSoumission;
	}

	public GregorianCalendar getDateMiseDisposition() {
		return dateMiseDisposition;
	}

	public void setDateMiseDisposition(GregorianCalendar dateMiseDisposition) {
		this.dateMiseDisposition = dateMiseDisposition;
	}

	public Double getRevenuCadastral() {
		return revenuCadastral;
	}

	public void setRevenuCadastral(Double revenuCadastral) {
		this.revenuCadastral = revenuCadastral;
	}

	public List<Client> getListeVisiteurs() {
		return listeVisiteurs;
	}

	public void setListeVisiteurs(List<Client> listeVisiteurs) {
		this.listeVisiteurs = listeVisiteurs;
	}

	public GregorianCalendar getDateVisite() {
		return dateVisite;
	}

	public void setDateVisite(GregorianCalendar dateVisite) {
		this.dateVisite = dateVisite;
	}

	public String getTelClient() {
		return telClient;
	}

	public void setTelClient(String telClient) {
		this.telClient = telClient;
	}

	public String getTelConseiller() {
		return telConseiller;
	}

	public void setTelConseiller(String telConseiller) {
		this.telConseiller = telConseiller;
	}

	public Double getPrix() {
		return prix;
	}

	public void setPrix(Double prix) {
		this.prix = prix;
	}

	public Bail getTypeBail() {
		return typeBail;
	}

	public void setTypeBail(Bail typeBail) {
		this.typeBail = typeBail;
	}

	public Offre getTypeOffre() {
		return typeOffre;
	}

	public void setTypeOffre(Offre typeOffre) {
		this.typeOffre = typeOffre;
	}

	public Double getSuperficie() {
		return superficie;
	}

	public void setSuperficie(Double superficie) {
		this.superficie = superficie;
	}

}