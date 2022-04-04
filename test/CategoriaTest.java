import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.videojuegoshop.enitity.Categoria;



public class CategoriaTest {

	public static void main(String[] args) {

		Categoria newCat = new Categoria("Rpg");

		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("PFCYAA");
		EntityManager entityManager = entityManagerFactory.createEntityManager();

		entityManager.getTransaction().begin();

		entityManager.persist(newCat);

		entityManager.getTransaction().commit();
		entityManager.close();
		entityManagerFactory.close();

		System.out.println("Categoria persistida");
	}

}