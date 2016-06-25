package fr.adaming.DAO;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import fr.adaming.model.Contrat;
import fr.adaming.model.Visite;
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
		Proprietaire p = entityManager.find(Proprietaire.class, id);
		// Recuperation des biens associes au proprio, et des contrats et visites associes aux biens
		List<Integer> idBiens = new ArrayList<Integer>();
		List<Visite> visites = new ArrayList<Visite>();
		List<Contrat> contrats = new ArrayList<Contrat>();
		
		for (BienImmobilier b : p.getBiensImmos()) {
			b.setProprio(null);
			idBiens.add(b.getIdBien());
			visites.addAll(entityManager.createQuery("FROM visite v WHERE v.bienImmobilier.idBien = :bID").setParameter("bID", b.getIdBien()).getResultList());
			contrats.addAll(entityManager.createQuery("FROM contrat c WHERE c.bienImmobilier.idBien = :bID").setParameter("bID", b.getIdBien()).getResultList());
		}
		p.setBiensImmos(new ArrayList<BienImmobilier>());
		
		for (Contrat c : contrats)
			entityManager.remove(entityManager.find(Contrat.class, c.getIdContrat()));
		
		for (Visite v : visites) 
			entityManager.remove(entityManager.find(Visite.class, v.getIdVisite()));
		
		for (Integer i : idBiens) 
			entityManager.remove(entityManager.find(BienImmobilier.class, i));
		
		entityManager.remove(p);
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
