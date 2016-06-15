package fr.adaming.DAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import fr.adaming.model.personne.ConseillerImmobilier;


@SuppressWarnings("unchecked")
@Repository
@Transactional
public class ConseillerDAO {

	@PersistenceContext(unitName = "PU_Immo")
	private EntityManager entityManager;

	public ConseillerImmobilier getById(int id) {
		ConseillerImmobilier c = entityManager.find(ConseillerImmobilier.class,id);
		return c;
	}

	public List<ConseillerImmobilier> getAll() {
		String hqlGetAll = "FROM conseillerImmobilier";
		return entityManager.createQuery(hqlGetAll).getResultList();
	}

	public void addConseiller(ConseillerImmobilier conseillerImmobilier){
		entityManager.persist(conseillerImmobilier);
	}
	
	public void removeConseiller(ConseillerImmobilier conseillerImmobilier){
		entityManager.remove(conseillerImmobilier);
	}
	
	public void update(ConseillerImmobilier conseillerImmobilier){
		entityManager.merge(conseillerImmobilier);
	}
} 