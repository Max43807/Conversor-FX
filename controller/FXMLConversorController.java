/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conversorfx.controller;

import conversorfx.model.Temperatura;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;

/**
 *
 * @author Maxi
 */
public class FXMLConversorController implements Initializable {

    @FXML
    private Button btnConvertir;
    @FXML
    private TextField txfFahren;
    @FXML
    private TextField txfCelcius;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void BorrarOtro_OnKeyTyped(KeyEvent event) {

        //Verificar que solo uno de los textfields tenga valor:
        if (txfFahren.isFocused() && !txfCelcius.getText().isEmpty()) {
            txfCelcius.clear();
        } else if (txfCelcius.isFocused() && !txfFahren.getText().isEmpty()) {
            txfFahren.clear();
        }
    }

    @FXML
    private void Convertir_OnAction(ActionEvent event) {

        try {
            //Aqui va el codigo ssusceptible a excepciones:
            //Variables locales
            float grado = 0.0F, conversion = 0.0F;
            //Instancia de la clase temperatura:
            Temperatura t = new Temperatura();
            //Verificar que no esten vacios los cuadros
            if (txfCelcius.getText().isEmpty() && txfFahren.getText().isEmpty()) {
                mostrarError("Tiene que ingresar una temperatura.");
            } else if (!txfCelcius.getText().isEmpty()) {
                grado = Float.parseFloat(txfCelcius.getText());
                conversion = t.convertirCelsiusToFahrenheit(grado);
                //Mostrar la conversion
                txfFahren.setText(String.format("%.2f", conversion));

            } else if (!txfFahren.getText().isEmpty()) {
                grado = Float.parseFloat(txfFahren.getText());
                conversion = t.convertirFahrenheitToCelsius(grado);

                txfCelcius.setText(String.format("%.2f", conversion));

            }
        } catch (NumberFormatException e) {
            //Manejar la excepcion:
            //mostrarError("Ocurrio el error: " + e.getMessage());
            mostrarError("Ocurrio el error: Tiene que ingresar un numero " + e.getMessage());
        }

    }

    void mostrarError(String mensaje) {
        Alert msj = new Alert(Alert.AlertType.ERROR, mensaje, ButtonType.OK);
        msj.showAndWait();

    }
}
