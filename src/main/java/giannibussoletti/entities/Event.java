package giannibussoletti.entities;

import giannibussoletti.enums.EventType;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "events")
public abstract class Event {
    @Id
    @GeneratedValue
    @Column(name = "event_id")
    private UUID id;

    @Column(name = "event_name", nullable = false)
    private String name;

    @Column(name = "event_date", nullable = false)
    private LocalDate date;

    @Column(name = "event_description", nullable = false)
    private String description;

    @Column(name = "event_type", nullable = false)
    @Enumerated(EnumType.STRING)
    private EventType eventType;

    @Column(name = "event_max_guest", nullable = false)
    private int numMaxGuest;


    public Event(String name, LocalDate date, String description, EventType eventType, int numMaxGuest) {
        this.name = name;
        this.date = date;
        this.description = description;
        this.eventType = eventType;
        this.numMaxGuest = numMaxGuest;
    }

    protected Event() {
    }

    @Override
    public String toString() {
        return "Event{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", date=" + date +
                ", description='" + description + '\'' +
                ", eventType=" + eventType +
                ", numMaxGuest=" + numMaxGuest;
    }

    public UUID getId() {
        return id;
    }
}

