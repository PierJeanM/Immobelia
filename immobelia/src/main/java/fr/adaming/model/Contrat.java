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
	private ConseillerImmobilier conseillerId;

	@OneToOne
	@JoinColumn(name="client_id", referencedColumnName="id_client")
	private Client clientId;

	@OneToOne
	@JoinColumn(name="conseiller_id", referencedColumnName="id_conseiller")
	private BienImmobilier bienImmobilierId;

	@Column(name = "validationContrat")
	private boolean validationContrat;

	

}
