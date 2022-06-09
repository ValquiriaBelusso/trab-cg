package com.unioeste.trabcg.Models;

public class Plano {
    Ponto p1, p2, p3 , p4, c;

    public void Plano(double xMin, double yMin, double xMax, double yMax) {
        this.p1 = new Ponto(xMin, yMin);
        this.p2 = new Ponto(xMin, yMax);
        this.p3 = new Ponto(xMax, yMax);
        this.p4 = new Ponto(xMax, yMin);
        this.c = new Ponto((xMax-xMin)/2, (yMax-yMin)/2, 0);
    }
}
