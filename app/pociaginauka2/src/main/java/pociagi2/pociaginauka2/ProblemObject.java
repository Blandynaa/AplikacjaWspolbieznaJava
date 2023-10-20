package pociagi2.pociaginauka2;

import java.util.Random;

public abstract class ProblemObject extends Thread{
    HelloController controller;

    // imie obiektu
    protected final char name;

    // opoznienie pomiedzy wykonywaniem operacji w ms
    protected final int delayInMS;

    // hangar z ktorego bedzie korzystal obiekt
    protected final Hangar hangar;

    // ilosc prob wejsc do hangaru. kazdy obiekt zanim zakonczy dzialanie wejdzie tryCount razy
    protected final int tryCount;

    public ProblemObject(Hangar hangar, HelloController controller, char name, int lowerMSBound, int upperMSBound, int tryCount){
        this.name = name;
        this.controller = controller;
        this.tryCount = tryCount;
        this.delayInMS = Math.max(0, new Random().nextInt(lowerMSBound, upperMSBound));
        this.hangar = hangar;
    }

    public ProblemObject(Hangar hangar, char name){
        this(hangar, hangar.controller, name, 2000, 5000, 5);
    }

    protected void enter() throws Exception{
        this.controller = controller;
        hangar.add(this, controller); // dodanie obiektu do hangaru -> logika dodawnia odbywa sie wewnatrz funkcji add hangaru
        Thread.sleep(delayInMS); // opoznienie w dodaniu
    }

    protected void fix() throws InterruptedException{
        Thread.sleep(delayInMS); // opoznienie w przeprowadzaniu naprawy/kontroli
    }

    protected void leave() throws Exception{
        hangar.remove(this, controller); // usuniecie obiektu z hangaru -> logika usuwania odbywa sie wewnatrz funkcji remove hangaru
        Thread.sleep(delayInMS); // opoznienie w usunieciu
    }

    @Override
    public void run() {
        try{
            int counter = 0;
            // glona petla watku
            do {
                enter(); // watek wchodzi do hangaru. metoda konczy dzialanie gdy uda sie wejsc inaczej watek ktoremu nie udalo sie wejsc czeka
                fix(); // odczekanie na naprawe/kontrole
                leave(); // wyjdzie z hangaru
                Thread.sleep(2L * delayInMS); // opoznienie w kolejnej probie dolaczenia do hangaru
            } while (++counter < tryCount);
        }catch(InterruptedException e){
            System.out.println("Thread was interrupted. Message: " + e.getMessage());
            Thread.currentThread().interrupt(); // ponowne przerwanie watku ktory zostal juz przerwany
        }catch(Exception e){
            System.out.println("Unexpected exception occurred. The exception message: " + e.getMessage());
        }
    }

    @Override
    public String toString() {
        return "Object{" + "name: '" + name + "'}";
    }
}
