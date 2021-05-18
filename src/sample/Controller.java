package sample;

import javafx.event.ActionEvent;

import javafx.scene.control.*;
import java.text.DecimalFormat;
import java.util.Optional;

public class Controller {

    public TextField tfPromien;
    public TextField tfWysokosc;
    public TextField tfGrubosc;
    public Button bWylicz;
    public Label lNormalnejWaga;
    public Label lNormalnejKoszt;
    public Label lNierdzewnejWaga;
    public Label lNierdzewnejKoszt;

    public static boolean isNumeric(String strNum) {
        if (strNum == null) {
            return false;
        }
        try {
            double d = Double.parseDouble(strNum);
        } catch (NumberFormatException nfe) {
            return false;
        }
        return true;
    }

    public void wylicz(ActionEvent actionEvent) {
        if (!isNumeric(tfPromien.getText()))
        {
            TextInputDialog dialog = new TextInputDialog();
            dialog.setHeaderText("Nieprawidłowa wartość promienia walca");
            Optional<String> result = dialog.showAndWait();
            return;
        }
        if (!isNumeric(tfWysokosc.getText()))
        {
            TextInputDialog dialog = new TextInputDialog();
            dialog.setHeaderText("Nieprawidłowa wartość wysokości walca");
            Optional<String> result = dialog.showAndWait();
            return;
        }
        if (!isNumeric(tfGrubosc.getText()))
        {
            TextInputDialog dialog = new TextInputDialog();
            dialog.setHeaderText("Nieprawidłowa wartość grubosci walca");
            Optional<String> result = dialog.showAndWait();
            return;
        }



        double normalnejGestosc = 7800;
        double nierdzewnejGestosc = 7900;
        double normalnejKoszt = 3.10;
        double nierdzewnejKoszt = 6.20;



        float promien =  Float.parseFloat(tfPromien.getText());
        float wysokosc =  Float.parseFloat(tfWysokosc.getText());
        float grubosc =  Float.parseFloat(tfGrubosc.getText());


        double totalArea = 2 * Math.PI * Math.pow(promien, 2) + 2 * Math.PI * promien * wysokosc;
        double bordersLength = Math.sqrt(totalArea);
        double area = Math.pow(bordersLength, 2) * grubosc;

        double normalnejWaga = area * normalnejGestosc;
        double nierdzewnejWaga = area * nierdzewnejGestosc;



        DecimalFormat df = new DecimalFormat("###.##");
        lNormalnejWaga.setText(df.format(normalnejWaga / 1000));
        lNierdzewnejWaga.setText(df.format(nierdzewnejWaga / 1000));
        lNormalnejKoszt.setText(df.format(normalnejWaga * normalnejKoszt));
        lNierdzewnejKoszt.setText(df.format(nierdzewnejWaga * nierdzewnejKoszt));
    }
}



