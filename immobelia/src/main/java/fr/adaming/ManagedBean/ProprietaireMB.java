package fr.adaming.ManagedBean;

import java.util.ArrayList;
import java.util.List;

import javax.el.ELContext;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.component.UIParameter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import fr.adaming.ManagedBean.ConseillerMB;
import fr.adaming.model.personne.Adresse;
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
		proprietaire.setAdresse(new Adresse());
		listeProprietaire = new ArrayList<Proprietaire>();
	}

	
	public List<Proprietaire> getByConseiller() {
		ELContext context = FacesContext.getCurrentInstance().getELContext();
		ConseillerMB conseillerMB = (ConseillerMB) context.getELResolver().getValue(context, null, "conseillerMB");
		
		int id = conseillerMB.getConseillerImmobilier().getId_personne();
		listeProprietaire = proprietaireService.getByConseiller(id);
		return listeProprietaire;	
	}
	
	
	public void addProprietaire(){
		ELContext context = FacesContext.getCurrentInstance().getELContext();
		ConseillerMB conseillerMB = (ConseillerMB) context.getELResolver().getValue(context, null, "conseillerMB");
		
		proprietaire.setConseillerImmobilier(conseillerMB.getConseillerImmobilier());
		proprietaireService.addProprietaire(proprietaire);
		proprietaire = new Proprietaire();
	}
	
	
	public void removeProprietaire(ActionEvent event){
		Integer id = (Integer) ((UIParameter) event.getComponent().findComponent("deleteID")).getValue();
		proprietaireService.removeProprietaire(id);
	}
	
	public void init(ActionEvent event){
		proprietaire = new Proprietaire();
		proprietaire.setAdresse(new Adresse());
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
