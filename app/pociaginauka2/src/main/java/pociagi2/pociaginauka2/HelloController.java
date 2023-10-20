package pociagi2.pociaginauka2;

import javafx.animation.TranslateTransition;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;

import java.net.URL;
import java.util.ResourceBundle;

public class HelloController implements Initializable {

    public static int n;

    @FXML
    private Button przycisk2;
    @FXML
    private Button przycisk1;
    @FXML
    private Label labelname;
    @FXML
    private Rectangle pociagbramawjazd;
    @FXML
    private Rectangle pociag1wjazd;
    @FXML
    private Rectangle pociag1wyjazd;
    @FXML
    private Rectangle pociag2wjazd;
    @FXML
    private Rectangle pociag2wyjazd;
    @FXML
    private Rectangle pociag3wjazd;
    @FXML
    private Rectangle pociag3wyjazd;
    @FXML
    private Rectangle pociag4wjazd;
    @FXML
    private Rectangle pociag4wyjazd;
    @FXML
    private Rectangle pociag5wjazd;
    @FXML
    private Rectangle pociag5wyjazd;
    @FXML
    private Rectangle pociagbramawyjazd;

    public static void czekaj(int ms){
        try
        {
            Thread.sleep(ms);
        }
        catch(InterruptedException ex)
        {
            Thread.currentThread().interrupt();
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle){
        przycisk1.setText("zwolnij");
        przycisk2.setText("przyspiesz");
        pociagbramawjazd.setHeight(20);
        pociag1wjazd.setHeight(20);
        pociag1wyjazd.setHeight(20);
        pociag2wjazd.setHeight(20);
        pociag2wyjazd.setHeight(20);
        pociag3wjazd.setHeight(20);
        pociag3wyjazd.setHeight(20);
        pociag4wjazd.setHeight(20);
        pociag5wjazd.setHeight(20);
        pociag4wyjazd.setHeight(20);
        pociag5wyjazd.setHeight(20);
        pociagbramawyjazd.setHeight(20);

    }
    @FXML
    public void przyspiesz(){
        n=n/2;
    }
    @FXML
    public void zwolnij(){
        n=2*n;
    }

    @FXML
    public void onActionEntered() {
        TranslateTransition transition = new TranslateTransition();
        transition.setDuration(Duration.seconds(n));
        transition.setNode(pociag3wyjazd);
        transition.setToX(-120);
        transition.setToY(72);
        transition.setAutoReverse(true);
        transition.setCycleCount(1);
        transition.setFromX(0);
        transition.setFromY(0);
        transition.playFromStart();
    }

    @FXML
    public void pociagBramaWyjazd(){
        TranslateTransition transition1 = new TranslateTransition();
        transition1.setDuration(Duration.millis(n));
        transition1.setNode(pociagbramawyjazd);
        czekaj(n);
        transition1.setToY(300);
        transition1.setCycleCount(1);
        transition1.play();
        transition1.setFromX(0);
        transition1.setFromY(0);
        transition1.playFromStart();
    }

    public void pociag1wjazd(){
        TranslateTransition transition2 = new TranslateTransition();
        transition2.setDuration(Duration.millis(n));
        transition2.setNode(pociag1wjazd);
        czekaj(n);
        transition2.setToX(120);
        transition2.setToY(72);
        transition2.setAutoReverse(true);
        transition2.setCycleCount(1);
        transition2.setFromX(0);
        transition2.setFromY(0);
        transition2.playFromStart();

    }
    public void pociag1wyjazd(){
        TranslateTransition transition3 = new TranslateTransition();
        transition3.setDuration(Duration.millis(n));
        transition3.setNode(pociag1wyjazd);
        transition3.setToX(-120);
        transition3.setToY(-72);
        transition3.setAutoReverse(true);
        transition3.setCycleCount(1);
        transition3.setFromX(0);
        transition3.setFromY(0);
        transition3.playFromStart();

    }
    public void pociag2wjazd(){
        TranslateTransition transition4 = new TranslateTransition();
        transition4.setDuration(Duration.millis(n));
        transition4.setNode(pociag2wjazd);
        czekaj(n);
        transition4.setToX(120);
        transition4.setToY(-72);
        transition4.setAutoReverse(true);
        transition4.setCycleCount(1);
        transition4.setFromX(0);
        transition4.setFromY(0);
        transition4.playFromStart();

    }

    public void pociag2wyjazd(){
        TranslateTransition transition5 = new TranslateTransition();
        transition5.setDuration(Duration.millis(n));
        transition5.setNode(pociag2wyjazd);
        transition5.setToX(-120);
        transition5.setToY(72);
        transition5.setAutoReverse(true);
        transition5.setCycleCount(1);
        transition5.setFromX(0);
        transition5.setFromY(0);
        transition5.playFromStart();

    }

    public void pociag3wjazd(){
        TranslateTransition transition6 = new TranslateTransition();
        transition6.setDuration(Duration.millis(n));
        transition6.setNode(pociag3wjazd);
        czekaj(n);
        transition6.setToX(0);
        transition6.setToY(-120);
        transition6.setAutoReverse(true);
        transition6.setCycleCount(1);
        transition6.setFromX(0);
        transition6.setFromY(0);
        transition6.playFromStart();

    }

    public void pociag3wyjazd(){
        TranslateTransition transition7 = new TranslateTransition();
        transition7.setDuration(Duration.millis(n));
        transition7.setNode(pociag3wyjazd);
        transition7.setToX(0);
        transition7.setToY(130);
        transition7.setAutoReverse(true);
        transition7.setCycleCount(1);
        transition7.setFromX(0);
        transition7.setFromY(0);
        transition7.playFromStart();

    }
    public void pociag4wjazd(){
        TranslateTransition transition8 = new TranslateTransition();
        transition8.setDuration(Duration.millis(n));
        transition8.setNode(pociag4wjazd);
        czekaj(n);
        transition8.setToX(-120);
        transition8.setToY(-72);
        transition8.setAutoReverse(true);
        transition8.setCycleCount(1);
        transition8.setFromX(0);
        transition8.setFromY(0);
        transition8.playFromStart();

    }

    public void pociag4wyjazd(){
        TranslateTransition transition9 = new TranslateTransition();
        transition9.setDuration(Duration.millis(n));
        transition9.setNode(pociag4wyjazd);
        transition9.setToX(120);
        transition9.setToY(72);
        transition9.setAutoReverse(true);
        transition9.setCycleCount(1);
        transition9.setFromX(0);
        transition9.setFromY(0);
        transition9.playFromStart();

    }

    public void pociag5wjazd(){
        TranslateTransition transition10 = new TranslateTransition();
        transition10.setDuration(Duration.millis(n));
        transition10.setNode(pociag5wjazd);
        czekaj(n);
        transition10.setToX(-120);
        transition10.setToY(72);
        transition10.setAutoReverse(true);
        transition10.setCycleCount(1);
        transition10.setFromX(0);
        transition10.setFromY(0);
        transition10.playFromStart();

    }
    public void pociag5wyjazd(){
        TranslateTransition transition = new TranslateTransition();
        transition.setDuration(Duration.millis(n));
        transition.setNode(pociag5wyjazd);
        transition.setToX(120);
        transition.setToY(-72);
        transition.setAutoReverse(true);
        transition.setCycleCount(1);
        transition.setFromX(0);
        transition.setFromY(0);
        transition.playFromStart();

    }
    @FXML
    public void pociagBramaWjazd(){
        TranslateTransition transition = new TranslateTransition();
        transition.setDuration(Duration.millis(n));
        transition.setNode(pociagbramawjazd);
        transition.setToY(-300);
        transition.setCycleCount(1);
        transition.play();

        transition.setFromX(0);
        transition.setFromY(0);
        transition.playFromStart();

    }


}