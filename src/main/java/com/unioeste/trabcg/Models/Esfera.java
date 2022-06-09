package com.unioeste.trabcg.Models;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

import java.util.ArrayList;

import static java.lang.Math.toRadians;

public class Esfera {
    double r;
    int meridianos, paralelos;
    Ponto centro;

    public ArrayList<Ponto> vertices;
    public ArrayList<Aresta> arestas;
    public ArrayList<Face> faces;

    public Esfera(double r, int meridianos, int paralelos, Ponto centro) {
        this.r = r;
        this.meridianos = meridianos;
        this.paralelos = paralelos;
        this.centro = centro;
        this.vertices = new ArrayList<>();
        this.arestas = new ArrayList<>();
        this.faces = new ArrayList<>();
    }

    public Esfera(double r, int meridianos, int paralelos) {
        this(r, meridianos, paralelos, new Ponto(0, 0, 0));
    }

    public Esfera() {
    }

    public void draw(GraphicsContext gc) {
        for (Aresta a : this.arestas) {
            a.draw(gc);
        }

    }


    public void criaEsfera(GraphicsContext gc) {
        Ponto vx = new Ponto(r, 0, 0), vn = new Ponto(-r, 0, 0), c = new Ponto(0, 0, 0);
//        Aresta aresta = new Aresta(c,vx);

        double x, y, alpha = (double) 180 / (paralelos + 1);
        double seno = Math.sin(toRadians(alpha));
        double cose = Math.cos(toRadians(alpha));
        geraSemiCirculo(vx, seno, cose);

        double beta = toRadians(360) / meridianos;

        ArrayList<Aresta> arestasAntigas = new ArrayList<>();
        ArrayList<Aresta> arestasNovas = new ArrayList<>();
        ArrayList<Ponto> verticesAntigos = new ArrayList<>();
        ArrayList<Ponto> verticesNovos = new ArrayList<>();

        for(Aresta a: arestas){
            Ponto vaux1 = new Ponto(a.ini.x,a.ini.y,a.ini.z);
            Ponto vaux2 = new Ponto(a.fim.x,a.fim.y,a.fim.z);
            Aresta aux = new Aresta(vaux1,vaux2);
            arestasAntigas.add(aux);
        }
        for(Ponto v: vertices){
            Ponto vaux1 = new Ponto(v.x,v.y,v.z);
            verticesAntigos.add(vaux1);
        }

        for(int i=0; i<meridianos; i++){
            for(Ponto v: verticesAntigos){
                Ponto vaux1 = new Ponto(v.x,v.y,v.z);
                verticesNovos.add(vaux1);
            }
            rotaciona(verticesNovos,beta,'x');
            //atualiza arestas
            for(int j=0; j<verticesNovos.size()-1; j++){
                Aresta a= new Aresta(verticesNovos.get(j),verticesNovos.get(j+1));
                arestasNovas.add(a);
            }
            vertices.addAll(verticesNovos);
            arestas.addAll(arestasNovas);
            verticesAntigos.clear();
            verticesAntigos.addAll(verticesNovos);
            verticesNovos.clear();
        }




    }

    private void geraSemiCirculo(Ponto vx, double seno, double cose) {
        Ponto anterior;
        anterior = vx;
        int n = paralelos + 1;

        //código de rotação em Z
        for (int i = 0; i < n + 1; i++) {
            if (i == n) {
                vertices.add(anterior);
                break;
            }
            Ponto novo = new Ponto();
            novo.x = (anterior.x * cose) - (anterior.y * seno);
            novo.y = (anterior.x * seno) + (anterior.y * cose);
            Aresta a = new Aresta(anterior, novo);
            arestas.add(a);
            vertices.add(a.ini);
            anterior = novo;
        }
    }
    public void rotacionaEsfera(double graus, char eixo){
        rotaciona(this.vertices, Math.toRadians(graus),eixo);
    }

    private void rotaciona(ArrayList<Ponto> vert, double radians, char eixo) {
        if (eixo == 'x') {
            double seno = Math.sin(radians);
            double cose = Math.cos(radians);
            double ante = 0;
            for (Ponto v : vert) {
                ante = (v.z * cose) - (v.y * seno);
                v.y = (v.z * seno) + (v.y * cose);
                v.z = ante;
            }
            ante = (this.centro.z * cose) - (this.centro.y * seno);
            this.centro.y = (this.centro.z * seno) + (this.centro.y * cose);
            this.centro.z = ante;


        } else if (eixo == 'y') {
            double seno = Math.sin(radians);
            double cose = Math.cos(radians);
            double ante = 0;
            for (Ponto v : vert) {
                ante = (v.x * cose) + (v.z * seno);
                v.z = (v.z * cose) - (v.x * seno);
                v.x = ante;
            }
            ante = (this.centro.x * cose) + (this.centro.z * seno);
            this.centro.z = (this.centro.z * cose) - (this.centro.x * seno);
            this.centro.x = ante;

        } else if (eixo == 'z') {
            double seno = Math.sin(radians);
            double cose = Math.cos(radians);
            double ante = 0;
            for (Ponto v : vert) {
                ante = (v.x * cose) - (v.y * seno);
                v.y = (v.x * seno) + (v.y * cose);
                v.x = ante;
            }
//            ante = (this.centro.x * cose) - (this.centro.y * seno);
//            this.centro.y = (this.centro.x * seno) + (this.centro.y * cose);
//            this.centro.x = ante;
        }
    }

    public void translada(double dx, double dy, double dz, GraphicsContext gc) {
        for (Ponto v : vertices) {
            v.x += dx;
            v.y += dy;
            v.z += dz;
        }

//        for (Aresta a : arestas) {
//            a.ini.x += dx;
//            a.ini.y += dy;
//            a.ini.z += dz;
//        }
    }


}
