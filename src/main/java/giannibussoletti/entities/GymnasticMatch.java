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
    private Athlete winner = null;

    @ManyToMany()
    @JoinTable(name = "match_athletes",
            joinColumns = @JoinColumn(name = "match_id"),
            inverseJoinColumns = @JoinColumn(name = "athlete_id"))
    private List<Athlete> athleteList = null;

    protected GymnasticMatch() {
    }

    public GymnasticMatch(String name, LocalDate date, String description, EventType eventType, int numMaxGuest) {
        super(name, date, description, eventType, numMaxGuest);
    }

    public void setWinner(Athlete winner) {
        this.winner = winner;
    }

    public Athlete getWinner() {
        return winner;
    }

    public List<Athlete> getAthleteList() {
        return athleteList;
    }

    public void setAthleteList(List<Athlete> athleteList) {
        this.athleteList = athleteList;
    }

    @Override
    public String toString() {
        return "GymnasticMatch{" +
                "winner=" + winner +
                ", athleteList=" + athleteList +
                "} " + super.toString();
    }


}