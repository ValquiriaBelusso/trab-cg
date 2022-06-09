package com.unioeste.trabcg.Models;

import javafx.scene.canvas.GraphicsContext;

import java.io.Serializable;

import static java.lang.Math.abs;
import static java.lang.StrictMath.sqrt;

public class Aresta implements Serializable {
    public Ponto ini;
    public Ponto fim;

    public Aresta() {
        this.ini = new Ponto();
        this.fim = new Ponto();
    }

    public Aresta(Ponto ini, Ponto fim) {
        this.ini = ini;
        this.fim = fim;
    }

    public void draw(GraphicsContext gc) {
        gc.strokeLine(this.ini.x, this.ini.y, this.fim.x, this.fim.y);
    }

    public void translada(double dx, double dy, double dz) {
        this.ini.x += dx;
        this.ini.y += dy;
        this.ini.z += dz;
    }


}
