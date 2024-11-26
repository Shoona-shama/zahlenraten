package Domain;

import Ui.Willkomensnachricht;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Ki {
   static Ki quantomki = new Ki();

  static Willkomensnachricht wiki = new Willkomensnachricht();

  List<Integer> attemptsHistory = new ArrayList<>();  // Store each guess attempt

    public int zahlRandomErraten(){
        int zahl = (int)(Math.random() * 5) + 1;
        return zahl;
    }
    public int spielVersucheProRunde(){
        int targetNumber = quantomki.zahlRandomErraten();
        int attempts = 0;
        attemptsHistory.clear();
        for (int versuch = 1; versuch <= 10; versuch++) {
            attempts= versuch;
            int currentGuess = Willkomensnachricht.getErrateZahl();
            attemptsHistory.add(currentGuess);
            if ( Willkomensnachricht.getErrateZahl()== targetNumber) {
                break;
            } else {

            }
        }
        return attempts;
    }
     public int zahlFehlVersuche(){
         int numberWrongGuesses =0;
        for (int i =0; i< quantomki.zahlRandomErraten(); i++ ){
            numberWrongGuesses  += i;
        }
        return numberWrongGuesses;
     }

    public String zahlFehlVersucheDrucken(){
        quantomki.spielVersucheProRunde();
        return "Deine letzten Versuche waren: " + attemptsHistory.toString();
    }
   public int punkteProRunde(){
        int punkteMich= 0;
        int punkteKI= 0;
        if (quantomki.zahlFehlVersuche() > 10 && quantomki.zahlRandomErraten() != Willkomensnachricht.getErrateZahl()){
                 return punkteKI++;
        } else if (quantomki.zahlFehlVersuche() < 10 && quantomki.zahlRandomErraten() == Willkomensnachricht.getErrateZahl()) {
                 return punkteMich++ ;
        }else {

        }

       return Math.max(punkteMich, punkteKI);
   }








}
