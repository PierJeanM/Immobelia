package fr.adaming.ManagedBean;

import java.util.List;

import javax.el.ELContext;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import fr.adaming.model.personne.Adresse;
import fr.adaming.model.personne.Client;
import fr.adaming.model.personne.ConseillerImmobilier;
import fr.adaming.service.ClientService;

@ManagedBean
@SessionScoped  
@Component
public class ClientMB {

	@Autowired
	private ClientService clientService;
	
	private Client client;
	private Adresse adresseClient;
	
	
	/**
	 * @return the adresseClient
	 */
	public Adresse getAdresseClient() {
		return adresseClient;
	}

	/**
	 * @param adresseClient the adresseClient to set
	 */
	public void setAdresseClient(Adresse adresseClient) {
		this.adresseClient = adresseClient;
	}

	private String[] selectedClassesStandard;   
	
	

	private ConseillerImmobilier conseillerImmobilier;

	public ClientMB() {
		client = new Client();
		adresseClient = new Adresse();
		// TODO Auto-generated constructor stub
	}
	
	public List<Client> getClientByIdConseiller() {

		// Recupere le managedbean conseiller pour que le nouveau client y soit
		// associe
		ELContext context = FacesContext.getCurrentInstance().getELContext();
		ConseillerMB conseillerMB = (ConseillerMB) context.getELResolver().getValue(context, null, "conseillerMB");
		
		//Recup id du conseiller connecté
		//int idCons = 1;
		int idCons = conseillerMB.getConseillerImmobilier().getId_personne();
		
		//requete
		return clientService.getClientByIdConseiller(idCons);
	}
	
	public void addClient(){
		System.out.println("=======> ADD CLIENT MB" + this.client);
		this.client.setAdresse(adresseClient);
		clientService.addClient(this.client);
	}
	
	/**
	 * @return the selectedClassesStandard
	 */
	public String[] getSelectedClassesStandard() {
		return selectedClassesStandard;
	}

	/**
	 * @param selectedClassesStandard the selectedClassesStandard to set
	 */
	public void setSelectedClassesStandard(String[] selectedClassesStandard) {
		this.selectedClassesStandard = selectedClassesStandard;
	}

	/**
	 * @return the clientService
	 */
	public ClientService getClientService() {
		return clientService;
	}

	/**
	 * @param clientService the clientService to set
	 */
	public void setClientService(ClientService clientService) {
		this.clientService = clientService;
	}

	/**
	 * @return the client
	 */
	public Client getClient() {
		System.out.println("======> CLIENT MB *** GET");

		return client;
	}

	/**
	 * @param client the client to set
	 */
	public void setClient(Client client) {
		System.out.println("======> CLIENT MB *** SET" + client);
		this.client = client;
	}

	/**
	 * @return the conseillerImmobilier
	 */
	public ConseillerImmobilier getConseillerImmobilier() {
		return conseillerImmobilier;
	}

	/**
	 * @param conseillerImmobilier the conseillerImmobilier to set
	 */
	public void setConseillerImmobilier(ConseillerImmobilier conseillerImmobilier) {
		this.conseillerImmobilier = conseillerImmobilier;
	}

}
