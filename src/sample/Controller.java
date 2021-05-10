package sample;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;

public class Controller {
    public Button btnMain;
    int clicCounter = 0;

    public void onBtnAction(ActionEvent actionEvent) {
        System.out.println("Kliknięcie nr " + ++clicCounter);
        if (clicCounter == 1)
            btnMain.setText("I jeszcze raz");
    }
}
