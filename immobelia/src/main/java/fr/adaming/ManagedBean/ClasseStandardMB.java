package fr.adaming.ManagedBean;

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
	
	
	public List<ClasseStandard> getAllClasseStandard(){
		
		return classeStandardService.getAll();
		
		
	}
	
}
