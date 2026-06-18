package giannibussoletti.entities;

import jakarta.persistence.*;

import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "athletes")
public class Athlete {
    @Id
    @GeneratedValue
    @Column(name = "athlete_id")
    private UUID id;

    @ManyToMany(mappedBy = "athleteList")
    private List<GymnasticMatch> gymnasticMatchList;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private String surname;

    protected Athlete() {
    }

    public Athlete(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }
}
