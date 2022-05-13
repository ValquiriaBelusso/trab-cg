package com.unioeste.trabcg.Model;

import java.util.ArrayList;

public class Esfera {
    double r;
    int meridianos, paralelos;
    Vertice centro;

    public ArrayList<Vertice> vertices;
    public ArrayList<Aresta> arestas;
    public ArrayList<Face> faces;

    public Esfera(double r, int meridianos, int paralelos, Vertice centro) {
        this.r = r;
        this.meridianos = meridianos;
        this.paralelos = paralelos;
        this.centro = centro;
        this.vertices = new ArrayList<>();
        this.arestas = new ArrayList<>();
        this.faces = new ArrayList<>();
    }

    public Esfera(double r, int meridianos, int paralelos) {
        this(r, meridianos, paralelos, new Vertice(0, 0, 0));
    }

    public Esfera() {
    }


    public void criaEsfera(){
        Vertice vx = new Vertice(r, 0, 0), vn = new Vertice(-r, 0, 0), c = new Vertice(0, 0, 0);
//        Aresta aresta = new Aresta(c,vx);
        double x,y,alpha = (double) 360 / paralelos;
        double seno = Math.sin(Math.toRadians(alpha));
        double cose = Math.cos(Math.toRadians(alpha));
        Vertice anterior = new Vertice();
        anterior=vx;
        vertices.add(vx);

        //código de rotação
        for(int i=0; i<paralelos; i++){
            if(i==(paralelos-1)){
                Aresta a = new Aresta(anterior,vx);
                arestas.add(a);
            }else{
                Vertice novo = new Vertice();
                novo.x=(anterior.x*cose)-(anterior.y*seno);
                novo.y=(anterior.x*seno)+(anterior.y*cose);
                Aresta a = new Aresta(anterior,novo);
                arestas.add(a);
                vertices.add(a.ini);
                anterior=novo;
            }

        }


    }

    public void translada(double dx, double dy, double dz){

        for(Aresta a : arestas){
            a.ini.x=+dx;
            a.ini.y=+dy;
            a.ini.z=+dz;
        }

    }



}
