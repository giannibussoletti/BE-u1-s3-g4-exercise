package giannibussoletti.entities;

import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table(name = "location")
public class Location {

    @Id
    @GeneratedValue
    @Column(name = "location_id")
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "event_id", nullable = false)
    private Event eventId;

    @Column(name = "location_name", nullable = false)
    private String locationName;

    public Location(Event eventId, String locationName) {
        this.eventId = eventId;
        this.locationName = locationName;
    }

    public Location() {
    }

    public UUID getId() {
        return id;
    }
}

