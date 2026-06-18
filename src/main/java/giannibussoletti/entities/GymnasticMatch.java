package giannibussoletti.entities;

import giannibussoletti.enums.EventType;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "gymnastic_match")
public class GymnasticMatch extends Event {

    @ManyToOne
    @JoinColumn(name = "winner_id")
    private Athlete winner;

    @ManyToMany()
    @JoinTable(name = "match_athletes",
            joinColumns = @JoinColumn(name = "match_id"),
            inverseJoinColumns = @JoinColumn(name = "athlete_id"))
    private List<Athlete> athleteList;

    protected GymnasticMatch() {
    }

    public GymnasticMatch(String name, LocalDate date, String description, EventType eventType, int numMaxGuest, Athlete winner, List<Athlete> athleteList) {
        super(name, date, description, eventType, numMaxGuest);
        this.winner = winner;
        this.athleteList = athleteList;
    }

    public Athlete getWinner() {
        return winner;
    }
}