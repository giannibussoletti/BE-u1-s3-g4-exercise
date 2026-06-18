package giannibussoletti.entities;

import giannibussoletti.enums.ConcertGenre;
import giannibussoletti.enums.EventType;
import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "concerts")
public class Concert extends Event {

    @Column(name = "concert_genre", nullable = false)
    @Enumerated(EnumType.STRING)
    private ConcertGenre concertGenre;
    @Column(name = "concert_streaming", nullable = false)
    private boolean concertStreaming;

    public Concert(String name, LocalDate date, String description, EventType eventType, int numMaxGuest, ConcertGenre concertGenre, boolean concertStreaming) {
        super(name, date, description, eventType, numMaxGuest);
        this.concertGenre = concertGenre;
        this.concertStreaming = concertStreaming;
    }


    protected Concert() {
    }
}

