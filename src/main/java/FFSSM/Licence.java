/**
 * @(#) LicencePlongeur.java
 */
package FFSSM;

import java.time.LocalDate;
import java.util.Objects;

public class Licence implements Comparable<Licence>{

    public Personne possesseur;

    public String numero;

    public LocalDate delivrance;

    public Club club;
    public Licence(){

    }

    public Licence(Personne possesseur, String numero, LocalDate delivrance, Club club) {
        this.possesseur = possesseur;
        this.numero = numero;
        this.delivrance = delivrance;
        this.club = club;
    }

    public Personne getPossesseur() {
        return possesseur;
    }

    public String getNumero() {
        return numero;
    }

    public LocalDate getDelivrance() {
        return delivrance;
    }

    public Club getClub() {
        return club;
    }

    /**
     * Est-ce que la licence est valide à la date indiquée ?
     * Une licence est valide pendant un an à compter de sa date de délivrance
     * @param d la date à tester
     * @return vrai si valide à la date d
     **/
    public boolean estValide(LocalDate d) {



        return d.isAfter(delivrance) && d.isBefore(delivrance.plusYears(1)) || d.isEqual(delivrance);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Licence licence = (Licence) o;
        return possesseur.equals(licence.possesseur) && numero.equals(licence.numero) && delivrance.equals(licence.delivrance) && club.equals(licence.club);
    }

    @Override
    public int hashCode() {
        return Objects.hash(possesseur, numero, delivrance, club);
    }
    @Override
    public int compareTo(Licence autre) {
        int comparaison = 0;
        if(this.delivrance.isAfter(autre.getDelivrance())){
            comparaison = 1;
        }else{
            comparaison = -1;
        }
        return comparaison;
    }

}
