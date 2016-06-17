package fr.adaming.ManagedBean;

import java.util.ArrayList;
import java.util.List;

import javax.el.ELContext;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;








import javax.faces.context.FacesContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import fr.adaming.model.bienImmobilier.BienImmobilier;
import fr.adaming.service.BienImmobilierService;



@ManagedBean
@SessionScoped
@Component
public class BienImmobilierMB {

	@Autowired
	private BienImmobilierService bienImmobilierService;
	
	private BienImmobilier bienImmobilier;
	private List<BienImmobilier> listeBienImmobilier;
	
	
	public BienImmobilierMB() {
	bienImmobilier=new BienImmobilier() {
	};
	listeBienImmobilier=new ArrayList<BienImmobilier>()	;
	}
	
public List<BienImmobilier> getByProprio(){
		
	ELContext context=FacesContext.getCurrentInstance().getELContext();
	BienImmobilierMB bienImmobilierMB=(BienImmobilierMB) context.getELResolver().getValue(context, null, "BienImmobilierMB");
	
	int id=bienImmobilierMB.getBienImmobilier().getIdBien();
		return bienImmobilierService.getByProprio(id);
	}
	
	public int nombreBiensByProprio(){
		System.out.println("======================Nombre Bien par proprio======================"+bienImmobilierService);
		ELContext context=FacesContext.getCurrentInstance().getELContext();
		System.out.println("===============context====================================="+context);
		ProprietaireMB proprietaireMB=(ProprietaireMB) context.getELResolver().getValue(context, null, "proprietaireMB");
		System.out.println("===============proprioMB====================================="+proprietaireMB);
		int id=proprietaireMB.getProprietaire().getId_personne();
		System.out.println("========================ID====================================="+id);
		List<BienImmobilier> listeBiensByProprio= new ArrayList<BienImmobilier>();
		listeBiensByProprio=bienImmobilierService.getByProprio(id);
		System.out.println("========================Nombre de biens======================="+listeBiensByProprio.size());
		return listeBiensByProprio.size();
		
	}
	
	
	
	public BienImmobilierService getBienImmobilierService() {
		return bienImmobilierService;
	}
	public void setBienImmobilierService(BienImmobilierService bienImmobilierService) {
		this.bienImmobilierService = bienImmobilierService;
	}
	public BienImmobilier getBienImmobilier() {
		return bienImmobilier;
	}
	public void setBienImmobilier(BienImmobilier bienImmobilier) {
		this.bienImmobilier = bienImmobilier;
	}
	public List<BienImmobilier> getListeBienImmobilier() {
		System.out.println("====================LISTE BIENS IMMOS======================="+listeBienImmobilier);
		return listeBienImmobilier;
	}
	public void setListeBienImmobilier(List<BienImmobilier> listeBienImmobilier) {
		this.listeBienImmobilier = listeBienImmobilier;
	}
	
	
	
	
}
