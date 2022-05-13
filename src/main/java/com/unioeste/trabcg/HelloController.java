package com.unioeste.trabcg;

import com.unioeste.trabcg.Model.Aresta;
import com.unioeste.trabcg.Model.Esfera;
import com.unioeste.trabcg.Model.Vertice;
import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Label;

import java.util.ArrayList;

public class HelloController {

    private ArrayList<Esfera> esferas;

    @FXML
    private Label welcomeText;

    @FXML
    private Canvas canvas;

    @FXML
    protected void onHelloButtonClick() {

//        gc.moveTo();

    }

    public void buttonselect() {
        Esfera e = new Esfera(100, 8, 100);
        e.criaEsfera();
        GraphicsContext gc = canvas.getGraphicsContext2D();

//        gc.moveTo(200, 200);
//        gc.lineTo(200,200);
        e.translada();

        for(Aresta a : e.arestas){
            a.draw(gc);
        }

//
//        for (Vertice v : e.vertices) {
//            gc.moveTo(v.x + 200, v.y + 200);
//            gc.lineTo(v.x + 200, v.y + 200);
//            gc.stroke();
//        }

//        for (Aresta a: e.arestas) {
//            gc.strokeLine(a.ini.x+200,a.ini.y+200,a.fim.x+200,a.fim.y+200);
//        }
    }


}