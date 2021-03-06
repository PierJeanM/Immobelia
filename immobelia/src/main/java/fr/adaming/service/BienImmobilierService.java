package fr.adaming.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.adaming.DAO.BienImmoDAO;
import fr.adaming.model.bienImmobilier.BienImmobilier;

@Service
public class BienImmobilierService {

	@Autowired
	private BienImmoDAO bienImmoDAO;

	public BienImmobilierService() {
		super();
	}

	public List<BienImmobilier> getByProprio(int id){
		
		return bienImmoDAO.getByProprio(id);
	}
	
	public void addBien(BienImmobilier bienImmobilier){
		
		bienImmoDAO.add(bienImmobilier);
	}
	
	public BienImmoDAO getBienImmoDAO() {
		return bienImmoDAO;
	}

	public void setBienImmoDAO(BienImmoDAO bienImmoDAO) {
		this.bienImmoDAO = bienImmoDAO;
	}
	
	public List<BienImmobilier> getAll(){
		return bienImmoDAO.getAll();
	}
	
	public BienImmobilier getById(int id){
		return bienImmoDAO.getById(id);
	}
	
}
