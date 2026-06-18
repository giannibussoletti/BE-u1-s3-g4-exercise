package giannibussoletti.entities;

import giannibussoletti.enums.Gender;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "persona")
public class Persona {

    @Id
    @GeneratedValue
    @Column(name = "persona_id")
    private UUID id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "surname", nullable = false)
    private String surname;

    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "born_date", nullable = false)
    private LocalDate bornDate;

    @Column(name = "gender")
    @Enumerated(EnumType.STRING)
    private Gender gender;

    @OneToMany(mappedBy = "persona")
    private List<Participation> partecipationList;


    public Persona(String name, String surname, String email, LocalDate bornDate, Gender gender) {
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.bornDate = bornDate;
        this.gender = gender;
    }

    public Persona() {
    }

    public UUID getId() {
        return id;
    }
}
