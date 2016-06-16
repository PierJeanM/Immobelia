package fr.adaming.ManagedBean;

import java.util.List;

import javax.el.ELContext;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import fr.adaming.ManagedBean.ConseillerMB;
import fr.adaming.model.ClasseStandard;
import fr.adaming.model.Contrat;
import fr.adaming.model.Visite;
import fr.adaming.service.ClasseStandardService;
import fr.adaming.service.ContratService;
import fr.adaming.service.VisiteService;

@ManagedBean
@SessionScoped
@Component
public class TableauBordMB {
	
	@Autowired
	private VisiteService visiteService;
	@Autowired
	private ContratService contratService;
	@Autowired
	private ClasseStandardService classeStandardService;
	
	
	/**
	 * Méthode retournant la liste des visites effectuées par le conseiller connecté,
	 * appelée dans GestionTableauBord.xhtml
	 * @return
	 */
	public List<Visite> getVisitesOfConseiller(){
		ELContext context = FacesContext.getCurrentInstance().getELContext();
		ConseillerMB conseillerMB = (ConseillerMB) context.getELResolver().getValue(context, null, "conseillerMB");
		return visiteService.getVisitesOfConseiller(conseillerMB.getConseillerImmobilier().getId_personne());
	}
	
	
	/**
	 * Méthode retournant la liste des contrats supervisés par le conseiller connecté,
	 * appelée dans GestionTableauBord.xhtml
	 * @return
	 */
	public List<Contrat> getContratsOfConseiller(){
		ELContext context = FacesContext.getCurrentInstance().getELContext();
		ConseillerMB conseillerMB = (ConseillerMB) context.getELResolver().getValue(context, null, "conseillerMB");
		return contratService.getContratsOfConseiller(conseillerMB.getConseillerImmobilier().getId_personne());
	}
	
	
	public List<ClasseStandard> getClassesStandards(){
		return classeStandardService.getAll();
	}
}
