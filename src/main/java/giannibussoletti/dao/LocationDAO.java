package giannibussoletti.dao;


import giannibussoletti.entities.Location;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

public class LocationDAO {

    private final EntityManager em;

    public LocationDAO(EntityManager em) {
        this.em = em;
    }

    public void save(Location newLocation) {
        EntityTransaction transaction = this.em.getTransaction();
        transaction.begin();
        this.em.persist(newLocation);
        transaction.commit();
        System.out.println("Location aggiunta correttamente");
    }
}
