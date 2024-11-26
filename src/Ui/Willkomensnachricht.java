package Ui;

import Domain.Ki;

import java.util.ArrayList;
import java.util.Scanner;

public class Willkomensnachricht {

  static Ki quantom = new Ki();
   private static int errateZahl;
  static ArrayList<Integer> versuchHistory = new ArrayList<Integer>();


    public static int getErrateZahl() {
        return errateZahl;
    }

    public static void ui(){
        int attempts = 0;
        System.out.println("Willkommen beim Spiel Zahlenraten! Mein Name ist Quantum." +
                " Ich bin eine Künstliche Intelligenz.");
        System.out.println("Ich habe eine Zahl zwischen 1 und 100 gewählt. Kannst du sie erraten?");
        Scanner scn = new Scanner(System.in);
        errateZahl = scn.nextInt();
        while (attempts < 10) {
            System.out.println("dein tip : " + errateZahl);
            versuchHistory.add(errateZahl);
            if (errateZahl != quantom.zahlRandomErraten()){
                if (errateZahl < quantom.zahlRandomErraten()) {
                    System.out.println("zu niedrig !" + "Versuche es erneut.");
                } else {
                    System.out.println("zu hoch !" + "Versuche es erneut.");
                }
                errateZahl = scn.nextInt();
            }else {
                System.out.println("Herzlichen Glückwunsch! Diese Runde geht an dich. Du hast die Zahl in " +
                        /** quantom.zahlFehlVersuche() **/ + attempts  +" Versuchen erraten.");
                //scn.close();
                for (int versuchHis : versuchHistory) {
                    System.out.println("Deine letzten Versuche waren: " + "[" + versuchHis + "]");
                }
                System.out.println("Möchtest du noch einmal spielen? (ja/nein):");
                //Scanner sc = new Scanner(System.in);
                String antwort = scn.nextLine();
                System.out.println(antwort + " ");

                if (antwort.equalsIgnoreCase("yes")) {
                    System.out.println("You answered YES!");
                    System.out.println("dein tip : " + errateZahl);
                } else if (antwort.equalsIgnoreCase("no")) {
                    System.out.println("You answered NO! so the game ends here , goodbye !");
                    break;
                } else {
                    System.out.println("Invalid input. Please answer with 'yes' or 'no'.");
                    antwort = scn.nextLine();
                }

                // scn.close();
            }


            attempts++;
        }
        scn.close();
        System.out.println("tut mir leid du hast verloren!");
    }

    public static void main(String[] args) {
      ui();
    }
}