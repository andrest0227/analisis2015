package com.numericos.proyectofinal.logic;

/**
 * Created by Sara Castrillón on 22/11/2014.
 */
public class Simpson1_3 {
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
    public Simpson1_3() {
        // this.fx = new Funcion(funcion);
        //mensaje= "";
    }

    public String simpson1_3Method(double x0, double xn){
        double h= (xn - x0)/2;
        double integ = f(x0);
        res = "";
        integ += 4*f(x0+h);
        integ += f(xn);
        integ = (h/3)*integ;
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
}
