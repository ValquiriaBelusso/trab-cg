package com.unioeste.trabcg.Models;

import java.io.Serializable;
import java.util.ArrayList;

public class Face implements Serializable {

    ArrayList<Aresta> arestas = new ArrayList<>();

    public Face() {
    }

    public void imprimeFace(){
        for(Aresta a: arestas){
            System.out.println(a.ini+" --> "+a.fim);
        }
    }
}
