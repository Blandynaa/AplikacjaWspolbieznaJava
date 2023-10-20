package pociagi2.pociaginauka2;

import java.util.LinkedList;
import java.util.Queue;

    public class Gate {

        // opoznienie w przechodzeniu przez brame w ms
        private long delayInMS;

        // kolejka osob czekajacych na przejscie przez brame
        private final Queue<ProblemObject> queue;

        // obiekt aktualnie przechodzacy przez brame
        private ProblemObject currentlyInTheGate;

        public Gate(long delayInMS){
            this.delayInMS = delayInMS;
            this.queue = new LinkedList<>();
            this.currentlyInTheGate = null;
        }

        // metoda synchronized -> tylko 1 watek moze w tym samym czasie korzystac z tej metody
        public synchronized void goThrough(ProblemObject object, String prefix) throws InterruptedException{
            if(object == null) return;

            // dodawanie obiektu do kolejki
            queue.add(object);
            while(true){ // nieskonczona petla do momentu gdy uda sie przejsc przez brame
                if(queue.peek() == object && currentlyInTheGate == null){ // jesli brama jest pusta i object to osoba ktora aktualnie ma przechodzic przez brame to:
                    queue.remove(); // usun pierwsza osobe z kolejnki
                    currentlyInTheGate = object; // ustaw nowa osobe ktora przechodzi przez brame
                    Thread.sleep(delayInMS); // poczekaj az osoba przejdzie przez brame

                    System.out.println(prefix + this); // wyswietlw informacje o przejsciu

                    currentlyInTheGate = null; // zwolnij brame
                    notifyAll(); // powiadom inne czekajace watki ze brama jest juz wolna
                    break;
                }else{
                    wait(); // zatrzymaj watek do momentu wywolania notifyAll
                }
            }
        }

        @Override
        public String toString() {
            return "Gate: " + currentlyInTheGate;
        }
    }

