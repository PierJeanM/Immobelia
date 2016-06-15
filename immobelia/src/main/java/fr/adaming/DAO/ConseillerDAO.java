package fr.adaming.DAO;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.springframework.transaction.annotation.Transactional;
import fr.adaming.model.personne.ConseillerImmobilier;

public class ConseillerDAO {

	private EntityManager entityManager;

	public ConseillerDAO() {
		
		ConseillerImmobilier conseillerImmobilier=new ConseillerImmobilier();
	}
	
	
	@Transactional(readOnly=true)
	@SuppressWarnings("unchecked")
	public List<ConseillerImmobilier> getAll() {
		Session session = entityManager.
		
		return session.createQuery("FROM conseiller").list();
	}
	
	
} // Fin classe ConseillerDAO
