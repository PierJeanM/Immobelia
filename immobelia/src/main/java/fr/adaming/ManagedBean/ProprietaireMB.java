package fr.adaming.ManagedBean;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

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

	public List<Proprietaire> getByConseiller(int id) {

		return proprietaireService.getByConseiller(id);
	}
}
