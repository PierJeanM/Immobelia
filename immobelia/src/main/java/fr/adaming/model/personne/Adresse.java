package fr.adaming.model.personne;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Classe Adresse
 * 
 * @author INTI-0283
 *
 */
@Entity(name = "adresse")
@Table(name = "adresses")
public class Adresse {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_adresse")
	private int idAdresse;

	@Column(name = "rue")
	private String rue;

	@Column(name = "numero")
	private int numero;

	@Column(name = "codePostal")
	private String codePostal;

	@Column(name = "ville")
	private String ville;

	/**
	 * ctor vide
	 */
	public Adresse() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * ctor chargé avec id
	 * 
	 * @param id
	 * @param rue
	 * @param numero
	 * @param codePostal
	 * @param ville
	 */
	public Adresse(int idAdresse, String rue, int numero, String codePostal,
			String ville) {
		super();
		this.idAdresse = idAdresse;
		this.rue = rue;
		this.numero = numero;
		this.codePostal = codePostal;
		this.ville = ville;
	}

	/**
	 * ctor chargé sans id
	 * 
	 * @param rue
	 * @param numero
	 * @param codePostal
	 * @param ville
	 */
	public Adresse(String rue, int numero, String codePostal, String ville) {
		super();
		this.rue = rue;
		this.numero = numero;
		this.codePostal = codePostal;
		this.ville = ville;
	}

	/**************************
	 * GETTERS & SETTERS
	 *
	 *************************/

	public int getIdAdresse() {
		return idAdresse;
	}

	public void setIdAdresse(int idAdresse) {
		this.idAdresse = idAdresse;
	}

	public String getRue() {
		return rue;
	}

	public void setRue(String rue) {
		this.rue = rue;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public String getCodePostal() {
		return codePostal;
	}

	public void setCodePostal(String codePostal) {
		this.codePostal = codePostal;
	}

	public String getVille() {
		return ville;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return numero + " rue " + rue + ", " + codePostal + ", " + ville;
	}

	public void setVille(String ville) {
		this.ville = ville;
	}

}
