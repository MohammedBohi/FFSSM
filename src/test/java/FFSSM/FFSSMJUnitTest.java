package FFSSM;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;

public class FFSSMJUnitTest {
Club club;
Moniteur moniteur;
Licence licence;
Plongee plongee;
Plongeur plongeur;
    @BeforeEach
    public void setUp(){
        plongeur = new Plongeur("CD-141269","BOHI","Mohammed","30 Rue Louis Vieu","0753046153", LocalDate.of(2003,10,10),4);
        moniteur = new Moniteur("CD-181269","AGOGO","ZEBLi","43 Rue Firmin zamed","0756544858", LocalDate.of(1988,10,20),4,547);
        club = new Club(moniteur,"Zock","0655455858");
        licence = new Licence(plongeur, "15445725",LocalDate.of(2022,2,14),club);
    }
@Test
    public void testLicenceValide(){
        LocalDate aDate = LocalDate.of(2022,12,10);
        LocalDate anotherDate = LocalDate.of(2020,12,5);
        assertTrue(licence.estValide(aDate));
        assertFalse(licence.estValide(anotherDate));
}
    @Test
    public void testDerniereLicence() {
        plongeur.ajouteLicence("1455584", LocalDate.of(2020, 5, 23), club);
        plongeur.ajouteLicence("1555558", LocalDate.of(2021, 6, 10), club);
        plongeur.ajouteLicence("1555558", LocalDate.of(2022, 11, 10), club);
        Licence attendu = new Licence(plongeur,"1555558", LocalDate.of(2022, 11, 10), club);
        boolean result = attendu.equals(plongeur.derniereLicence());
        assertTrue(result, "La dernière licence n'est pas correcte");
    }
    @Test
    public void testPlongeeConforme(){
        Plongeur plongeur2 = new Plongeur("BX-LO1004", "Durand", "hamida", "87 Rue de Messa", "0612587763", LocalDate.of(2021, 10, 12), 10);
        Plongeur plongeur3 = new Plongeur("BX-LO1002", "Durand", "zaml", "10 Rue de Mosa", "0612587963", LocalDate.of(2020, 10, 5), 5);
        Plongee plonge = new Plongee(null, moniteur, LocalDate.of(2022, 5, 10), 7, 25);
        plongeur2.ajouteLicence("1555558", LocalDate.of(2021, 6, 10), club);
        plongeur3.ajouteLicence("1455584", LocalDate.of(2020, 5, 23), club);
        plonge.ajouteParticipant(plongeur2);
        plonge.ajouteParticipant(plongeur3);
        assertFalse(plonge.estConforme());
    }

}

