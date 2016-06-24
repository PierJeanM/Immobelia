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
		return proprietaireDAO.getByConseiller(id);
	}

	public void addProprietaire(Proprietaire proprietaire){
		proprietaireDAO.addProprietaire(proprietaire);
	}
	
	public void removeProprietaire(int id){
		proprietaireDAO.removeProprietaire(id);
	}

	public Proprietaire getById(Integer id) {
		return proprietaireDAO.getById(id);
	}
}
