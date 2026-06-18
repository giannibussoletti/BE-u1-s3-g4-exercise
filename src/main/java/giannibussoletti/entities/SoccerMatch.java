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

    public SoccerMatch(String name, LocalDate date, String description, EventType eventType, int numMaxGuest, String homeTeam, String awayTeam) {
        super(name, date, description, eventType, numMaxGuest);
        this.homeTeam = homeTeam;
        this.awayTeam = awayTeam;
    }

    protected SoccerMatch() {
    }

    public String getHomeTeam() {
        return homeTeam;
    }

    public String getAwayTeam() {
        return awayTeam;
    }

    public void setAwayTeam(String awayTeam) {
        this.awayTeam = awayTeam;
    }

    public String getWinnerTeam() {
        return winnerTeam;
    }

    public void setWinnerTeam(String winnerTeam) {
        this.winnerTeam = winnerTeam;
    }

    public int getGolHomeTeam() {
        return golHomeTeam;
    }

    public void setGolHomeTeam(int golHomeTeam) {
        this.golHomeTeam = golHomeTeam;
    }

    public int getGolAwayTeam() {
        return golAwayTeam;
    }

    public void setGolAwayTeam(int golAwayTeam) {
        this.golAwayTeam = golAwayTeam;
    }

    @Override
    public String toString() {
        return  super.toString() +
                " homeTeam: " + homeTeam + '\'' +
                ", awayTeam='" + awayTeam + '\'' +
                ", winnerTeam='" + winnerTeam + '\'' +
                ", golHomeTeam=" + golHomeTeam +
                ", golAwayTeam=" + golAwayTeam +
                "} ";
    }
}



