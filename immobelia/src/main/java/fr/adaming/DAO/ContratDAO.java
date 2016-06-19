package fr.adaming.DAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import fr.adaming.model.Contrat;


@SuppressWarnings("unchecked")
@Repository
@Transactional
public class ContratDAO {

	@PersistenceContext(unitName = "PU_Immo")
	private EntityManager entityManager;

	public Contrat getById(int id) {
		Contrat c = entityManager.find(Contrat.class,id);
		return c;
	}

	public List<Contrat> getAll() {
		String hqlGetAll = "FROM contrat";
		return entityManager.createQuery(hqlGetAll).getResultList();
	}

	public void addContrat(Contrat contrat){
		entityManager.persist(contrat);
	}
	
	public void removeContrat(Contrat contrat){
		entityManager.remove(entityManager.find(Contrat.class, contrat.getIdContrat()));
	}
	
	public void updateContrat(Contrat contrat){
		entityManager.merge(contrat);
	}

	public List<Contrat> getContratsOfConseiller(Integer id_cons) {
		String req = "FROM contrat c WHERE c.conseiller.id = :consID";
		return entityManager.createQuery(req).setParameter("consID", id_cons).getResultList();
	}
}
