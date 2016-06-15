package fr.adaming.DAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import fr.adaming.model.ClasseStandard;;

@Repository
@Transactional
public class ClasseStandardDAO {
	
	@PersistenceContext(name = "PU_Immo")
	private EntityManager entityManager;

	public ClasseStandard getById(int id){
		return entityManager.find(ClasseStandard.class, id);
	}
	
	@SuppressWarnings("unchecked")
	public List<ClasseStandard> getAll(){
		return entityManager.createQuery("FROM classe_standard").getResultList();
	}
	
	public void add(ClasseStandard classeStandard){
		entityManager.persist(classeStandard);
	}
	
	public void remove(ClasseStandard classeStandard){
		entityManager.refresh(classeStandard);
	}
	
	public void update(ClasseStandard classeStandard) {
		entityManager.merge(classeStandard);
	}
}
