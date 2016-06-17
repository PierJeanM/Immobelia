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
		
		return bienImmoDAO.getByProprio();
	}
	
	
	public BienImmoDAO getBienImmoDAO() {
		return bienImmoDAO;
	}

	public void setBienImmoDAO(BienImmoDAO bienImmoDAO) {
		this.bienImmoDAO = bienImmoDAO;
	}
	
	
	
}
