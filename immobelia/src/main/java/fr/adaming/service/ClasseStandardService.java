package fr.adaming.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.adaming.DAO.ClasseStandardDAO;
import fr.adaming.model.ClasseStandard;
import fr.adaming.model.bienImmobilier.BienImmobilier;
import fr.adaming.model.personne.Client;

@Service
public class ClasseStandardService {

	@Autowired
	private ClasseStandardDAO classeStandardDAO;
	
	public ClasseStandard getById(int id){
		return classeStandardDAO.getById(id);
	}
	
	public List<ClasseStandard> getAll(){
		return classeStandardDAO.getAll();
	}
	
	public void add(ClasseStandard classeStandard){
		classeStandardDAO.add(classeStandard);
	}
	
	public void remove(ClasseStandard classeStandard){
		classeStandardDAO.remove(classeStandard);
	}
	
	public void update(ClasseStandard classeStandard) {
		classeStandardDAO.update(classeStandard);
	}
	
	public List<Client> getClientsInteresses(int id){
		return classeStandardDAO.getClientsInteresses(id);
	}
	
	public List<BienImmobilier> getBiensOfClasseStandard(int id){
		return classeStandardDAO.getBiensOfClasseStandard(id);
	}
	
	public List<ClasseStandard> getClasseStandByIdClient(int idClient){
		return classeStandardDAO.getClasseStandByIdClient(idClient);
	}
}
