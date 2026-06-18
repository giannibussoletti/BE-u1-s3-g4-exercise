package giannibussoletti.dao;

import giannibussoletti.entities.Event;
import giannibussoletti.exceptions.NotFoundException;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

import java.util.UUID;

public class EventDAO {

    private final EntityManager em;

    public EventDAO(EntityManager em) {
        this.em = em;
    }

    public void save(Event newEvent) {
        EntityTransaction transaction = this.em.getTransaction();
        transaction.begin();
        this.em.persist(newEvent);
        transaction.commit();
        System.out.println("Evento aggiunto correttamente");
    }

    public Event findById(String id) {
        Event fromDB = this.em.find(Event.class, UUID.fromString(id));
        if (fromDB != null) return fromDB;
        else throw new NotFoundException(id);
    }
}
