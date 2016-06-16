package fr.adaming.ManagedBean;

import java.util.List;

import javax.el.ELContext;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import fr.adaming.ManagedBean.ConseillerMB;
import fr.adaming.model.Visite;
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
	
	
	public List<Visite> getVisitesOfConseiller(){
		ELContext context = FacesContext.getCurrentInstance().getELContext();
		ConseillerMB conseiller = (ConseillerMB) context.getELResolver().getValue(context, null, "conseillerMB");
		return visiteService.getVisitesOfConseiller(conseiller.getConseillerImmobilier().getId_personne());
	}
}
