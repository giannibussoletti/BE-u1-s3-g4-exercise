package giannibussoletti.entities;

import giannibussoletti.enums.EventType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import java.time.LocalDate;

@Entity
@Table(name = "soccer_match")
public class SoccerMatch extends Event {

    @Column(name = "home_team", nullable = false)
    private String homeTeam;
    @Column(name = "away_team", nullable = false)
    private String awayTeam;
    @Column(name = "winner_team")
    private String winnerTeam;
    @Column(name = "gol_home_team", nullable = false)
    private int golHomeTeam;
    @Column(name = "gol_away_team", nullable = false)
    private int golAwayTeam;

    public SoccerMatch(String name, LocalDate date, String description, EventType eventType, int numMaxGuest, String homeTeam, String awayTeam, String winnerTeam, int golHomeTeam, int golAwayTeam) {
        super(name, date, description, eventType, numMaxGuest);
        this.homeTeam = homeTeam;
        this.awayTeam = awayTeam;
        this.winnerTeam = winnerTeam;
        this.golHomeTeam = golHomeTeam;
        this.golAwayTeam = golAwayTeam;
    }


    protected SoccerMatch() {
    }
}



