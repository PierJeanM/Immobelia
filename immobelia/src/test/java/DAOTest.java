
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import fr.adaming.DAO.ConseillerDAO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/applicationContext.xml"})
public class DAOTest {

	@Autowired
	ConseillerDAO conseillerDAO;
	
	@Test
	public void testClientDAO(){
		
		System.out.println(conseillerDAO.getById(1).getNom());
		
		
		System.out.println("Fin des tests clientDAO");
	}

}
