package giannibussoletti.entities;

import giannibussoletti.enums.Confirmation;
import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table(name = "participation")
public class Participation {

    @Id
    @GeneratedValue
    @Column(name = "participation_id")
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "event", nullable = false)
    private Event event;

    @ManyToOne
    @JoinColumn(name = "persona_id", nullable = false)
    private Persona persona;

    @Column(name = "confirmation")
    @Enumerated(EnumType.STRING)
    private Confirmation confirmation;

    public Participation(Event event, Persona persona, Confirmation confirmation) {
        this.event = event;
        this.persona = persona;
        this.confirmation = confirmation;
    }

    public Participation() {
    }

    public UUID getId() {
        return id;
    }
}
