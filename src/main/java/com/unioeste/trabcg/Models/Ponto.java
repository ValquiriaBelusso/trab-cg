package com.unioeste.trabcg.Models;

import java.io.Serializable;

import static java.lang.StrictMath.sqrt;

public class Ponto implements Serializable {
    public double x;
    public double y;
    public double z;

    public Ponto(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public Ponto(double x, double y) {
        this(x, y, 0);
    }

    public Ponto() {
    }

    public double distancia(Ponto V) {
        return sqrt(Math.pow(V.x - this.x, 2) + Math.pow(V.y - this.y, 2));
    }

    public Ponto minus(Ponto v2) {
        double x = this.x - v2.x;
        double y = this.y - v2.y;
        double z = this.z - v2.z;
        return new Ponto(x,y,z);
    }

    @Override
    public String toString() {
        return "Vertice{" +
                "x=" + x +
                ", y=" + y +
                ", z=" + z +
                '}';
    }

    public boolean eIgual(Ponto v){
        if((v.x==this.x)&&(v.y==this.y)&&(v.z==this.z)){
            return true;
        }else
            return false;
    }
}
