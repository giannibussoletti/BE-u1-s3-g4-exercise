package giannibussoletti;

import giannibussoletti.dao.*;
import giannibussoletti.entities.Athlete;
import giannibussoletti.entities.Concert;
import giannibussoletti.entities.GymnasticMatch;
import giannibussoletti.entities.SoccerMatch;
import giannibussoletti.enums.ConcertGenre;
import giannibussoletti.enums.EventType;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Application {

    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("beu1s3g4expu");

    public static void main(String[] args) {
        EntityManager em = emf.createEntityManager();
        EventDAO eveDAO = new EventDAO(em);
        PersonaDAO perDAO = new PersonaDAO(em);
        LocationDAO locDAO = new LocationDAO(em);
        ParticipationDAO parDAO = new ParticipationDAO(em);
        AthleteDAO athleteDAO = new AthleteDAO(em);

        Concert concertCaparezza = new Concert("Concerto Caparezza", LocalDate.of(2026,6,26),"Concerto di Caparezza", EventType.PUBLIC,5000, ConcertGenre.ROCK,true);
        Concert concertNegrita = new Concert("Concerto Negrita", LocalDate.of(2026,10,26),"Concerto dei Negrita", EventType.PUBLIC,10000, ConcertGenre.ROCK,false);
        Concert concertEugenio = new Concert("Concerto Eugenio", LocalDate.of(2026,11,2),"Concerto dei Eugenio in via di giocia", EventType.PRIVATE,10000, ConcertGenre.POP,true);
        Athlete mariaCorti = new Athlete("Maria", "Corti");
        SoccerMatch partitaCalcio1 = new SoccerMatch("Inter-Juventus", LocalDate.of(2026,6,26),"Partita di eliminazione",EventType.PUBLIC,10000,"Inter","Juventus","Inter",3,1);
        SoccerMatch partitaCalcio2 = new SoccerMatch("Inter-Milan", LocalDate.of(2026,10,10),"Partita di eliminazione",EventType.PUBLIC,10000,"Inter","Milan","Inter",2,0);
        Athlete francescaLunghi = new Athlete("Francesca", "Lunghi");
//
        Athlete mariaFromDB = athleteDAO.findById("a6b1c75f-560c-41d0-ad07-02512984410d");
        Athlete francescaFromDB = athleteDAO.findById("2e93cb58-d00e-4805-88d5-af13720fc38c");

        List<Athlete> athleteList = new ArrayList<>(List.of(mariaFromDB,francescaFromDB));
//        GymnasticMatch garaGinnastica1= new GymnasticMatch("Gara Maschile Eliminatorie Olimpiadi",LocalDate.of(2026,5,2),"Gara Eliminazione", EventType.PRIVATE,30,mariaFromDB);
//        GymnasticMatch garaGinnastica3= new GymnasticMatch("Gara Maschile Eliminatorie Olimpiadi",LocalDate.of(2026,5,2),"Gara Eliminazione", EventType.PRIVATE,30,francescaFromDB);
        GymnasticMatch garaGinnastica2= new GymnasticMatch("Gara Femminile Eliminatorie Olimpiadi",LocalDate.of(2026,6,3),"Gara Eliminazione", EventType.PUBLIC,2000,mariaFromDB, athleteList);
//        GymnasticMatch garaGinnastica4= new GymnasticMatch("Gara Femminile Eliminatorie Olimpiadi",LocalDate.of(2026,6,3),"Gara Eliminazione", EventType.PUBLIC,2000,francescaFromDB);
//        GymnasticMatch garaGinnastica5= new GymnasticMatch("Corsa ad ostacoli",LocalDate.of(2027,6,3),"Gara Eliminazione", EventType.PUBLIC,2450,mariaFromDB);
//        eveDAO.save(partitaCalcio1);
//        eveDAO.save(partitaCalcio2);
//        eveDAO.save(garaGinnastica2);
//        eveDAO.save(garaGinnastica5);

//        eveDAO.save(concertCaparezza);
//        eveDAO.save(concertNegrita);
//        eveDAO.save(concertEugenio);
//        athleteDAO.save(francescaLunghi);
//        athleteDAO.save(mariaCorti);

    }
}
