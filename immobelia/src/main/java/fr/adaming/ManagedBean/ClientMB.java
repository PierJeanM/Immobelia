package fr.adaming.ManagedBean;

import java.util.List;

import javax.el.ELContext;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

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
	private ConseillerImmobilier conseillerImmobilier;

	public ClientMB() {
	
		client = new Client();
		// TODO Auto-generated constructor stub
	}
	
	public List<Client> getClientByIdConseiller() {

		// Recupere le managedbean conseiller pour que le nouveau client y soit
		// associe
		//ELContext context = FacesContext.getCurrentInstance().getELContext();
		//ConseillerMB conseillerMB = (ConseillerMB) context.getELResolver().getValue(context, null, "conseillerMB");
		
		//Recup id du conseiller connecté
		int idCons = 1;
		//int idCons = conseillerMB.getConseillerImmobilier().getId_personne();
		
		//requete
		return clientService.getClientByIdConseiller(idCons);
	}
	
	public void addClient(Client clt){
		clt =client;
		clientService.addClient(clt);
	}

}
