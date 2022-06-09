package com.unioeste.trabcg.Models;

public class Camera {

    Ponto vrp, p;
    Ponto viewUp;
    String tipoProjeção;
    Double distNear, distFar;
    Plano planoProjeção;

    public void Camera(Ponto vrp, Ponto p, Ponto viewUp, String tipoProjeção, Double distNear, Double distFar, Plano planoProjeção) {
        this.vrp = vrp;
        this.p = p;
        this.viewUp = viewUp;
        this.tipoProjeção = tipoProjeção;
        this.distNear = distNear;
        this.distFar = distFar;
        this.planoProjeção = planoProjeção;
    }
}
