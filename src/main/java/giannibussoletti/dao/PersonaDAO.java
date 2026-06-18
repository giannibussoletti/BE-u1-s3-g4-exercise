package giannibussoletti.dao;

import giannibussoletti.entities.Persona;
import giannibussoletti.exceptions.NotFoundException;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

import java.util.UUID;

public class PersonaDAO {

    private final EntityManager em;

    public PersonaDAO(EntityManager em) {
        this.em = em;
    }

    public void save(Persona newPersona) {
        EntityTransaction transaction = this.em.getTransaction();
        transaction.begin();
        this.em.persist(newPersona);
        transaction.commit();
        System.out.println("Persona aggiunta correttamente");
    }

    public Persona findById(String id) {
        Persona fromDB = this.em.find(Persona.class, UUID.fromString(id));
        if (fromDB != null) return fromDB;
        else throw new NotFoundException(id);
    }
}
