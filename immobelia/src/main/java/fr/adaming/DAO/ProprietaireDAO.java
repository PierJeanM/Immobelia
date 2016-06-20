package fr.adaming.DAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import fr.adaming.model.bienImmobilier.BienImmobilier;
import fr.adaming.model.personne.Proprietaire;


@SuppressWarnings("unchecked")
@Repository
@Transactional
public class ProprietaireDAO {

	@PersistenceContext(unitName = "PU_Immo")
	private EntityManager entityManager;

	public Proprietaire getById(int id) {
		Proprietaire p = entityManager.find(Proprietaire.class,id);
		return p;
	}

	public List<Proprietaire> getByConseiller(int id){
		String requeteHqlGetByConseiller="FROM proprietaire p WHERE p.conseillerImmobilier.id = :pID";
		
		return entityManager.createQuery(requeteHqlGetByConseiller).setParameter("pID", id).getResultList();
	}
	
	public List<Proprietaire> getAll() {
		String hqlGetAll = "FROM proprietaire";
		return entityManager.createQuery(hqlGetAll).getResultList();
	}

	public void addProprietaire(Proprietaire proprietaire){
		entityManager.persist(proprietaire);
	}
	
	public void removeProprietaire(int id){
		System.out.println(entityManager.find(Proprietaire.class, id));
		List<BienImmobilier> listeBiens = entityManager.find(Proprietaire.class, id).getBiensImmos();
		for (BienImmobilier b : listeBiens) {
			b.setProprio(null);
		}
		entityManager.remove(entityManager.find(Proprietaire.class, id));
	}
	
	public void updateProprietaire(Proprietaire proprietaire){
		entityManager.merge(proprietaire);
	}

	public EntityManager getEntityManager() {
		return entityManager;
	}

	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}
	
}
