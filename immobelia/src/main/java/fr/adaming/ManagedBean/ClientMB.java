package fr.adaming.ManagedBean;

import java.util.ArrayList;
import java.util.List;

import javax.el.ELContext;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.component.UIParameter;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

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
	private int IdClientDetails;
	
	/**
	 * @return the idClientDetails
	 */
	public int getIdClientDetails() {
		return IdClientDetails;
	}

	/**
	 * @param idClientDetails the idClientDetails to set
	 */
	public void setIdClientDetails(int idClientDetails) {
		IdClientDetails = idClientDetails;
	}

	private String[] selectedClassesStandard;   
	
	

	private ConseillerImmobilier conseillerImmobilier;

	public ClientMB() {
		client = new Client();
		client.setAdresse(new Adresse());
		// TODO Auto-generated constructor stub
	}
	
	public List<Client> getClientByIdConseiller() {

		ELContext context = FacesContext.getCurrentInstance().getELContext();
		ConseillerMB conseillerMB = (ConseillerMB) context.getELResolver().getValue(context, null, "conseillerMB");

		return clientService.getClientByIdConseiller(conseillerMB.getConseillerImmobilier().getId_personne());
	}
	
	public void addClient(ActionEvent event){
		ELContext context = FacesContext.getCurrentInstance().getELContext();
		ConseillerMB conseillerMB = (ConseillerMB) context.getELResolver().getValue(context, null, "conseillerMB");
		
		client.setConseillerImmobilier(conseillerMB.getConseillerImmobilier());
		clientService.addClient(client);
		client = new Client();
	}

	public void detailsSetClient(ActionEvent event){
		IdClientDetails = (Integer) ((UIParameter) event.getComponent().findComponent("idCLient")).getValue();
		client = clientService.getById(IdClientDetails);
	}

	public List<Client> detailsGetClient(){
		ELContext context = FacesContext.getCurrentInstance().getELContext();
		ClientMB clientMB = (ClientMB) context.getELResolver().getValue(context, null, "clientMB");

		List<Client> listeClientDetails = new ArrayList<Client>();
		
		listeClientDetails.add(clientMB.getClient());
		
		return listeClientDetails;
//		List<String> listeDetails = new ArrayList<String>();
//		
//		String nom = client.getNom();
//		String prenom = client.getPrenom();
//		String telephone = client.getTelephone();
//		
//		listeDetails.add(nom);
//		listeDetails.add(prenom);
//		listeDetails.add(telephone);
//		
//		return listeDetails;
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
