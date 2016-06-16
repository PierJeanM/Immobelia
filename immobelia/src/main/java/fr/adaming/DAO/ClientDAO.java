package fr.adaming.DAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import fr.adaming.model.personne.Client;

@Repository
@Transactional
public class ClientDAO {

	@PersistenceContext(name = "PU_Immo")
	private EntityManager entityManager;

	public Client getById(int id){
		return entityManager.find(Client.class, id);
	}
	
	@SuppressWarnings("unchecked")
	public List<Client> getAll(){
		return entityManager.createQuery("FROM client").getResultList();
	}
	
	public void add(Client client){
		entityManager.persist(client);
	}
	
	public void remove(Client client){
		entityManager.refresh(client);
	}
	
	public void update(Client client) {
		entityManager.merge(client);
	}
}