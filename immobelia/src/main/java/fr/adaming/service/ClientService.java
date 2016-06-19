package fr.adaming.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.adaming.DAO.ClientDAO;
import fr.adaming.model.personne.Client;

@Service
public class ClientService {

	@Autowired
	private ClientDAO clientDAO;
	
	public ClientService() {
		
	}
	
	public List<Client> getClientByIdConseiller(int idCons){
		
		return clientDAO.getClientByIDConseiller(idCons);
	}
	
	public void addClient(Client client){
		clientDAO.add(client);
	}
	
	public Client getById(int id) {
		return clientDAO.getById(id);
	}
	
}
