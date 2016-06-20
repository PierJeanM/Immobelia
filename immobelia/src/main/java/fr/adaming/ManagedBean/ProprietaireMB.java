package fr.adaming.ManagedBean;

import java.util.ArrayList;
import java.util.List;

import javax.el.ELContext;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import fr.adaming.ManagedBean.ConseillerMB;
import fr.adaming.model.personne.Proprietaire;
import fr.adaming.service.ProprietaireService;

@ManagedBean
@SessionScoped
@Component
public class ProprietaireMB {

	@Autowired
	private ProprietaireService proprietaireService;
	
	private Proprietaire proprietaire;
	private List<Proprietaire> listeProprietaire;

	public ProprietaireMB() {
		proprietaire = new Proprietaire();
		listeProprietaire=new ArrayList<Proprietaire>();
	}

	
	public List<Proprietaire> getByConseiller() {

		System.out.println("===========================GETBYCONSEILLER===================="
						+ proprietaireService);
		
		ELContext context = FacesContext.getCurrentInstance().getELContext();
		ConseillerMB conseillerMB = (ConseillerMB) context.getELResolver().getValue(context, null, "conseillerMB");
		
		int id = conseillerMB.getConseillerImmobilier().getId_personne();
		
		

		return proprietaireService.getByConseiller(id);
		
	}
	
//	public int nombreBiensByProprio() {
//		System.out
//				.println("======================Nombre Bien par proprio======================"
//						+ bienImmobilierService);
//		ELContext context = FacesContext.getCurrentInstance().getELContext();
//		System.out
//				.println("===============context====================================="
//						+ context);
//		ProprietaireMB proprietaireMB = (ProprietaireMB) context
//				.getELResolver().getValue(context, null, "proprietaireMB");
//		System.out
//				.println("===============proprioMB====================================="
//						+ proprietaireMB);
//		int id = proprietaireMB.getProprietaire().getId_personne();
//		System.out
//				.println("========================ID====================================="
//						+ id);
//		List<BienImmobilier> listeBiensByProprio = new ArrayList<BienImmobilier>();
//		listeBiensByProprio = bienImmobilierService.getByProprio(id);
//		System.out
//				.println("========================Nombre de biens======================="
//						+ listeBiensByProprio.size());
//		return listeBiensByProprio.size();
//
//	}
	
	public void addProprietaire(Proprietaire proprietaire){
		proprietaireService.addProprietaire(proprietaire);
	}
	
	/****************************
	 * GET & SET
	 * 
	 ***************************/
	public ProprietaireService getProprietaireService() {
		return proprietaireService;
	}

	public void setProprietaireService(ProprietaireService proprietaireService) {
		this.proprietaireService = proprietaireService;
	}

	public Proprietaire getProprietaire() {
		System.out.println("==============================VALEUR PROPRIETAIRE========================="+proprietaire);
		System.out.println("==============================VALEUR PROPRIETAIRE========================="+proprietaire.getNom());
		System.out.println("==============================VALEUR PROPRIETAIRE========================="+proprietaire.getPrenom());
		
		return proprietaire;
	}

	public void setProprietaire(Proprietaire proprietaire) {
		this.proprietaire = proprietaire;
	}

	public List<Proprietaire> getListeProprietaire() {
		return listeProprietaire;
	}

	public void setListeProprietaire(List<Proprietaire> listeProprietaire) {
		this.listeProprietaire = listeProprietaire;
	}

}
