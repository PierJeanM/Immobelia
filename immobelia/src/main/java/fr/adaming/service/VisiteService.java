package fr.adaming.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.adaming.DAO.VisiteDAO;
import fr.adaming.model.Visite;

@Service
public class VisiteService {

	@Autowired
	private VisiteDAO visiteDAO;
	
	public Visite getById(int id){
		return visiteDAO.getById(id);
	}
	
	public List<Visite> getAll(){
		return visiteDAO.getAll();
	}
	
	public void add(Visite visite){
		visiteDAO.add(visite);
	}
	
	public void remove(Visite visite){
		visiteDAO.remove(visite);
	}
	
	public void update(Visite visite) {
		visiteDAO.update(visite);
	}
}
