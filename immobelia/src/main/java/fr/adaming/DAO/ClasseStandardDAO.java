package fr.adaming.DAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import fr.adaming.model.ClasseStandard;
import fr.adaming.model.bienImmobilier.BienImmobilier;
import fr.adaming.model.personne.Client;

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
		entityManager.remove(entityManager.find(ClasseStandard.class, classeStandard.getIdClasseStandard()));
	}
	
	public void update(ClasseStandard classeStandard) {
		entityManager.merge(classeStandard);
	}
	
	@SuppressWarnings("unchecked")
	public List<Client> getClientsInteresses(int id){
		String req = "SELECT cs.listClients FROM classe_standard cs WHERE cs.idClasseStandard = :csID";
		return entityManager.createQuery(req).setParameter("csID", id).getResultList();
	}
	
	@SuppressWarnings("unchecked")
	public List<BienImmobilier> getBiensOfClasseStandard(int id){
		String req = "FROM bienImmobilier b WHERE b.classeStandard.idClasseStandard = :csID";
		return entityManager.createQuery(req).setParameter("csID", id).getResultList();
	}
	
	
	
	
	@SuppressWarnings("unchecked")
	public List<ClasseStandard> getClasseStandByIdClient(int idClient){
		System.out.println("=========> CLASSESTAND DAO, idClient : " +idClient);
		String req = "SELECT classe_standard FROM client c JOIN c.bienRecherche WHERE c.id = :clientID";
		return entityManager.createQuery(req).setParameter("clientID", idClient).getResultList();
	}
	
	
	
	// select a.firstName, a.lastName from Book b join b.authors a where b.id = :id
	//SELECT cc FROM classe_standard cc LEFT JOIN FETCH cc.listClients WHERE cc.id  = :clientID
	
	
	
	
	
	
	
	
	
//	
//	select film
//	from Film as film
//	join film.realisateur as a
//	where a.nom='Eastwood'
	
	
	
	
	
	
	
	
}
