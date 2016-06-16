package fr.adaming.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.adaming.DAO.ContratDAO;
import fr.adaming.model.Contrat;

@Service
public class ContratService {
	
	@Autowired
	private ContratDAO contratDAO;

	public Contrat getById(int id) {
		return contratDAO.getById(id);
	}

	public List<Contrat> getAll() {
		return contratDAO.getAll();
	}

	public void addContrat(Contrat contrat){
		contratDAO.addContrat(contrat);
	}
	
	public void removeContrat(Contrat contrat){
		contratDAO.removeContrat(contrat);
	}
	
	public void updateContrat(Contrat contrat){
		contratDAO.updateContrat(contrat);
	}
}
