package fr.adaming.ManagedBean;

import java.util.ArrayList;
import java.util.List;

import javax.el.ELContext;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import org.primefaces.event.SlideEndEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import fr.adaming.model.ClasseStandard;
import fr.adaming.model.bienImmobilier.BienImmobilier;
import fr.adaming.model.bienImmobilier.Offre;
import fr.adaming.model.personne.Adresse;
import fr.adaming.model.personne.Proprietaire;
import fr.adaming.service.BienImmobilierService;


@ManagedBean
@SessionScoped
@Component
public class BienImmobilierMB {

	@Autowired
	private BienImmobilierService bienImmobilierService;

	private BienImmobilier bienImmobilier;
	private List<BienImmobilier> listeBienImmobilier;

	private String[] selectedClassesStandard;
	
	public BienImmobilierMB() {
		bienImmobilier = new BienImmobilier() {
		};
		bienImmobilier.setAdresse(new Adresse());
		bienImmobilier.setProprio(new Proprietaire());
		bienImmobilier.setClasseStandard(new ClasseStandard());
		bienImmobilier.setTypeOffre(new Offre() {
		});
		listeBienImmobilier = new ArrayList<BienImmobilier>();
	}

	public List<BienImmobilier> getByProprio() {

		ELContext context = FacesContext.getCurrentInstance().getELContext();
		BienImmobilierMB bienImmobilierMB = (BienImmobilierMB) context
				.getELResolver().getValue(context, null, "BienImmobilierMB");

		int id = bienImmobilierMB.getBienImmobilier().getIdBien();
		return bienImmobilierService.getByProprio(id);
	}

	public void slidePrix(SlideEndEvent event) {
        FacesMessage message = new FacesMessage("Prix de Vente choisi", "Valeur: " + event.getValue());
        FacesContext.getCurrentInstance().addMessage(null, message);
    } 
	
	public void slideRevenu(SlideEndEvent event) {
        FacesMessage message = new FacesMessage("Revenu Cadastral à posseder", "Valeur: " + event.getValue());
        FacesContext.getCurrentInstance().addMessage(null, message);
    }
	
	public void slideSuperficie(SlideEndEvent event) {
        FacesMessage message = new FacesMessage("Superficie indiquée", "Valeur: " + event.getValue());
        FacesContext.getCurrentInstance().addMessage(null, message);
    }
	
	public void addBienImmo(BienImmobilier bienImmobilier){
	
		bienImmobilierService.addBien(bienImmobilier);
		bienImmobilier=new BienImmobilier() {
		};
		
	}

	public BienImmobilierService getBienImmobilierService() {
		return bienImmobilierService;
	}

	public void setBienImmobilierService(
			BienImmobilierService bienImmobilierService) {
		this.bienImmobilierService = bienImmobilierService;
	}

	public BienImmobilier getBienImmobilier() {
		return bienImmobilier;
	}

	public void setBienImmobilier(BienImmobilier bienImmobilier) {
		this.bienImmobilier = bienImmobilier;
	}

	public List<BienImmobilier> getListeBienImmobilier() {
		System.out
				.println("====================LISTE BIENS IMMOS======================="
						+ listeBienImmobilier);
		return listeBienImmobilier;
	}

	public void setListeBienImmobilier(List<BienImmobilier> listeBienImmobilier) {
		this.listeBienImmobilier = listeBienImmobilier;
	}

	public String[] getSelectedClassesStandard() {
		return selectedClassesStandard;
	}

	public void setSelectedClassesStandard(String[] selectedClassesStandard) {
		this.selectedClassesStandard = selectedClassesStandard;
	}

	
	
}
