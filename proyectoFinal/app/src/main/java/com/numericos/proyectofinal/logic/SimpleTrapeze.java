package com.numericos.proyectofinal.logic;

/**
 * Created by Sara Castrillón on 22/11/2014.
 */
public class SimpleTrapeze {
    private Funcion fx;
    private String res;
    private String mensaje;
    private double x0;
    private double x1;

    private double f(double x){
        x = fx.evaluar(x);
        return x;
    }

    public String getRes(){
        return res;
    }

    public String getMensaje(){
        return mensaje;
    }
    public SimpleTrapeze() {
       // this.fx = new Funcion(funcion);
        //mensaje= "";
    }

    public String simpleTrapezeMethod(double x0, double xn){
        double h= (xn - x0);
        double integ = f(x0);
        integ += f(xn);
        integ = (h/2)*integ;
        res="";
        res+="the area under the curve "+fx.getFuncion()+" interval between ("+x0+","+xn+") is: "+integ+" + E";
        return res;
    }

    public Funcion getFx() {
        return fx;
    }

    public void setFx(String funct) {
        this.fx = new Funcion(funct);
    }

    public double getX0() {
        return x0;
    }

    public void setX0(double x0) {
        this.x0 = x0;
    }

    public double getX1() {
        return x1;
    }

    public void setX1(double x1) {
        this.x1 = x1;
    }
/*
    public double getTolerance() {
        return tolerance;
    }

    public void setTolerance(double tolerance) {
        this.tolerance = tolerance;
    }



    public double getIteraciones() {
        return iteraciones;
    }

    public void setIterations(double iteraciones) {
        this.iteraciones = iteraciones;
    }*/
}
