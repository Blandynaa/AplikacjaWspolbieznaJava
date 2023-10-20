package pociagi2.pociaginauka2;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;
import java.util.Scanner;

public class HelloApplication extends Application {
    static AnchorPane root;

    @Override
    public void start(Stage primaryStage) throws Exception {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(this.getClass().getResource("/fxml/scena1.fxml"));
        int x;
        root = loader.load();

        HelloController controller = loader.getController();

        Scene scene =new Scene(root);

        primaryStage.setScene(scene);
        primaryStage.setResizable(false);

        primaryStage.setTitle("ciuch ciuch");
        primaryStage.show();
        Scanner scanner= new Scanner(System.in);
        System.out.print("Podaj ilość pociągów (max20):  ");
        x=scanner.nextInt();
        System.out.print("Podaj czas przejazdu [s]:  ");
        controller.n= scanner.nextInt();
        controller.n = 1000*controller.n;

        Hangar hangar = new Hangar();
        // tablica na obiekty ktore moga przebywac w hangarze
        ProblemObject []objects = new ProblemObject[21];

        // tworzenie szefow
        objects[0] = new Boss(hangar,controller, 'Z', controller.n,controller.n*2, 3);
        //objects[n-1] = new Boss(hangar, "Pan Zabka", 30,50, 5);

        for(int j=1; j<=x; j++)
        objects[j] = new Train(hangar, controller, (char)(64+j), controller.n, controller.n*2, 3);
        // tworzenie pociagow
//        objects[1] = new Train(hangar, controller, "A", 10000,30000, 5);
//        objects[2] = new Train(hangar, controller, "B", 10000,30000, 5);
//        objects[3] = new Train(hangar, controller, "C", 10000,30000, 5);
//        objects[4] = new Train(hangar, controller, "D", 10000,30000, 5);
//        objects[5] = new Train(hangar, controller, "E", 10000,30000, 5);
//        objects[6] = new Train(hangar, controller, "F", 10000,30000, 5);
//        objects[7] = new Train(hangar, controller, "G", 10000,30000, 5);
//        objects[8] = new Train(hangar, controller, "H", 10000,30000, 5);
//        objects[9] = new Train(hangar, controller, "I", 10000,30000, 5);
//        objects[10] = new Train(hangar, controller, "J", 10000,30000, 5);
//        objects[11] = new Train(hangar, controller, "K", 10000,30000, 5);
//        objects[12] = new Train(hangar, controller, "L", 10000,30000, 5);

        // petla uruchamia wszystkie watki
        for(int k=0; k<=x; ++k){
            objects[k].start();
        }
    }

    public static void main(String[] args) {

        launch();

    }
}