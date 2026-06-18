package giannibussoletti.dao;

import giannibussoletti.entities.Athlete;
import giannibussoletti.entities.Event;
import giannibussoletti.exceptions.NotFoundException;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

import java.util.UUID;

public class AthleteDAO {

    private final EntityManager em;

    public AthleteDAO(EntityManager em) {
        this.em = em;
    }

    public void save(Athlete newAthlete) {
        EntityTransaction transaction = this.em.getTransaction();
        transaction.begin();
        this.em.persist(newAthlete);
        transaction.commit();
        System.out.println("Atleta aggiunto correttamente");
    }

    public Athlete findById(String id){
     Athlete fromDB = this.em.find(Athlete.class, UUID.fromString(id));
        if (fromDB != null) return fromDB;
        else throw new NotFoundException(id);
    }

}
