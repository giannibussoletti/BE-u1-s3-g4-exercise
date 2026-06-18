package giannibussoletti.dao;

import giannibussoletti.entities.Concert;
import giannibussoletti.entities.Event;
import giannibussoletti.entities.SoccerMatch;
import giannibussoletti.enums.ConcertGenre;
import giannibussoletti.exceptions.NotFoundException;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Query;
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

    public List<SoccerMatch> getTiedMatch(String idMatch){
        TypedQuery<SoccerMatch> query = em.createQuery("SELECT s FROM SoccerMatch WHERE s.winnerTeam = null", SoccerMatch.class);
        return query.getResultList();
    }

    public List<SoccerMatch> getAwayTeamWinning(String idMatch){
        TypedQuery<SoccerMatch> query = em.createQuery("SELECT s FROM SoccerMatch WHERE s.golHomeTime < s.golAwayTeam", SoccerMatch.class);
        return query.getResultList();

    }
    public List<SoccerMatch> getHomeTeamWinning(String idMatch){
        TypedQuery<SoccerMatch> query = em.createQuery("SELECT s FROM SoccerMatch WHERE s.golHomeTime > s.golAwayTeam", SoccerMatch.class);
        return query.getResultList();

    }

    public void setWinningTeam(String matchId, String winnerTeam){
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        Query query = em.createQuery("UPDATE SoccerMatch s SET s.winnerTeam = :winnerTeam WHERE s.id = :matchId");
        query.setParameter("winnerTeam", winnerTeam);
        query.setParameter("matchId",  UUID.fromString(matchId));

        query.executeUpdate();
        transaction.commit();
        System.out.println("Winning Team aggiornato correttamente");
    }

    public void setGolHomeTeam(String matchId, int golHomeTeam){
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        Query query = em.createQuery("UPDATE SoccerMatch s SET s.golHomeTeam = :golHomeTeam WHERE s.id = :matchId");
        query.setParameter("golHomeTeam", golHomeTeam);
        query.setParameter("matchId",  UUID.fromString(matchId));
        query.executeUpdate();
        transaction.commit();
        System.out.println("Winning Team aggiornato correttamente");
    }

    public void setGolAwayTeam(String matchId, int golAwayTeam){
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        Query query = em.createQuery("UPDATE SoccerMatch s SET s.golAwayTeam = :golAwayTeam WHERE s.id = :matchId");
        query.setParameter("golAwayTeam", golAwayTeam);
        query.setParameter("matchId",  UUID.fromString(matchId));
        query.executeUpdate();
        transaction.commit();
        System.out.println("Winning Team aggiornato correttamente");


    }
}

