package giannibussoletti.entities;

import giannibussoletti.enums.EventType;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "gymnastic_match")
public class GymnasticMatch extends Event {
    @Column(nullable = false)
    private String winner;

    @ManyToMany()
    @JoinTable(name = "match_athletes",
            joinColumns = @JoinColumn(name = "match_id"),
            inverseJoinColumns = @JoinColumn(name = "athlete_id"))
    private List<Athlete> athleteList;

    protected GymnasticMatch() {
    }

    public GymnasticMatch(String name, LocalDate date, String description, EventType eventType, int numMaxGuest, String winner) {
        super(name, date, description, eventType, numMaxGuest);
        this.winner = winner;
    }

    public String getWinner() {
        return winner;
    }
}
//        String name,LocalDate date,String description,EventType eventType,int numMaxGuest,