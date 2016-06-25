package fr.adaming.DAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import fr.adaming.model.bienImmobilier.BienImmobilier;

@Repository
@Transactional
public class BienImmoDAO {
	
	@PersistenceContext(name = "PU_Immo")
	private EntityManager entityManager;

	public BienImmobilier getById(int id){
		return entityManager.find(BienImmobilier.class, id);
	}
	
	@SuppressWarnings("unchecked")
	public List<BienImmobilier> getAll(){
		return entityManager.createQuery("FROM bienImmobilier").getResultList();
	}
	
	@SuppressWarnings("unchecked")
	public List<BienImmobilier> getByProprio(int id){
		return entityManager.createQuery("FROM bienImmobilier b WHERE b.proprietaire.id= :bID").setParameter("bID", id).getResultList();
	}
		
	public void add(BienImmobilier bien){
		entityManager.persist(bien);
	}
	
	public void remove(BienImmobilier bien){
		entityManager.remove(entityManager.find(BienImmobilier.class, bien.getIdBien()));
	}
	
	public void update(BienImmobilier bien) {
		entityManager.merge(bien);
	}
}