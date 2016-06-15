import fr.adaming.DAO.ConseillerDAO;
import fr.adaming.model.personne.Personne;

public class Testatyor {
	
	
	
	public static void main(String[] args) {
		
		ConseillerDAO conseillerDAO = new ConseillerDAO();
		
		Personne personne = conseillerDAO.getById(1);
		
		System.out.println("================>" + personne);
		
		
		
	}

}
