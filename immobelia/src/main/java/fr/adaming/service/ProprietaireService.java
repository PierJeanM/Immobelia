package fr.adaming.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.adaming.DAO.ProprietaireDAO;
import fr.adaming.model.personne.Proprietaire;

@Service
public class ProprietaireService {

	@Autowired
	private ProprietaireDAO proprietaireDAO;

	public ProprietaireService() {
	}

	public List<Proprietaire> getByConseiller(int id) {
		
		System.out.println("======================GETBY====================="+proprietaireDAO);
		return proprietaireDAO.getByConseiller(id);

	}

	public void addProprietaire(Proprietaire proprietaire){
		proprietaireDAO.addProprietaire(proprietaire);
	}
	
	
	public ProprietaireDAO getProprietaireDAO() {
		return proprietaireDAO;
	}

	public void setProprietaireDAO(ProprietaireDAO proprietaireDAO) {
		this.proprietaireDAO = proprietaireDAO;
	}
	

	
}
