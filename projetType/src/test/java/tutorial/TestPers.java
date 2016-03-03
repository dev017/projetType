package tutorial;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.projet.type.entity.Personne;
import com.projet.type.service.data.IPersonneService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "file:src/main/resources/META-INF/spring/spring-core.xml", "file:src/main/resources/META-INF/spring/spring-jpa.xml" })
@ActiveProfiles({ "dev" })
public class TestPers {

	@Autowired
	IPersonneService persService;

	private List<Personne> listPers = new ArrayList<Personne>();

	@Test
	public void getAllPersonne() {
		// for (Personne p : persService.findAll()) {
		// System.out.println(p.getNom() + "  " + p.getPrenom());
		// }

		listPers = persService.findAll();
		System.out.println(listPers.size());
	}

}
