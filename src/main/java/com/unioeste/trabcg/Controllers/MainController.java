package com.unioeste.trabcg.Controllers;

import com.unioeste.trabcg.Models.Esfera;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Objects;
import java.util.ResourceBundle;

public class MainController {

    private ArrayList<Esfera> esferas;
    private int state = 1;

        @FXML
    private Canvas canvas;

    @FXML
    private TextField textFieldParalelos;
    @FXML
    private TextField textFieldMeridianos;
    @FXML
    private TextField textFieldRaio;
    @FXML
    private TextField textFieldCentro;

    @FXML
    protected void onCreateSphereClick() {
        int raio = Integer.parseInt(textFieldRaio.getText());
        int meridianos = Integer.parseInt(textFieldMeridianos.getText());
        int paralelos = Integer.parseInt(textFieldParalelos.getText());
        GraphicsContext gc = canvas.getGraphicsContext2D();
        Esfera e = new Esfera(raio, meridianos, paralelos);
        e.criaEsfera(gc);
        e.translada(200, 200, 0, gc);
        e.rotacionaEsfera(50, 'y');

        e.draw(gc);
    }



    @FXML
    private void selectOptionCreateSphere(ActionEvent event) {
        // carrega o FXML CreateSpherePannel
        System.out.println("click! taskBarButton2");
    }

}