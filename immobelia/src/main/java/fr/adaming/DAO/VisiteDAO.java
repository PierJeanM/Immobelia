package fr.adaming.DAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import fr.adaming.model.Visite;;

@Repository
@Transactional
public class VisiteDAO {

	@PersistenceContext(name = "PU_Immo")
	private EntityManager entityManager;

	public Visite getById(int id){
		return entityManager.find(Visite.class, id);
	}
	
	@SuppressWarnings("unchecked")
	public List<Visite> getAll(){
		return entityManager.createQuery("FROM visite").getResultList();
	}
	
	public void add(Visite visite){
		entityManager.persist(visite);
	}
	
	public void remove(Visite visite){
		entityManager.refresh(visite);
	}
	
	public void update(Visite visite) {
		entityManager.merge(visite);
	}
}
