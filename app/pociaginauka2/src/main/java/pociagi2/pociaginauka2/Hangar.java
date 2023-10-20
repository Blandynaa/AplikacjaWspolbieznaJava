package pociagi2.pociaginauka2;

//import javax.management.InvalidAttributeValueException;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.StackPane;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;
import java.util.Scanner;

import java.util.ArrayList;
import java.util.List;

public class Hangar {

//    FXMLLoader loader = new FXMLLoader();
//    loader.setLocation(this.getClass().getResource("/fxml/scena1.fxml"));
//    StackPane stackPane = loader.load();

    public HelloController controller;

    // okresla ilosc pociagow ktore moga naraz byc w hangarze
    public static final int N = 5;
    public static final char[] tab = new char[5];
    int gdzie;
    int skad;
    // enum ktory przechowuje informacje na temat rodzaju kolejki
    // INSIDE -> obiektu wewnatrz hangaru
    // QUEUE -> obiekty ktore oczekuja na wejscie
    public enum Where{
        INSIDE, QUEUE
    }

    // enum ktory okresla typ obiektu ktory moze sie pojawic w hangarze
    public enum What{
        TRAIN, BOSS
    }

    // brama przez ktora trzeba przejsc wchodzac i wychodzac z hangaru
    private final Gate gate;

    // kolejka oczekujacych na wejscie do hangaru
    private final List<ProblemObject> queue;

    // lista ktora przechowuje informacje na temat obiektow znajdujacych sie wewnatrz hangaru
    private final List<ProblemObject> inside;

    public Hangar(){
        gate = new Gate(10);
        queue = new ArrayList<>();
        inside = new ArrayList<>();
    }

    // metoda ma za zadanie policzyc ilosc wystapien podanego typu obiektow w okreslonym miejscu
    public int count(What what, Where where){
        // wybranie listy w ktorej bedzie wykonywane obliczanie. kolejka oczekujacych lub lista z obiektami w hangarze
        List<ProblemObject> source = switch(where){
            case QUEUE -> queue;
            case INSIDE -> inside;
        };

        // obliczenie wystapien podanego typu obiektow
        int counter = 0;
        switch(what){
            case BOSS -> {
                for(ProblemObject o : source){
                    if(o instanceof Boss) ++counter; // jesli o jest typu Boss to zwieksz counter
                }
            }
            case TRAIN -> {
                for(ProblemObject o : source){
                    if(o instanceof Train) ++counter;
                }
            }
            default -> {}
        }
        return counter; // zwrocenie obliczonej wartosci
    }

    public synchronized void add(ProblemObject object, HelloController controller) throws Exception{
        if(object == null) return;
        this.controller = controller;

        queue.add(object); // dodanie obiektu do kolejki oczekujacych
        while(true){ // petla do momentu dodania do hangaru
            if(isAvailableFor(object)){ // funckja sprawdza czy mozna dany obiekt dodac do hangaru -> opisana nizej
                queue.remove(object); // usuniecie elementu z kolejki oczekujacych
                gate.goThrough(object, "Entering through the gate. "); // przejscie przez brame -> cale przejscie przez brame jest w metodzie synchronized zatem przed brama nie beda sie tworzyc kolejki

                controller.pociagBramaWjazd();

                char name = object.name;
                for(int i=0; i<5; i++) {
                    if(tab[i]==0) {
                        tab[i]=name;
                        gdzie = i+1;
                        break;
                    }
                }
                switch (gdzie) {
                    case 1:
                        controller.pociag1wjazd();
                        break;
                    case 2:
                        controller.pociag2wjazd();
                        break;
                    case 3:
                        controller.pociag3wjazd();
                        break;
                    case 4:
                        controller.pociag4wjazd();
                        break;
                    case 5:
                        controller.pociag5wjazd();
                        break;
                    default:
                        break;
                }


/* Tablica od 0 - 5 wartość i+1 z pętli to numer hangaru do którego pojechał właśnie pociąg
    jeśli przejechał przez bramę to od razu udaje się do określonego hangaru
 */
                for(int i=0; i<5; i++) {
                    System.out.print("" + i + " " + tab[i] + " ");
                }
                System.out.println();

                inside.add(object); // dodanie obiektu do list obiektow znajdujacych sie wewnatrz hangaru
                System.out.println(this); // wypisanie danych na temat hangaru
                break;
            }else{
                wait(); // zatrzymanie watku gdy nie mozna dolaczyc
            }
        }
    }

    public synchronized void remove(ProblemObject object, HelloController controller) throws Exception{
        inside.remove(object); // usuniecie obiektu z list obiektow znajdujacych sie wewnatrz hangaru
        this.controller = controller;
        // moje
        int i=0;
        if(count(What.BOSS, Where.QUEUE)==1) {
            i=2;

            System.out.println("Nadchodzi szef!");
        }

        gate.goThrough(object, "Exiting through the gate. " ); // wyjscie przez brame
        char name2 = object.name;
        for(i=0; i<5; i++) {
            if(tab[i]==name2) {
                tab[i]=0;
                skad = i+1;
                break;
            }
        }
/* Wyjazd przez bramę
tablica pokazująca które miejsce w hangarze się zwalnia - i+1
*/


        for(i=0; i<5; i++) {
            System.out.print("" + i + " " + tab[i] + " ");
        }
        System.out.println();



        if(object instanceof Boss) System.out.println("Wyszedł szefunio!");
// Wychodzi szef - czarne tło zmienia się na biale


        if(i==2 && count(What.TRAIN, Where.INSIDE)==0) {
            System.out.println("Wchodzi szefunio :)");
            i=1;
        }
//Wchodzi szef - białe tło zmienia się na czarne
        notifyAll(); // powiadomienie innych oczekujacych watkow
        switch (skad) {
            case 1:
                controller.pociag1wyjazd();
                break;
            case 2:
                controller.pociag2wyjazd();
                break;
            case 3:
                controller.pociag3wyjazd();
                break;
            case 4:
                controller.pociag4wyjazd();
                break;
            case 5:
                controller.pociag5wyjazd();
                break;
            default:
                break;
        }
        controller.pociagBramaWyjazd();

    }

    @Override
    public String toString() {
        return "Hangar status: Inside (bosses: " + count(What.BOSS, Where.INSIDE) + " trains: " + count(What.TRAIN, Where.INSIDE) + " ) " +
                "Queue (bosses: " + count(What.BOSS, Where.QUEUE) + " trains: " + count(What.TRAIN, Where.QUEUE) + " )";
    }
//Tu się wyświetla kolejka pociągów, może by gdzieś z boku dać pole z liczbą pociągów czekających w kolejce


    private boolean isAvailableFor(ProblemObject object) //throws InvalidAttributeValueException
    {
        if(object instanceof Boss){ // jesli obiekt to szef to:
            return inside.isEmpty(); // sprawdz czy hangar jest pusty
        }else
            //if(object instanceof Train){ // jesli obiekt to pociag to:
            return count(What.BOSS, Where.INSIDE)==0 && count(What.BOSS, Where.QUEUE)==0 && inside.size() < N; // sprawdz w hangarze nie ma szefa && sprawdz czy w kolejce nie ma szefa && sprawdz czy jest miejsce w hangarze
 //       }
//        else
//        {
//            throw new InvalidAttributeValueException("The class object is neither Boss nor Train"); // obiekt inny niz pociag i szef -> wyrzuc wyjatek
//        }
    }
}

