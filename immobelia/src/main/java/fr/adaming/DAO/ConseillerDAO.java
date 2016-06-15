package fr.adaming.DAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.hibernate.Session;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import fr.adaming.model.personne.ConseillerImmobilier;

@Repository
public class ConseillerDAO {

	@PersistenceContext(unitName="PU_Immo")
	private EntityManager entityManager;

	
	public ConseillerDAO() {
		
		ConseillerImmobilier conseillerImmobilier=new ConseillerImmobilier();
	}
	
	
	@Transactional(readOnly=true)
	@SuppressWarnings("unchecked")
	public ConseillerImmobilier getById(int id) {
		ConseillerImmobilier c = entityManager.find(ConseillerImmobilier.class, 1);
		
		return c;
	}
	
	
} // Fin classe ConseillerDAO
