package fr.adaming.ManagedBean;

import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import fr.adaming.model.personne.ConseillerImmobilier;
import fr.adaming.service.ConseillerService;

@ManagedBean
@SessionScoped
@Component
public class ConseillerMB {

	@Autowired
	private ConseillerService conseillerService;

	private ConseillerImmobilier conseillerImmobilier;
	private List<ConseillerImmobilier> listeConseillers;

	public ConseillerMB() {
		conseillerImmobilier = new ConseillerImmobilier();
	}

	/**
	 * Méthode appelée lors du login du conseiller (page Index.xhtml)
	 */
	public String login() {
		listeConseillers = conseillerService.getAll();

		for (ConseillerImmobilier cons : listeConseillers) {
			if (cons.getId_personne() == conseillerImmobilier.getId_personne()
					&& cons.getMotDePasse().equals(
							conseillerImmobilier.getMotDePasse())) {
				setConseillerImmobilier(cons);
				return "/pages/homepage.xhtml?faces-redirect=true";
			}
		}
		FacesContext.getCurrentInstance().addMessage(null,
				new FacesMessage("Identification incorrecte"));
		return null;
	}
	
	/** 
	 * Logout du conseiller
	 * @return 
	 */
	public String logout() {
		FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
		return "/index.xhtml?faces-redirect=true";
	}

	public ConseillerService getConseillerService() {
		return conseillerService;
	}

	public void setConseillerService(ConseillerService conseillerService) {
		this.conseillerService = conseillerService;
	}

	public List<ConseillerImmobilier> getListeConseillers() {
		return listeConseillers;
	}

	public void setListeConseillers(List<ConseillerImmobilier> listeConseillers) {
		this.listeConseillers = listeConseillers;
	}

	public ConseillerImmobilier getConseillerImmobilier() {
		return conseillerImmobilier;
	}

	public void setConseillerImmobilier(
			ConseillerImmobilier conseillerImmobilier) {
		this.conseillerImmobilier = conseillerImmobilier;
	}

} // Fin classe ConseillerMB
