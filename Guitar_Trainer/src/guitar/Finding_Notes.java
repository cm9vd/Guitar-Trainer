package guitar;

import java.util.Random;
import java.util.Scanner;

public class Finding_Notes {

    private static int saite;
    private static int bund;

    //Instructions
    static String instr = "Dieses Programm dient zum Erlernen der Noten auf der Gitarre.\n" +
            "Wähle einen Modus und drücke Start.\n" +
            "Lösung / Weiter zeigt dir das Ergebnis.\n" +
            "Erneutes drücken zeigt dir die neue Aufgabe.\n" +
            "Viel Spaß beim Lernen!";

    private static String[][] Noten = {{"F" , "F#" , "G", "G#", "A", "A#", "H", "C", "C#", "D", "D#", "E", "F", "F#", "G", "G#", "A", "A#"},
            {"C", "C#", "D", "D#", "E", "F", "F#", "G", "G#", "A", "A#","H", "C", "C#", "D", "D#", "E", "F"},
            {"G#", "A", "A#", "H", "C", "C#", "D", "D#", "E", "F", "F#", "G", "G#", "A", "A#","H", "C", "C#"},
            {"D#", "E", "F", "F#", "G", "G#", "A", "A#","H", "C", "C#", "D", "D#", "E", "F", "F#" , "G", "G#"},
            {"A#", "H", "C", "C#", "D", "D#", "E", "F", "F#", "G", "G#", "A", "A#",  "H", "C", "C#", "D", "D#"},
            {"F" , "F#" , "G", "G#", "A", "A#", "H", "C", "C#", "D", "D#", "E", "F", "F#", "G", "G#", "A", "A#"}};

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        for(int i = 0; i < 10; i++) {
            System.out.print(nextTask());
            sc.nextLine();
            System.out.println(Noten[saite][bund]);
            System.out.println();

        }
    }

    static String nextTask(){
        return "\n\t" + getTheSaite() + "-Saite  " + getTheNote() + ". Bund";
    }

    static String getSolution(){
        return "\n\t           " + Noten[saite][bund];
    }


    private static String getTheSaite(){
        Random rd = new Random();
        int saiteNr = rd.nextInt(6) + 1;

        saite = saiteNr -1 ;

        String saite = "no saite found?";

        switch (saiteNr){
            case 6: saite = "E";
                break;
            case 5: saite = "A";
                break;
            case 4: saite = "d";
                break;
            case 3: saite = "g";
                break;
            case 2: saite = "h";
                break;
            case 1: saite = "e";
        }

        return saite;
    }

    private static int getTheNote(){
        Random rd = new Random();
        int note = rd.nextInt(12) + 1;
        bund = note -1;
        return note;
    }
}
