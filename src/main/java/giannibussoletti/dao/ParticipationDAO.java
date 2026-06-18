package giannibussoletti.dao;

import giannibussoletti.entities.Participation;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

public class ParticipationDAO {

    private final EntityManager em;

    public ParticipationDAO(EntityManager em) {
        this.em = em;
    }

    public void save(Participation newParticipation) {
        EntityTransaction transaction = this.em.getTransaction();
        transaction.begin();
        this.em.persist(newParticipation);
        transaction.commit();
        System.out.println("Partecipazione aggiunta correttamente");
    }
}
