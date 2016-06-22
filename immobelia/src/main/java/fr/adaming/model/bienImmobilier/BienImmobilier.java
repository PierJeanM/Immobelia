package fr.adaming.model.bienImmobilier;

import java.util.Date;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.persistence.CascadeType;
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
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.primefaces.event.SlideEndEvent;

import fr.adaming.model.ClasseStandard;
import fr.adaming.model.personne.Adresse;
import fr.adaming.model.personne.Proprietaire;

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
	private Date dateSoumission;
	@Column(name = "date_mise_disposition")
	private Date dateMiseDisposition;
	@Column(name = "revenu_cadastral")
	private Double revenuCadastral;
	
	@Column(name = "tel_client")
	private String telClient; // Client acquereur ou locataire, a instancier
								// avec creation contrat
	@Column(name = "tel_conseiller")
	private String telConseiller;
	@Column(name = "prix")
	private Double prix;
	@Column(name = "type_bail")
	private String typeBail;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "type_offre", referencedColumnName = "id_offre")
	private Offre typeOffre;
	
	@Column(name = "superficie")
	private Double superficie;

	@ManyToOne
	@JoinColumn(name = "classe_standard_id", referencedColumnName = "id_classe_standard")
	private ClasseStandard classeStandard;
	
	@ManyToOne
	@JoinColumn(name = "proprietaire_id", referencedColumnName = "id")
	private Proprietaire proprio;
	
	@ManyToOne
	@JoinColumn(name = "adresse_id", referencedColumnName = "id_adresse")
	private Adresse adresse;


	public BienImmobilier() {
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
			Date dateSoumission,
			Date dateMiseDisposition, Double revenuCadastral,
			String telClient, String telConseiller, Double prix, String typeBail,
			Offre typeOffre, Double superficie) {
		super();
		this.statut = statut;
		this.classeStandard = classeStandard;
		this.dateSoumission = dateSoumission;
		this.dateMiseDisposition = dateMiseDisposition;
		this.revenuCadastral = revenuCadastral;
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
			ClasseStandard classeStandard, Date dateSoumission,
			Date dateMiseDisposition, Double revenuCadastral,
			String telClient, String telConseiller, Double prix, String typeBail,
			Offre typeOffre, Double superficie) {
		super();
		this.idBien = idBien;
		this.statut = statut;
		this.classeStandard = classeStandard;
		this.dateSoumission = dateSoumission;
		this.dateMiseDisposition = dateMiseDisposition;
		this.revenuCadastral = revenuCadastral;
		this.telClient = telClient;
		this.telConseiller = telConseiller;
		this.prix = prix;
		this.typeBail = typeBail;
		this.typeOffre = typeOffre;
		this.superficie = superficie;
	}

	public void messageDisponibilité() {
        String summary = statut ? "Disponible" : "Non disponible";
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(summary));
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

	public Date getDateSoumission() {
		return dateSoumission;
	}

	public void setDateSoumission(Date dateSoumission) {
		this.dateSoumission = dateSoumission;
	}

	public Date getDateMiseDisposition() {
		System.out.println("=========================Date Mise Disposition===================="+dateMiseDisposition);
		return dateMiseDisposition;
	}

	public void setDateMiseDisposition(Date dateMiseDisposition) {
		this.dateMiseDisposition = dateMiseDisposition;
	}

	public Double getRevenuCadastral() {
		return revenuCadastral;
	}

	public void setRevenuCadastral(Double revenuCadastral) {
		this.revenuCadastral = revenuCadastral;
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

	public String getTypeBail() {
		return typeBail;
	}

	public void setTypeBail(String typeBail) {
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

	public Proprietaire getProprio() {
		return proprio;
	}

	public void setProprio(Proprietaire proprio) {
		this.proprio = proprio;
	}

	public Adresse getAdresse() {
		return adresse;
	}

	public void setAdresse(Adresse adresse) {
		this.adresse = adresse;
	}

	@Override
	public String toString() {
		return classeStandard.getTypeBien() + " " +adresse.toString();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idBien == null) ? 0 : idBien.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		BienImmobilier other = (BienImmobilier) obj;
		if (idBien == null) {
			if (other.idBien != null)
				return false;
		} else if (!idBien.equals(other.idBien))
			return false;
		return true;
	}
}
