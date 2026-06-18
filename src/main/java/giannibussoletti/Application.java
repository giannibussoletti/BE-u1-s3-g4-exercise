package giannibussoletti;

import giannibussoletti.dao.EventDAO;
import giannibussoletti.dao.LocationDAO;
import giannibussoletti.dao.ParticipationDAO;
import giannibussoletti.dao.PersonaDAO;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class Application {

    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("beu1s3g4expu");

    public static void main(String[] args) {
        EntityManager em = emf.createEntityManager();
        EventDAO eveDAO = new EventDAO(em);
        PersonaDAO perDAO = new PersonaDAO(em);
        LocationDAO locDAO = new LocationDAO(em);
        ParticipationDAO parDAO = new ParticipationDAO(em);


    }
}
