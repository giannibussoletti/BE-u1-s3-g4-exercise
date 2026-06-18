package giannibussoletti.dao;

import giannibussoletti.entities.Concert;
import giannibussoletti.entities.Event;
import giannibussoletti.enums.ConcertGenre;
import giannibussoletti.exceptions.NotFoundException;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.TypedQuery;

import java.util.List;
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

    public List<Concert> findConcertByStreaming(boolean bool){
        TypedQuery<Concert> query = em.createQuery("SELECT c FROM Concert c WHERE c.concertStreaming = :bool", Concert.class);
        query.setParameter("bool", bool);
        return query.getResultList();

    }
    public List<Concert> findConcertByGenre(ConcertGenre genre){
        TypedQuery<Concert> query = em.createQuery("SELECT c FROM Concert c WHERE c.concertGenre = :genre", Concert.class);
        query.setParameter("genre", genre);
        return query.getResultList();
    }
}
