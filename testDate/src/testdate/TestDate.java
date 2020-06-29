/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package testdate;
import java.time.DayOfWeek;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.time.temporal.ChronoUnit;

/**
 *
 * @author stagjava
 */
public class TestDate {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // Initialisation
        
        // Variables        
        LocalDateTime today = LocalDateTime.now();
        LocalDate today2 = LocalDate.now();
        
        int day = today.getDayOfMonth();
        int month = today.getMonthValue();
        int year = today.getYear();
        int hour = today.getHour();
        int mn = today.getMinute();
        int sec = today.getSecond();
        

        // Calcul temps jusqu'à la fin de la mois
        LocalDate nextMonth = LocalDate.of(year,month+1, 1);
        Period endOfMonth = Period.between(today2, nextMonth);
        // Calcul temps jusqu'à la fin de la mois
        LocalDate nextYear = LocalDate.of(year + 1,1, 1);
        Period endOfYear = Period.between(today2, nextYear);
        
        // Date du jour
        System.out.println( day + "/" + month + "/" + year + " " + hour + ":" + mn);
        
        // Intervalle jusqu'à la fin du jour 
        intervalleFinDeJournee(hour, mn);
        
        // Intervalle jusqu'à la fin du mois 
        intervalleFinDeMois(hour, mn, endOfMonth);

        // Intervalle jusqu'à la fin de l'année 
        intervalleFinAnnee(hour, mn, endOfMonth);
        
        // Temps d'exécution
        LocalDateTime todayFin = LocalDateTime.now();
        Duration duree = Duration.between(today, todayFin);
        System.out.println("Temps d'exécution: " + duree.getNano());
        
        // Nombre de lundi, mardi restant
        compterLesJours(today2, nextYear);
        
     
    }
    
    public static void intervalleFinDeJournee(int hour, int mn) {
        double EODpc = ((((double) (hour ))  / 24) * 20)  ;

        System.out.println("Avant la fin du jour: " + (24 -hour - 1) + "h " + (60 - mn) +"m");
        // Option graphique
        System.out.print("O".repeat((int) EODpc));
        System.out.println("-".repeat((int) (20 - EODpc)));
        
    }

    public static void intervalleFinDeMois(int hour, int mn, Period endOfMonth) {
        double EOMpc = ((((double) (31 - endOfMonth.getDays() ))  / 31) * 20)  ;
        
        if (endOfMonth.getDays() > 0) {
            System.out.println("Avant la fin du mois: " + (endOfMonth.getDays() -1) + "j " + (24 -hour) +"h");
            // Option graphique
            System.out.print("O".repeat((int) EOMpc));
            System.out.println("-".repeat((int) (20 - EOMpc)));
        } else {
            intervalleFinDeJournee(hour, mn);
        }
        
    }
    public static void intervalleFinAnnee(int hour, int mn, Period endOfYear) {
        double EOYpc = ((((double) (12 - endOfYear.getMonths() ))  / 12) * 20)  ;

        if (endOfYear.getMonths() > 0) {
            System.out.println("Avant la fin de l'année: " + (endOfYear.getMonths()-1) + "m " + endOfYear.getDays() + "j");
            // Option graphique
            System.out.print("O".repeat((int) EOYpc));
            System.out.println("-".repeat((int) (20 - EOYpc)));
        } else {
            if (endOfYear.getDays() > 0) {
                intervalleFinDeMois(hour, mn, endOfYear);
            } else {
            intervalleFinDeJournee(hour, mn);
            }            
        }
  
    }
        
    public static void compterLesJours(LocalDate today2, LocalDate nextYear) {
        // nb de semaines jusqu'à la fin de l'année
        long nbSemaines = ChronoUnit.WEEKS.between(today2, nextYear);
        long nbSemaine;
        // No de jour dans la semaine du jour traité
        DayOfWeek dow = today2.getDayOfWeek();
       int cdow = dow.getValue();

        // No de jour du dernier jour de l'année
        LocalDate lastDayYear = today2.minusDays(1);
        DayOfWeek dld = lastDayYear.getDayOfWeek();
         int cdld = dld.getValue();
        System.out.println(cdow);
        for (int i = 1; i <= 7;i++) {
            if (i<= cdow) {
                // Jour passé dans la semaine en cours => nb semaine restant
                nbSemaine = nbSemaines;
            } else {
                // ajouter 1 pour la semaine en cours
                nbSemaine = nbSemaines + 1;
            }
            if (i >cdld) {
                // Jour dans la dernière semaine de l'année qui n'est pas dans l'année
                nbSemaine -= 1;
            } 
            System.out.println("Number of " + DayOfWeek.of(i) + ": " + nbSemaine);
        }
        
    }
        

        
}
