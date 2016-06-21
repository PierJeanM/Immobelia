package fr.adaming.ManagedBean;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import fr.adaming.model.ClasseStandard;
import fr.adaming.service.ClasseStandardService;


@ManagedBean
@SessionScoped
@Component
public class ClasseStandardMB {

	@Autowired
	private ClasseStandardService classeStandardService;
	
	private ClasseStandard classeStandard;
	private List<ClasseStandard> listeClasseStandard;
	
	public ClasseStandardMB() {
		classeStandard=new ClasseStandard();
		listeClasseStandard=new ArrayList<ClasseStandard>();
	}

	public List<ClasseStandard> getAllClasseStandard(){
		
		return classeStandardService.getAll();
		
		
	}

	public ClasseStandardService getClasseStandardService() {
		return classeStandardService;
	}

	public void setClasseStandardService(ClasseStandardService classeStandardService) {
		this.classeStandardService = classeStandardService;
	}

	public ClasseStandard getClasseStandard() {
		return classeStandard;
	}

	public void setClasseStandard(ClasseStandard classeStandard) {
		this.classeStandard = classeStandard;
	}

	public List<ClasseStandard> getListeClasseStandard() {
		return listeClasseStandard;
	}

	public void setListeClasseStandard(List<ClasseStandard> listeClasseStandard) {
		this.listeClasseStandard = listeClasseStandard;
	}
	
	
	
	
}
