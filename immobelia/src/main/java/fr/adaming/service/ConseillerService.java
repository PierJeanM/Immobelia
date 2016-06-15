package fr.adaming.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.adaming.DAO.ConseillerDAO;
import fr.adaming.model.personne.ConseillerImmobilier;



@Service
public class ConseillerService {

	@Autowired
	private ConseillerDAO conseillerDAO;

	public ConseillerService() {
		super();
	}
	
	public List<ConseillerImmobilier> getAll() {
		return conseillerDAO.getAll();
	}
	
}
