import java.util.Scanner;
import model.*;

import service.ParkhausVerwalter;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Initialisiere Parkhaus
        int etagen = 3;
        int plaetzeProEtage = 5;
        ParkhausVerwalter verwalter = new ParkhausVerwalter(etagen, plaetzeProEtage);

        boolean running = true;
        while (running) {
            System.out.println("\n=== Parkhaus Simulation ===");
            System.out.println("[P] Fahrzeug einparken");
            System.out.println("[A] Fahrzeug ausparken");
            System.out.println("[S] Fahrzeug suchen");
            System.out.println("[F] Freie Plätze anzeigen");
            System.out.println("[Q] Beenden");
            System.out.print("Wähle Option: ");

            String eingabe = scanner.nextLine().trim().toUpperCase();

            switch (eingabe) {
                case "P":
                    System.out.print("Fahrzeugtyp (Auto/Motorrad): ");
                    String typ = scanner.nextLine().trim().toLowerCase();

                    System.out.print("Kennzeichen: ");
                    String nummernschild = scanner.nextLine().trim();

                    Fahrzeug fahrzeug;
                    if (typ.equals("auto")) {
                        fahrzeug = new Auto(nummernschild);
                    } else if (typ.equals("motorrad")) {
                        fahrzeug = new Motorrad(nummernschild);
                    } else {
                        System.out.println("Ungültiger Fahrzeugtyp!");
                        break;
                    }

                    verwalter.einparken(fahrzeug);
                    break;

                case "A":
                    System.out.print("Kennzeichen des auszuparkenden Fahrzeugs: ");
                    String ausKennzeichen = scanner.nextLine().trim();
                    verwalter.ausparken(ausKennzeichen);
                    break;

                case "S":
                    System.out.print("Kennzeichen des gesuchten Fahrzeugs: ");
                    String suchKennzeichen = scanner.nextLine().trim();
                    Position position = verwalter.sucheFahrzeug(suchKennzeichen);
                    if (position != null) {
                        System.out.println("Fahrzeug gefunden: " + position);
                    } else {
                        System.out.println("Fahrzeug nicht gefunden.");
                    }
                    break;

                case "F":
                    verwalter.zeigeFreiePlaetze();
                    break;

                case "Q":
                    running = false;
                    System.out.println("Simulation beendet.");
                    break;

                default:
                    System.out.println("Ungültige Eingabe.");
            }
        }

        scanner.close();
    }
}
