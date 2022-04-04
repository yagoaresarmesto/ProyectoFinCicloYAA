import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.videojuegoshop.enitity.Usuarios;



public class UsuariosTest {

	public static void main(String[] args) {

		Usuarios usuario1 = new Usuarios();
		usuario1.setEmail("jesus2@gmail.com");
		usuario1.setApellidos("Jesus Ares Amresto");
		usuario1.setContraseña("todossomos2");

		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("PFCYAA");
		EntityManager entityManager = entityManagerFactory.createEntityManager();

		entityManager.getTransaction().begin();

		entityManager.persist(usuario1);

		entityManager.getTransaction().commit();
		entityManager.close();
		entityManagerFactory.close();

		System.out.println("Usuario persistido");
	}

}